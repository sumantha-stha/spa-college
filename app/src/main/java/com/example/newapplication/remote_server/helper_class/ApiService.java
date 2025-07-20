package com.example.newapplication.remote_server.helper_class;

import com.example.newapplication.remote_server.entity.PostRequest;
import com.example.newapplication.remote_server.entity.PostResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("posts")
    Call<PostResponse> submitBody(@Body PostRequest postRequest);
}
