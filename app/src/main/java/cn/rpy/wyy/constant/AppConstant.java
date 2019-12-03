package cn.rpy.wyy.constant;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/2 23:14
 * @desc : 各种常量
 */
public interface AppConstant {

    /****************************API开始*******************************/
    //接口的base
    String BASE_URL = "http://192.168.3.195:3000";

    //手机登陆
    String LOGIN_BY_PHONE = "login/cellphone";

    //检测手机号是否注册/cellphone/existence/check?phone=13xxx
    String IS_REGISTER_URL = "/cellphone/existence/check?";

    //手机号码登陆
    String LOGIN_BY_PHONE_URL = "/login/cellphone?";

    //手机号码验证码求取
    String GET_LOGIN_PHONE_CODE = "/captcha/sent?";

    //手机号码验证码登陆/captcha/verify?phone=13xxx&captcha=1597
    String LOGIN_BY_PHONE_CODE = "/captcha/verify?";


    /****************************API结束*******************************/





    /*************************注册页面的文本信息开始***************/
    //登陆首页
    String LOGIN_INDEX_FRAGMENT = "LOGIN_INDEX_FRAGMENT";
    //登陆手机号登陆页面
    String LOGIN_PHONE_FRAGMENT = "LOGIN_PHONE_FRAGMENT";
    //判断手机号已注册
    String PHONE_IS_REGISTER = "PHONE_IS_REGISTER";
    //当前手机已注册 输密码页面
    String LOGIN_PHONE_PASS = "LOGIN_PHONE_PASS";
    //当前手机已注册
    String REGISTER_IS_BE = "REGISTER_IS_BE";
    //当前手机号未注册
    String REGISTER_IS_NOT_BE = "REGISTER_IS_NOT_BE";
    String PHONE_SMS = "PHONE_SMS";

    /***********************注册页面的文本信息结束**************/



    /*************************常量***********************/
    //请求成功码
    int CODE=200;

}
