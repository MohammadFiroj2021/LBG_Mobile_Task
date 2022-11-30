package com.app.gitHubUserList

import com.app.gitHubUserList.data.api.MainRepository
import com.app.gitHubUserList.model.GetUserListItem
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    val mRep : MainRepository
) {

}