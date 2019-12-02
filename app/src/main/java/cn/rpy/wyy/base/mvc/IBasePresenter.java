package cn.rpy.wyy.base.mvc;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/2 22:08
 * @desc :
 */
public interface IBasePresenter<View extends IBaseView> {

    //绑定view
    void attchView(View view);

    //解绑
    void unAttachView();

    //判断是否绑定
    boolean isAttchView();
}
