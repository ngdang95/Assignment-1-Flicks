package com.example.dangfiztssi.flicks.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.example.dangfiztssi.flicks.R;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DangF on 10/12/16.
 */

public class Utils {

    public static Retrofit getSimplyRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(AppConstant.BASE_URL)
                .client(client())
                .addConverterFactory(GsonConverterFactory.create()) // convert xml to json object purpose
                .build();
    }

    private static OkHttpClient client(){
        return new OkHttpClient.Builder()
                .addInterceptor(apiKeyInterceptor())
                .build();
    }

    private static Interceptor apiKeyInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url()
                        .newBuilder()
                        .addQueryParameter("api_key",AppConstant.API_KEY)
                        .build();

                request = request.newBuilder()
                        .url(url)
                        .build();
                return chain.proceed(request);
            }
        };
    }

    public static Dialog getWaitingDialog(Activity c) {
        Dialog ret = new Dialog(c);
        LayoutInflater inf = ((LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        View v = inf.inflate(R.layout.waiting_dialog, null);
        ret.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ret.setContentView(v);
        ret.setCanceledOnTouchOutside(false);
        ret.getWindow().setDimAmount(0.0f);
        ret.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        return ret;

    }
}
