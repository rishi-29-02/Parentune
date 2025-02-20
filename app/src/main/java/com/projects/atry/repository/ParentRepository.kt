package com.projects.atry.repository

import android.content.Context
import android.util.Log
import com.projects.atry.api.ApiInterface
import com.projects.atry.models.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ParentRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val context: Context
) {

    private val _userDetail = MutableStateFlow(UserProfileDetailModel("", ""))
    private val _talkList = MutableStateFlow(arrayListOf<TalkListLineModel>())
    private val _detailDataModel = MutableStateFlow(DetailDataModel("", "", "", "", "", ""))
    private val _commentList = MutableStateFlow(arrayListOf<CommentModel>())
    private val _onPostComment = MutableStateFlow(CommentPostResponseModel(0))

    val userDetail : StateFlow<UserProfileDetailModel>
    get() = _userDetail

    val talkList : StateFlow<ArrayList<TalkListLineModel>>
    get() = _talkList

    val detailModel : StateFlow<DetailDataModel>
    get() = _detailDataModel

    val commentList : StateFlow<ArrayList<CommentModel>>
    get() = _commentList

    val onPostComment : StateFlow<CommentPostResponseModel>
    get() = _onPostComment

    fun getUserDetail(viewModelScope: CoroutineScope) {

        apiInterface.getUserProfile("advanced", "3871327").enqueue( object:Callback<UserProfileModel>{
            override fun onResponse(p0: Call<UserProfileModel>, response: Response<UserProfileModel>) {
                if (response.body() != null) {
                    Log.d("response", response.body()!!.toString())

                    viewModelScope.launch(Dispatchers.IO) {
                        _userDetail.emit(response.body()!!.data)
                    }
                }
            }

            override fun onFailure(p0: Call<UserProfileModel>, p1: Throwable) {
                Log.d("response", "Network Call Failed")
            }
        })
    }

    fun getTaskList(page:Int, viewModelScope: CoroutineScope) {
        apiInterface.getTalkList(page).enqueue( object:Callback<TalkListModel>{
            override fun onResponse(p0: Call<TalkListModel>, response: Response<TalkListModel>) {
                if (response.body() != null) {
                    Log.d("response", response.body()!!.toString())

                    viewModelScope.launch(Dispatchers.IO) {
                        _talkList.emit(response.body()!!.data.list)
                    }
                }
            }

            override fun onFailure(p0: Call<TalkListModel>, p1: Throwable) {
                Log.d("response", "Network Call Failed")
            }
        })
    }

    fun getDetails(itemId:String, viewModelScope: CoroutineScope) {
        apiInterface.getDetails(itemId, "28.4670407", "77.065488").enqueue( object:Callback<DetailModel>{
            override fun onResponse(p0: Call<DetailModel>, response: Response<DetailModel>) {
                if (response.body() != null) {
                    Log.d("response", response.body()!!.toString())

                    viewModelScope.launch(Dispatchers.IO) {
                        _detailDataModel.emit(response.body()!!.data)
                    }
                }
            }

            override fun onFailure(p0: Call<DetailModel>, p1: Throwable) {
                Log.d("response", "Network Call Failed")
            }
        })
    }

    fun getComments(itemId: String, viewModelScope: CoroutineScope) {
        apiInterface.getComments(itemId, "talk", 10, 1).enqueue(
            object : Callback<CommentsModel>{
                override fun onResponse(p0: Call<CommentsModel>, response: Response<CommentsModel>) {
                    if (response.body() != null) {
                        Log.d("response", response.body()!!.toString())

                        viewModelScope.launch(Dispatchers.IO) {
                            _commentList.emit(response.body()!!.comments)
                        }
                    }
                }

                override fun onFailure(p0: Call<CommentsModel>, p1: Throwable) {
                    Log.d("response", "Network Call Failed")
                }

            })
    }

    fun postComment(payload: CommentsPostModel, viewModelScope: CoroutineScope) {
        apiInterface.postComment(payload).enqueue(object : Callback<CommentPostResponseModel>{
            override fun onResponse(
                p0: Call<CommentPostResponseModel>,
                response: Response<CommentPostResponseModel>
            ) {
                if (response.body() != null) {
                    Log.d("response", response.body()!!.toString())

                    viewModelScope.launch(Dispatchers.IO) {
                        _onPostComment.emit(response.body()!!)
                    }
                }
            }

            override fun onFailure(p0: Call<CommentPostResponseModel>, p1: Throwable) {
                Log.d("response", "Network Call Failed")
            }

        })
    }
}