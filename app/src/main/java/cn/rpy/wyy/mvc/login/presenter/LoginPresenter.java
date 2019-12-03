package cn.rpy.wyy.mvc.login.presenter;

import android.util.Log;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import cn.rpy.wyy.base.mvc.BasePresenter;
import cn.rpy.wyy.base.net.RequestCallBack;
import cn.rpy.wyy.base.net.ResultBean;
import cn.rpy.wyy.constant.AppConstant;
import cn.rpy.wyy.domain.InfoRegister;
import cn.rpy.wyy.domain.LoginInfo;
import cn.rpy.wyy.mvc.login.contract.LoginContract;
import cn.rpy.wyy.mvc.login.model.LoginModel;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/3
 * @desc :
 */
public class LoginPresenter extends BasePresenter<LoginContract.v> implements LoginContract.p {

    private LoginModel model=new LoginModel();

    private static final String TAG = "LoginPresenter";


    @Override
    public void tx() {

    }

    @Override
    public void wx() {

    }

    @Override
    public void wb() {

    }

    @Override
    public void is_register(String phone) {
        subscribe(model.is_Register(phone), new RequestCallBack<InfoRegister>() {
            @Override
            public void cnSuccess(InfoRegister data) {
                Log.d(TAG, "cnSuccess: "+data.getNickname());
                if(null ==data.getNickname()){
                    mView.isRegister(false);
                }else {
                    mView.isRegister(true);
                }
            }

            @Override
            public void onFailure(String msg) {
                mView.netErr(msg);
                Log.d(TAG, "onFailure: "+msg);
            }
        });
    }

    @Override
    public void login(String phone, String pass) {
        subscribe(model.login(phone, pass), new RequestCallBack<LoginInfo>() {
            @Override
            public void cnSuccess(LoginInfo data) {
                //用户密码正确
                if(data.getCode()==200){
                    mView.loginBySuc(data.getAccount());
                }else {
                    mView.loginByFail(data.getMessage());
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.d(TAG, "onFailure: "+msg);
                mView.netErr(msg);
            }
        });
    }

    @Override
    public void getCode(String phone) {
        subscribe(model.getCode(phone), new RequestCallBack<ResultBean>() {
            @Override
            public void cnSuccess(ResultBean data) {
                if(data.getCode()==AppConstant.CODE){
                    mView.onSuccess("发送成功");
                }else {
                    mView.onFail("发送失败");
                }
            }

            @Override
            public void onFailure(String msg) {
                mView.onFail(msg);
            }
        });
    }

    @Override
    public void loginByPhoneCode(String phone, String code) {
        subscribe(model.mattchCode(phone, code), new RequestCallBack<ResultBean>() {
            @Override
            public void cnSuccess(ResultBean data) {
                if(data.getCode()==AppConstant.CODE){
                    mView.loginBySuc(null);
                }else {
                    mView.loginByFail(data.getMessage());
                }
            }

            @Override
            public void onFailure(String msg) {
                mView.onFail(msg);
            }
        });
    }
}
