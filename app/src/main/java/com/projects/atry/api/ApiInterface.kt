package com.projects.atry.api

import com.projects.atry.models.*
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("/api/onboarding/user/v1/profile")
    @Headers(
        "sec-ch-ua-platform: \"Android\"",
        "authToken: 0b19f4f86ae887586eab7a7a21a2541ab99b46ae16030f8b98461fe9f5497278",
        "Referer: https://qa7.parentune.com/parent-talk",
        "sec-ch-ua: \"Not A(Brand\";v=\"8\", \"Chromium\";v=\"132\", \"Google Chrome\";v=\"132\"",
        "sec-ch-ua-mobile: ?1",
        "instanceId: 611603cb84b358abee0d73f7a366bab2c1997783320c9d234fc3001c9ac6b5bb",
        "country: IN",
        "User-Agent: Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Mobile Safari/537.36",
        "Accept: application/json, text/plain, */*",
        "platform: web")
    fun getUserProfile(@Query("type") type:String,
                       @Query("userId") userId:String) : Call<UserProfileModel>

    @GET("api/talk/talk/v1/list")
    @Headers(
        "sec-ch-ua-platform: \"Android\"",
        "authToken: 0b19f4f86ae887586eab7a7a21a2541ab99b46ae16030f8b98461fe9f5497278",
        "lang: en",
        "Referer: https://qa7.parentune.com/parent-talk",
        "sec-ch-ua: \"Not A(Brand\";v=\"8\", \"Chromium\";v=\"132\", \"Google Chrome\";v=\"132\"",
        "sec-ch-ua-mobile: ?1",
        "instanceId: 611603cb84b358abee0d73f7a366bab2c1997783320c9d234fc3001c9ac6b5bb",
        "User-Agent: Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Mobile Safari/537.36",
        "Accept: application/json, text/plain, */*")
    fun getTalkList(@Query("page") page:Int) : Call<TalkListModel>

    @GET("api/talk/talk/v1/detail")
    @Headers(
        "accept: application/json, text/plain, */*",
        "accept-language: en-US,en;q=0.9",
        "authtoken: 0b19f4f86ae887586eab7a7a21a2541ab99b46ae16030f8b98461fe9f5497278",
        "cookie: _fbp=fb.1.1700646454821.1993299693; g_state={\"i_l\":0}; _ga_XM5T9FK8WM=GS1.1.1724994359.9.0.1724994359.60.0.0; _ga_LWVJC60CMJ=GS1.1.1724994360.9.0.1724994360.0.0.0; __utmz=54949546.1726828637.48.9.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); ptgc=c0a1d020b576bcdd71ef8dc6cfe76f11; __utmc=54949546; __utma=54949546.84283965.1700646455.1738848143.1738909093.72; __utmv=54949546.|1=user-type=Guest=1^2=user-lang=en=1^3=user-agegroup=3-5=1; _gid=GA1.2.131112402.1739362703; _gcl_au=1.1.754021675.1739448528; fcm_token=true; _clck=1omyasu%7C2%7Cftg%7C0%7C1485; new_user=1; user_profile_created=1; user_data={...}; _ppmgi=MWZqNDQzODcxMzI3NTVwZGprcw==; __gads=ID=eedbac2da3a946b9:T=1734405547:RT=1739596008:S=ALNI_MaIVt9EnwSVHqjffZz13VB3yo9T1Q; __gpi=UID=00000fa758cca759:T=1734405547:RT=1739596008:S=ALNI_Ma8WHPAzevDawf_avxHWdvnEvyfCQ; __eoi=ID=80d182d18d0874ef:T=1737957260:RT=1739596008:S=AA-AfjbepSH6fsMr6uEqoyorgtf0; mp_4ed56dbae24376e7669b051fe525819c_mixpanel={...}; _ga=GA1.2.84283965.1700646455; _ga_JCRX62HZZV=GS1.2.1739594177.463.1.1739596244.0.0.0; _gat=1; _clsk=1clyis%7C1739596404659%7C21%7C1%7Ca.clarity.ms%2Fcollect; _ga_KF05MGQPKP=GS1.1.1739594176.650.1.1739596437.27.0.0",
        "instanceid: 611603cb84b358abee0d73f7a366bab2c1997783320c9d234fc3001c9ac6b5bb",
        "priority: u=1, i",
        "referer: https://qa7.parentune.com/parent-talk/details/235163",
        "sec-ch-ua: \"Not A(Brand\";v=\"8\", \"Chromium\";v=\"132\", \"Google Chrome\";v=\"132\"",
        "sec-ch-ua-mobile: ?1",
        "sec-ch-ua-platform: \"Android\"",
        "sec-fetch-dest: empty",
        "sec-fetch-mode: cors",
        "sec-fetch-site: same-origin",
        "user-agent: Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Mobile Safari/537.36")
    fun getDetails(
        @Query("itemId") itemId: String,
        @Query("latitude") latitude: String,
        @Query("longitude") longitude: String
    ): Call<DetailModel>



    @GET("api/action/content/comment")
    @Headers(
        "accept: application/json, text/plain, */*",
        "accept-language: en-US,en;q=0.9",
        "authtoken: 0b19f4f86ae887586eab7a7a21a2541ab99b46ae16030f8b98461fe9f5497278",
        "cookie: _fbp=fb.1.1700646454821.1993299693; g_state={\"i_l\":0}; _ga_XM5T9FK8WM=GS1.1.1724994359.9.0.1724994359.60.0.0; _ga_LWVJC60CMJ=GS1.1.1724994360.9.0.1724994360.0.0.0; __utmz=54949546.1726828637.48.9.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); ptgc=c0a1d020b576bcdd71ef8dc6cfe76f11; __utmc=54949546; __utma=54949546.84283965.1700646455.1738848143.1738909093.72; __utmv=54949546.|1=user-type=Guest=1^2=user-lang=en=1^3=user-agegroup=3-5=1; _gid=GA1.2.131112402.1739362703; _gcl_au=1.1.754021675.1739448528; fcm_token=true; _clck=1omyasu%7C2%7Cftg%7C0%7C1485; new_user=1; user_profile_created=1; user_data={...}; _ppmgi=MWZqNDQzODcxMzI3NTVwZGprcw==; __gads=ID=eedbac2da3a946b9:T=1734405547:RT=1739596008:S=ALNI_MaIVt9EnwSVHqjffZz13VB3yo9T1Q; __gpi=UID=00000fa758cca759:T=1734405547:RT=1739596008:S=ALNI_Ma8WHPAzevDawf_avxHWdvnEvyfCQ; __eoi=ID=80d182d18d0874ef:T=1737957260:RT=1739596008:S=AA-AfjbepSH6fsMr6uEqoyorgtf0; mp_4ed56dbae24376e7669b051fe525819c_mixpanel={...}; _ga=GA1.2.84283965.1700646455; _ga_JCRX62HZZV=GS1.2.1739594177.463.1.1739596244.0.0.0; _gat=1; _clsk=1clyis%7C1739596404659%7C21%7C1%7Ca.clarity.ms%2Fcollect; _ga_KF05MGQPKP=GS1.1.1739594176.650.1.1739596437.27.0.0",
        "instanceid: 611603cb84b358abee0d73f7a366bab2c1997783320c9d234fc3001c9ac6b5bb",
        "priority: u=1, i",
        "referer: https://qa7.parentune.com/parent-talk/details/235163",
        "sec-ch-ua: \"Not A(Brand\";v=\"8\", \"Chromium\";v=\"132\", \"Google Chrome\";v=\"132\"",
        "sec-ch-ua-mobile: ?1",
        "sec-ch-ua-platform: \"Android\"",
        "sec-fetch-dest: empty",
        "sec-fetch-mode: cors",
        "sec-fetch-site: same-origin",
        "user-agent: Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Mobile Safari/537.36"
    )
    fun getComments(
        @Query("itemId") itemId: String,
        @Query("itemType") itemType: String,
        @Query("count") count: Int,
        @Query("pageNumber") pageNumber: Int
    ): Call<CommentsModel>


    @POST("api/action/content/comment/add")
    @Headers(
        "accept: application/json, text/plain, */*",
        "accept-language: en-US,en;q=0.9",
        "authtoken: 0b19f4f86ae887586eab7a7a21a2541ab99b46ae16030f8b98461fe9f5497278",
        "content-type: application/json",
        "cookie: _fbp=fb.1.1700646454821.1993299693; g_state={\"i_l\":0}; _ga_XM5T9FK8WM=GS1.1.1724994359.9.0.1724994359.60.0.0; _ga_LWVJC60CMJ=GS1.1.1724994360.9.0.1724994360.0.0.0; __utmz=54949546.1726828637.48.9.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); ptgc=c0a1d020b576bcdd71ef8dc6cfe76f11; __utmc=54949546; __utma=54949546.84283965.1700646455.1738848143.1738909093.72; __utmv=54949546.|1=user-type=Guest=1^2=user-lang=en=1^3=user-agegroup=3-5=1; _gid=GA1.2.131112402.1739362703; _gcl_au=1.1.754021675.1739448528; fcm_token=true; _clck=1omyasu%7C2%7Cftg%7C0%7C1485; new_user=1; user_profile_created=1; user_data={...}; _ppmgi=MWZqNDQzODcxMzI3NTVwZGprcw==; mp_4ed56dbae24376e7669b051fe525819c_mixpanel={...}; _ga=GA1.2.84283965.1700646455; _ga_JCRX62HZZV=GS1.2.1739594177.463.1.1739596244.0.0.0; _clsk=1clyis%7C1739596438520%7C22%7C1%7Ca.clarity.ms%2Fcollect; _ga_KF05MGQPKP=GS1.1.1739594176.650.1.1739596438.26.0.0; __gads=ID=eedbac2da3a946b9:T=1734405547:RT=1739596441:S=ALNI_MaIVt9EnwSVHqjffZz13VB3yo9T1Q; __gpi=UID=00000fa758cca759:T=1734405547:RT=1739596441:S=ALNI_Ma8WHPAzevDawf_avxHWdvnEvyfCQ; __eoi=ID=80d182d18d0874ef:T=1737957260:RT=1739596441:S=AA-AfjbepSH6fsMr6uEqoyorgtf0",
        "instanceid: 611603cb84b358abee0d73f7a366bab2c1997783320c9d234fc3001c9ac6b5bb",
        "origin: https://qa7.parentune.com",
        "priority: u=1, i",
        "referer: https://qa7.parentune.com/parent-talk/details/235163",
        "sec-ch-ua: \"Not A(Brand\";v=\"8\", \"Chromium\";v=\"132\", \"Google Chrome\";v=\"132\"",
        "sec-ch-ua-mobile: ?1",
        "sec-ch-ua-platform: \"Android\"",
        "sec-fetch-dest: empty",
        "sec-fetch-mode: cors",
        "sec-fetch-site: same-origin",
        "user-agent: Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/132.0.0.0 Mobile Safari/537.36"
    )
    fun postComment(@Body payload: CommentsPostModel): Call<CommentPostResponseModel>




}