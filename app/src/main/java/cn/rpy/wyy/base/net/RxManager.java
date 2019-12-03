package cn.rpy.wyy.base.net;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/2 22:30
 * @desc :
 */
public class RxManager {

    private CompositeDisposable compositeDisposable=new CompositeDisposable();

    /**
     * 加入管理容器
     * @param disposable
     */
    public void add(Disposable disposable){
        compositeDisposable.add(disposable);
    }


    /**
     * 取消订阅
     */
    public void unsubscribe(){
        compositeDisposable.dispose();
    }

}
