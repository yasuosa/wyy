package cn.rpy.wyy.base.mvc;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/2 22:07
 * @desc :
 */
public interface IBaseView {
    //显示加载
    void showLoad();

    //取消加载
    void dissLoad();

    //显示snack
    void showSnackBarMsg(String msg);

    //获取网络接口操作成功
    void onSuccess(String msg);

    //失败
    void onFail(String msg);
}
