package com.projects.atry

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.projects.atry.adapters.TalkListAdapter
import com.projects.atry.databinding.ActivityMainBinding
import com.projects.atry.models.TalkListLineModel
import com.projects.atry.utils.ImageUtils
import com.projects.atry.viewModel.ParentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ParentViewModel
    private lateinit var talkListAdapter: TalkListAdapter

    private var currentPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        setAdapter()

        viewModel = ViewModelProvider(this)[ParentViewModel::class.java]

        viewModel.userDetail.observe(this) {
            ImageUtils.setUserImage(this, it.avatar, binding.ivPerson)
            binding.username.text = it.name
        }

        viewModel.talkList.observe(this) {
            if (it.isNotEmpty()) {
                binding.progressbar.visibility = View.GONE
                talkListAdapter.updateData(it)
            }
        }

        updateChipSelection(binding.cg1)
        setOnEventListeners()
    }

    private fun setAdapter() {
        talkListAdapter = TalkListAdapter(this, arrayListOf()) {
            navigateToParentTalkActivity(it)
        }
        binding.rvTaskList.adapter = talkListAdapter
    }

    private fun setOnEventListeners() {
        binding.cg1.setOnClickListener {
            updateChipSelection(binding.cg1)
        }

        binding.cg2.setOnClickListener {
            updateChipSelection(binding.cg2)
        }

        binding.cg3.setOnClickListener {
            updateChipSelection(binding.cg3)
        }

        binding.cg4.setOnClickListener {
            updateChipSelection(binding.cg4)
        }

        binding.rvTaskList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                val threshold = 3

                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount - threshold
                    && firstVisibleItemPosition >= 0
                ) {
                    if (currentPage<6) {
                        loadNextPage()
                    }
                }
            }
        })
    }

    fun loadNextPage() {
        currentPage++
        viewModel.getTalkList(currentPage)
    }

    private fun updateChipSelection(selectedChip: Chip) {
        val chipList = listOf(binding.cg1, binding.cg2, binding.cg3, binding.cg4)

        chipList.forEach { chip ->
            if (chip == selectedChip) {
                chip.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.selectedChip))
                chip.setTextColor(Color.WHITE)
                chip.chipStrokeWidth = 0f
            } else {
                chip.chipBackgroundColor = null
                chip.chipStrokeColor = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.grey))
                chip.setTextColor(ContextCompat.getColor(this, R.color.black))
                chip.chipStrokeWidth = 5f
            }
        }
    }

    private fun navigateToParentTalkActivity(talkListLineModel: TalkListLineModel) {
        Intent(this, DetailsActivity::class.java).apply {
            putExtra("talkListLineModel", talkListLineModel)
            startActivity(this)
        }
    }
}