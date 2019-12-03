package cn.rpy.wyy.base.net;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.TimeUnit;

import cn.rpy.wyy.constant.AppConstant;
import cn.rpy.wyy.mvc.login.LoginService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/3
 * @desc :
 */
public class RetrofitFactory {

    private static OkHttpClient client;

    private volatile static RetrofitFactory factory;

    private Retrofit retrofit;

    public static RetrofitFactory getInstance(){
        if(factory!=null){
            return factory;
        }
        synchronized (RetrofitFactory.class){
            if(factory==null){
                factory=new RetrofitFactory();
            }
            return factory;
        }
    }

    private RetrofitFactory(){
        client=new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.SECONDS)
                .build();
        retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(AppConstant.BASE_URL)
                .client(client)
                .build();
    }

   public LoginService getLoginService(){
        return retrofit.create(LoginService.class);
   }
}
