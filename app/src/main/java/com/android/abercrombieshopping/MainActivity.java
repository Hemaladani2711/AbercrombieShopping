package com.android.abercrombieshopping;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import com.android.abercrombieshopping.Objects.Promotion;
import com.android.abercrombieshopping.WebApis.WebService;

public class MainActivity extends AppCompatActivity {
    private static String TAG="ABERCROMBIE";//MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadData();
    }

    //to make call to webservice and download data
    public void downloadData(){
        WebService service=WebService.retrofitInstance.create(WebService.class);
        Call<Promotion> promotionCall=service.getPromotionsData();
        promotionCall.enqueue(new Callback<Promotion>() {
            @Override
            public void onResponse(Call<Promotion> call, Response<Promotion> response) {
                Log.d(TAG,""+response.code());
                Log.d(TAG,""+response.body());

            }

            @Override
            public void onFailure(Call<Promotion> call, Throwable t) {
                Log.d(TAG,t.getMessage());
            }
        });
    }
}
