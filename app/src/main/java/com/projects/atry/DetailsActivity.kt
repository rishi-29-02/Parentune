package com.projects.atry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.projects.atry.adapters.CommentsAdapter
import com.projects.atry.databinding.ActivityDetailsBinding
import com.projects.atry.models.CommentsPostModel
import com.projects.atry.models.DetailDataModel
import com.projects.atry.models.TalkListLineModel
import com.projects.atry.utils.ImageUtils
import com.projects.atry.viewModel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var viewModel: DetailViewModel
    private lateinit var commentsAdapter: CommentsAdapter

    private var userDetail : TalkListLineModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        setToolbar()
        setAdapter()
        userDetail = intent.getParcelableExtra("talkListLineModel")
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        if (userDetail != null) {
            getUserDetails(userDetail!!.talkId)
            getComments(userDetail!!.talkId)
        }

        viewModel.detailData.observe(this) {
            if (it != null) {
                setDetails(it)
            }
        }

        viewModel.commentList.observe(this) {
            if (it != null) {
                binding.tvCommentCount.text = String.format("Comments (${it.size})")
                commentsAdapter.updateData(it)
            }
        }

        viewModel.onPostComment.observe(this){
            getComments(userDetail!!.talkId)
        }

        setOnEventListeners()
    }

    private fun setToolbar() {
        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getUserDetails(talkId: String) {
        viewModel.getDetails(talkId)
    }

    private fun getComments(talkId: String) {
        viewModel.getComments(talkId)
    }

    private fun setDetails(userDetail: DetailDataModel) {
        ImageUtils.setUserImage(this, userDetail.userAvatar, binding.ivPerson)
        ImageUtils.setUserImage(this, userDetail.userAvatar, binding.ivPersonComment)
        binding.username.text = userDetail.userName
        binding.tvAge.text = userDetail.age
        binding.tvTime.text = userDetail.time
        binding.tvDesc.text = userDetail.title
    }

    private fun setAdapter() {
        commentsAdapter = CommentsAdapter(this, arrayListOf()){
            binding.tvCommentCount.text = String.format("Comments (${it})")
        }
        binding.rvComments.adapter = commentsAdapter
    }

    private fun setOnEventListeners() {
        binding.ivSend.setOnClickListener {
            if (binding.etComment.text.isEmpty()) {
                Toast.makeText(this, "Enter Comment", Toast.LENGTH_SHORT).show()
            } else {
                preparePayload()
            }
            binding.etComment.text.clear()

            // Hide the keyboard
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.etComment.windowToken, 0)
        }
    }

    private fun preparePayload() {
        val payload = CommentsPostModel(
            itemType = "talk",
            comment = binding.etComment.text.toString(),
            parentItemType = "talk",
            parentItemId = userDetail!!.talkId.toInt(),
            stickerId = "",
            itemId = userDetail!!.talkId.toInt(),
            commentType = "text"
        )

        viewModel.postComment(payload)
    }
}