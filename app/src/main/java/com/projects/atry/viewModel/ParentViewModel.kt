package com.projects.atry.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.projects.atry.models.TalkListLineModel
import com.projects.atry.models.UserProfileDetailModel
import com.projects.atry.repository.ParentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ParentViewModel @Inject constructor(
    private val provideParentRepository: ParentRepository
) : ViewModel() {

    init {
        provideParentRepository.getUserDetail(viewModelScope)
        getTalkList(1)
    }
    val userDetail : LiveData<UserProfileDetailModel>
    get() = provideParentRepository.userDetail.asLiveData()

    val talkList : LiveData<ArrayList<TalkListLineModel>>
    get() = provideParentRepository.talkList.asLiveData()

    fun getTalkList(page:Int) {
        provideParentRepository.getTaskList(page, viewModelScope)
    }

}