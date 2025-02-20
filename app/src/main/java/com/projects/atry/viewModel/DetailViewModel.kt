package com.projects.atry.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.projects.atry.models.CommentModel
import com.projects.atry.models.CommentPostResponseModel
import com.projects.atry.models.CommentsPostModel
import com.projects.atry.models.DetailDataModel
import com.projects.atry.repository.ParentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val provideParentRepository: ParentRepository
) : ViewModel() {

    val detailData : LiveData<DetailDataModel>
    get() = provideParentRepository.detailModel.asLiveData()

    val commentList : LiveData<ArrayList<CommentModel>>
    get() = provideParentRepository.commentList.asLiveData()

    val onPostComment : LiveData<CommentPostResponseModel>
    get() = provideParentRepository.onPostComment.asLiveData()

    fun getDetails(itemId:String) {
        provideParentRepository.getDetails(itemId, viewModelScope)
    }

    fun getComments(itemId: String) {
        provideParentRepository.getComments(itemId, viewModelScope)
    }

    fun postComment(payload: CommentsPostModel) {
        provideParentRepository.postComment(payload, viewModelScope)
    }

}