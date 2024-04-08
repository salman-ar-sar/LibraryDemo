package com.salman.apiclient

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.supervisorScope
import retrofit2.Response

suspend fun getPost(postId: Int): Post? {
    return supervisorScope {
        val call = ApiClient.apiService.getPostById(postId)

        val deferred = async(Dispatchers.IO) {
            call.execute()
        }

        try {
            val response: Response<Post> = deferred.await()

            return@supervisorScope response.body()
        } catch (e: Exception) {
            throw (e)
        }
    }
}