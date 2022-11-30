package com.app.gitHubUserList

import com.app.gitHubUserList.data.api.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

interface SafeApiCall {

    suspend fun <T> safeAPICall(
        apiCall: suspend () -> T
    ): Any {

        return withContext(Dispatchers.IO) {
            try {
                Resource.success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when(throwable) {
                    is HttpException -> {
                        Resource.error(throwable.code().toString(), throwable.response()?.errorBody())
                    }
                    else -> {
                        Resource.error("", null)
                    }
                }
            }
        }
    }
}