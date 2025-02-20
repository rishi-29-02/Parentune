package com.projects.atry.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.projects.atry.R
import com.projects.atry.databinding.ItemCommentBinding
import com.projects.atry.models.CommentModel
import com.projects.atry.utils.ImageUtils

class CommentsAdapter(
    var context: Context,
    val data : ArrayList<CommentModel>,
    val OnDeleteClicked : (Int) -> Unit
) : RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        return CommentsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_comment,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size


    inner class CommentsViewHolder(private val itemCommentBinding: ItemCommentBinding)
        : RecyclerView.ViewHolder(itemCommentBinding.root) {
        fun bind(model: CommentModel) {
            ImageUtils.setUserImage(context, model.userAvatar, itemCommentBinding.ivPerson)
            itemCommentBinding.username.text = model.userName
            itemCommentBinding.tvAge.text = model.userDetail
            itemCommentBinding.tvComment.text = model.comment

            itemCommentBinding.ivDelete.setOnClickListener {
                val adapterPosition = adapterPosition
                if (adapterPosition != RecyclerView.NO_POSITION){
                    data.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                    notifyItemRangeChanged(adapterPosition, data.size)
                }
                OnDeleteClicked(data.size)
            }
        }
    }

    fun updateData(commentModels: ArrayList<CommentModel>) {
        data.clear()
        data.addAll(commentModels)
        notifyDataSetChanged()
    }
}