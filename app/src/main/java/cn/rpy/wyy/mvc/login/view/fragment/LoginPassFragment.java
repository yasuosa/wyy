package cn.rpy.wyy.mvc.login.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuexiang.xui.widget.button.ButtonView;
import com.xuexiang.xui.widget.edittext.PasswordEditText;
import com.xuexiang.xui.widget.toast.XToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.rpy.wyy.R;
import cn.rpy.wyy.base.mvc.BaseFragment;
import cn.rpy.wyy.mvc.login.contract.LoginContract;
import cn.rpy.wyy.mvc.login.presenter.LoginPresenter;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/3
 * @desc : 输入密码
 */
public class LoginPassFragment extends BaseFragment {

    @BindView(R.id.login_ed_pass)
    PasswordEditText loginEdPass;
    @BindView(R.id.login_btn_login_next)
    ButtonView loginBtnLoginNext;
    private LoginContract.v v;
    private String phone;

    private static final String TAG = "LoginPassFragment";

    @Override
    protected void initView() {
        loginBtnLoginNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(null ==loginEdPass.getText().toString() ){
                    XToast.error(mActivity,"请填写密码");
                    return;
                }
                if(phone ==null){
                    Log.d(TAG, "onClick: 手机号码没传过来");
                    return;
                }
                v.login(phone,loginEdPass.getText().toString());
            }
        });
    }

    @Override
    protected void loadData() {

    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_loginbyphone_pass;
    }

    @Override
    protected LoginPresenter createrPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void showLoad() {

    }

    @Override
    public void dissLoad() {

    }

    @Override
    public void showSnackBarMsg(String msg) {

    }

    @Override
    public void onSuccess(String msg) {

    }

    @Override
    public void onFail(String msg) {

    }

    public void setLoginListener(LoginContract.v v){
        this.v=v;
    }

}
