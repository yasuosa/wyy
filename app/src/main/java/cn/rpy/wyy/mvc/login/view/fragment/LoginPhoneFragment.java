package cn.rpy.wyy.mvc.login.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xuexiang.xui.widget.button.ButtonView;
import com.xuexiang.xui.widget.edittext.ClearEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.rpy.wyy.R;
import cn.rpy.wyy.base.mvc.BaseFragment;
import cn.rpy.wyy.base.mvc.BasePresenter;
import cn.rpy.wyy.constant.AppConstant;
import cn.rpy.wyy.mvc.login.contract.LoginContract;
import cn.rpy.wyy.mvc.login.presenter.LoginPresenter;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/3
 * @desc :
 */
public class LoginPhoneFragment extends BaseFragment  {
    @BindView(R.id.login_ed_phone)
    ClearEditText loginEdPhone;
    @BindView(R.id.login_btn_login_next)
    ButtonView loginBtnLoginNext;
    Unbinder unbinder;
    private LoginContract.v v;
    @Override
    protected void initView() {
        loginBtnLoginNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loginEdPhone.getText().toString()==null ||loginEdPhone.getText().toString().length()!=11){
                    Toast.makeText(mActivity, "请输入11位数字的手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                v.nextPhone(loginEdPhone.getText().toString());
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_loginbyphone;
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
