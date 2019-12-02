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
}
