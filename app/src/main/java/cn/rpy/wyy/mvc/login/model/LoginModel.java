package cn.rpy.wyy.mvc.login.model;

import cn.rpy.wyy.R;
import cn.rpy.wyy.base.mvc.BaseModel;
import cn.rpy.wyy.base.net.ResultBean;
import cn.rpy.wyy.base.net.RetrofitFactory;
import cn.rpy.wyy.domain.InfoRegister;
import cn.rpy.wyy.domain.LoginInfo;
import cn.rpy.wyy.mvc.login.contract.LoginContract;
import io.reactivex.Observable;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/3
 * @desc :
 */
public class LoginModel implements LoginContract.m {


    @Override
    public Observable<InfoRegister> is_Register(String phone) {
        return RetrofitFactory.getInstance().getLoginService().is_Resigter(phone);
    }



    @Override
    public Observable<LoginInfo> login(String phone, String pass) {
        return RetrofitFactory.getInstance().getLoginService().loginByPhone(phone,pass);
    }

    @Override
    public Observable<ResultBean> getCode(String phone) {
        return RetrofitFactory.getInstance().getLoginService().getPhoneCode(phone);
    }

    @Override
    public Observable<ResultBean> mattchCode(String phone, String code) {
        return RetrofitFactory.getInstance().getLoginService().loginByCode(phone,code);
    }


}
