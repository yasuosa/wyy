package cn.rpy.wyy.base.mvc;

import java.lang.ref.WeakReference;

import cn.rpy.wyy.base.net.RxManager;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/2 22:10
 * @desc :
 */
public class BasePresenter<View extends IBaseView> implements IBasePresenter<View> {
    
    private View mView;
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


}
