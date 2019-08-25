package com.example.retrofity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofity.retrofit.retrofitUtil;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//첫화면 클래스
//Manifest에서 지정함
public class MainActivity extends AppCompatActivity {

//    DataView 형태 지정.
    private TextView dataView;

//    OnCreate = 뷰가 생성될때.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        xml 레이아웃을 Class 와 연결
        setContentView(R.layout.activity_main);

        dataView = findViewById(R.id.dataView);

        searchData();
    }

//    retrofit을 사용해 데이터를 받아온 뒤 띄워주기
    private void searchData() {

//        res = retrofitUtil 에서 instance 요청
//        그뒤 instance 에서 service 를 가져온뒤
//        service 를 사용해서 getResultFromServer 에서 정의한 작업을 정의함.
        Call<JsonObject> res =
                retrofitUtil.getInstance()
                        .getService()
                        .getResultFromServer("1234");

//        res 에서 정의한 작업 시작.
        res.enqueue(new Callback<JsonObject>() {
//            Call = 응답 상태
//            Response = 응답 값
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                받기 성공!!
                if (response.body() != null) {
//                    응답 값이 있으면.

//                    Json 에서 result라는 이름을가진 데이터 가져오고 String형식으로.
                    dataView.setText(response.body().get("result").toString());
//                    나중에 response.body().get("값 이름") 을 통해서 Json데이터를 가져올수 있음.
                } else {
//                    응답 값이 없으면.
                    dataView.setText("데이터 없음..!");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
//                받기 실패!!
                dataView.setText("서버요청 실패!! : " + t.getMessage());
            }
        });
    }

}
