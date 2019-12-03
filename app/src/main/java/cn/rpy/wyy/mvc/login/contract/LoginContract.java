package cn.rpy.wyy.mvc.login.contract;

import cn.rpy.wyy.base.mvc.IBasePresenter;
import cn.rpy.wyy.base.mvc.IBaseView;
import cn.rpy.wyy.base.net.ResultBean;
import cn.rpy.wyy.domain.InfoRegister;
import cn.rpy.wyy.domain.LoginInfo;
import io.reactivex.Observable;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/2 23:12
 * @desc : 登陆的控制器
 */
public interface  LoginContract {

    //Activity view
    interface v extends IBaseView{
        //下一步
        void next(String name);

        //下一步手机号
        void nextPhone(String phone);

        //判断手机是否注册
        void isRegister(boolean isB);


        //网络出问题
        void netErr(String err);

        //登陆
        void login(String phone,String pass);

        //发送手机验证码
        void sendSms(String phone);

        //匹配验证码
        void sendCode(String code);


        //登陆成功
        void loginBySuc(LoginInfo.AccountBean account);

        //登陆失败
        void loginByFail(String msg);

    }




    interface p extends IBasePresenter<v> {
        //腾讯第三方
        void tx();

        //微信第三方
        void wx();

        //微博第三方
        void wb();

        //是否注册
        void is_register(String phone);

        //手机号码直接登陆
        void login(String phone, String pass);

        //得到手机验证吗
        void getCode(String phone);

        //验证手机验证码
        void loginByPhoneCode(String phone, String code);
    }
       interface m {
           //获取是否注册了
           Observable<InfoRegister> is_Register(String phone);

           //手机号码加密码登陆
           Observable<LoginInfo> login(String phone, String pass);

           //获取手机验证码
           Observable<ResultBean> getCode(String phone);

           //验证手机验证码
            Observable<ResultBean> mattchCode(String phone,String code);
       }

}
