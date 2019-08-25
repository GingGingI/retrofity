package com.example.retrofity.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitUtil {
    private static retrofitUtil instantnce = new retrofitUtil();

    public static retrofitUtil getInstance() {
        return instantnce;
    }

//    baseUrl = 기본이될 Url | 예 : naver.com
//    addConverterFactory = String형태로 Json이 나열되어있는 것을 Json으로 변환.
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://29ebf276.ngrok.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

//    미리 생성한 retrofit에다가
//    retrofitClass 라는 인터페이스로 지정한 형식대로
//    모듈을 생성해달라고 요청해서 받은 모듈을
//    service 변수에 집어넣음
    retrofitService service = retrofit.create(retrofitService.class);

    public retrofitService getService() {
        return service;
    }
}
