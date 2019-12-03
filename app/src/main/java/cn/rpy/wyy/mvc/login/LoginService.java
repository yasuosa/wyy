package cn.rpy.wyy.mvc.login;

import cn.rpy.wyy.base.APP;
import cn.rpy.wyy.base.net.ResultBean;
import cn.rpy.wyy.constant.AppConstant;
import cn.rpy.wyy.domain.InfoRegister;
import cn.rpy.wyy.domain.LoginInfo;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/3
 * @desc :
 */
public interface LoginService {

    /**
     * 判断手机号码是否注册
     * @param phone
     * @return
     */
    @GET(AppConstant.IS_REGISTER_URL)
    Observable<InfoRegister> is_Resigter(@Query("phone") String phone);


    /**
     * 手机号码直接注册
     * @param phone
     * @param pass
     * @return
     */
    @GET(AppConstant.LOGIN_BY_PHONE_URL)
    Observable<LoginInfo> loginByPhone(@Query("phone") String phone,@Query("password") String pass);


    /**
     * 发送手机验证码
     * @param phone
     * @return
     */
    @GET(AppConstant.GET_LOGIN_PHONE_CODE)
    Observable<ResultBean> getPhoneCode(@Query("phone") String phone);


    /**
     * 通过手机验证码登陆
     * @param phone
     * @param code
     * @return
     */
    @GET(AppConstant.LOGIN_BY_PHONE_CODE)
    Observable<ResultBean> loginByCode(@Query("phone") String  phone,@Query("code") String code);
}
