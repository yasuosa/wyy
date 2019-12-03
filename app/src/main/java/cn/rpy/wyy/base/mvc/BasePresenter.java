package cn.rpy.wyy.base.mvc;

import android.text.TextUtils;

import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import cn.rpy.wyy.base.net.RequestCallBack;
import cn.rpy.wyy.base.net.RxManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/2 22:10
 * @desc :
 */
public class BasePresenter<View extends IBaseView> implements IBasePresenter<View> {
    
    protected View mView;
    //弱引用 防止内容泄露
    private WeakReference<View> weakReference;

    private RxManager rxManager=new RxManager();
    

    @Override
    public void attchView(View mView) {
        if(null!=mView){
            weakReference=new WeakReference<>(mView);
            this.mView=weakReference.get();
        }
    }

    @Override
    public void unAttachView() {
        if(null!=mView){
            weakReference.clear();
            this.mView=null;
        }
    }

    @Override
    public boolean isAttchView() {
        return mView!=null;
    }


    public <T>void subscribe(Observable<T> observable, final RequestCallBack callBack){
        rxManager.add(
                observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        callBack.cnSuccess(t);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("AAA"+throwable.getMessage());
                        String msg = null;
                        if (throwable instanceof HttpException) {
                            HttpException he = (HttpException) throwable;
                            switch (he.code()) {
                                case 400:
                                    msg = "手机号或验证码错误";
                                    break;
                                case 401:
                                    callBack.onFailure("登录失效");
                                    break;
                                default:
                                    msg = "请求出错了，错误代码" + he.code();
                                    break;
                            }
                        } else if (throwable instanceof SocketTimeoutException) {
                            msg = "请求超时。请稍后重试！";
                        } else if (throwable instanceof ConnectException) {
                            msg = "请求超时。请稍后重试！";
                        } else {
                            msg = "请求出错了。请稍后重试！";
                        }
                        if (!TextUtils.isEmpty(msg)) {
                            callBack.onFailure(msg);
                        }
                    }
                })
        );
    }


}
