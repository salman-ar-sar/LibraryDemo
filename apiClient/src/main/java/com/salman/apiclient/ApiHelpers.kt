package com.salman.apiclient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun getPost(postId: Int): Post? {
    val call = ApiClient.apiService.getPostById(postId)

    var post: Post? = null

    call.enqueue(object : Callback<Post> {
        override fun onResponse(call: Call<Post>, response: Response<Post>) {
            if (response.isSuccessful) {
                val postResponse = response.body()
                print(post.toString() + "from API")

                post = postResponse
                // Handle the retrieved post data
            } else {
                // Handle error
            }
        }

        override fun onFailure(call: Call<Post>, t: Throwable) {
            // Handle failure
        }
    })

    return post
}