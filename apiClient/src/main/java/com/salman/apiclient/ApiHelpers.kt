package com.salman.apiclient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun getPost(postId: Int, onSuccess: (Post?) -> Unit, onError: (t: Throwable) -> Unit) {
    val call = ApiClient.apiService.getPostById(postId)

    call.enqueue(object : Callback<Post> {
        override fun onResponse(call: Call<Post>, response: Response<Post>) {
            if (response.isSuccessful) {
                // Handle the retrieved post data
                val postResponse = response.body()

                onSuccess(postResponse)
            } else {
                // Handle error
                onError(Exception(response.message()))
            }
        }

        override fun onFailure(call: Call<Post>, t: Throwable) {
            // Handle failure
            onError(t)
        }
    })
}