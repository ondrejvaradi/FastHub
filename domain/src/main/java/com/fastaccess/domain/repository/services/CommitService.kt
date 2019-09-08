package com.fastaccess.domain.repository.services

import com.fastaccess.domain.response.CommentResponse
import com.fastaccess.domain.response.body.CommentRequestModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface CommitService {
    @POST("repos/{owner}/{repo}/commits/{sha}/comments") fun postCommitComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("sha") ref: String,
        @Body model: CommentRequestModel
    ): Observable<CommentResponse>


    @PATCH("repos/{owner}/{repo}/comments/{id}") fun editCommitComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("id") id: Long,
        @Body body: CommentRequestModel
    ): Observable<Response<Unit>>


    @DELETE("repos/{owner}/{repo}/comments/{id}") fun deleteComment(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Path("id") id: Long
    ): Observable<Response<Boolean>>
}