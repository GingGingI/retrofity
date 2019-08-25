package com.example.retrofity.retrofit;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface retrofitService {
//    Get방식으로 ("서버의 기본 베이스 URL/get")
    @GET("/get")
    Call<JsonObject> getResultFromServer(@Query("data") String data);
//    Query(data) = 앞에붙을 이름
//    String data = 뒤에들어갈 값
}