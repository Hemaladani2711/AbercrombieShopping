package com.android.abercrombieshopping.WebApis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import com.android.abercrombieshopping.Objects.Promotion;

public interface WebService {
    String BASE_URL="https://www.abercrombie.com/anf/nativeapp/qa/codetest/";

    OkHttpClient longerConnectionTimeout= new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();
    Gson gson=new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    Retrofit retrofitInstance= new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(longerConnectionTimeout)
            .build();

    @POST(endpoints.CODE_TEST)
    Call<Promotion> getPromotionsData();

    interface endpoints {
        String CODE_TEST="codeTest_exploreData.json";
    }
}
