package com.geekvvv.weatheralarm.http;

import com.geekvvv.weatheralarm.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class HttpClient {

    private final OkHttpClient httpClient;

    private static class SingletonHolder {
        private static final HttpClient INSTANCE = new HttpClient();
    }

    public static HttpClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private HttpClient() {
        httpClient = new OkHttpClient.Builder().build();
    }

    public OkHttpClient getHttpClient() {
        OkHttpClient newHttpClient = null;
        if (newHttpClient == null) {
            newHttpClient = httpClient.newBuilder()
                    .build();

        }
        return newHttpClient;
    }
}
