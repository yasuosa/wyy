package cn.rpy.wyy.base.net;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/3
 * @desc : 网络数据接口
 */
public interface RequestCallBack<T> {

    void  cnSuccess(T data);

    void onFailure(String msg);
}
