package com.tengyun.wikiplayerdemo;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Administrator on 2016/1/7.
 */
public class HttpUtils {
    public interface Services{
        @GET("/article/list/video")
        Call<Entity> getVideo(@Query("page") int page);
    }
    private static Services services;
    static {
        services = new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com/").addConverterFactory(GsonConverterFactory.create()).build().create(Services.class);
    }

    public static Services getServices() {
        return services;
    }
}
