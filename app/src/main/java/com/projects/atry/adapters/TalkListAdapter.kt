package com.projects.atry.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.projects.atry.R
import com.projects.atry.databinding.ItemTalklistBinding
import com.projects.atry.models.TalkListLineModel
import com.projects.atry.utils.ImageUtils

class TalkListAdapter(
    val context: Context,
    val data: ArrayList<TalkListLineModel>,
    val onTalkListClicked: (TalkListLineModel) -> Unit
) : RecyclerView.Adapter<TalkListAdapter.TalkListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TalkListViewHolder {
        return TalkListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_talklist,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: TalkListViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class TalkListViewHolder(private val itemTalklistBinding: ItemTalklistBinding)
        : RecyclerView.ViewHolder(itemTalklistBinding.root) {
            fun bind(model: TalkListLineModel) {
                ImageUtils.setUserImage(context, model.userAvatar, itemTalklistBinding.ivPerson)
                itemTalklistBinding.username.text = model.userName
                itemTalklistBinding.tvAge.text = model.age
                itemTalklistBinding.tvTime.text = model.time
                if (model.isNearby) {
                    itemTalklistBinding.ivNearby.visibility = View.VISIBLE
                } else {
                    itemTalklistBinding.ivNearby.visibility = View.GONE
                }
                itemTalklistBinding.tvDesc.text = model.title

                itemView.setOnClickListener {
                    onTalkListClicked(model)
                }
            }
    }

    fun updateData(talkListLineModels: ArrayList<TalkListLineModel>) {
        val previousSize = data.size
        data.addAll(talkListLineModels)
        notifyItemRangeInserted(previousSize, talkListLineModels.size)

    }
}