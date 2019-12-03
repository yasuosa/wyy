package cn.rpy.wyy.mvc.login.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuexiang.xui.widget.button.CountDownButton;
import com.xuexiang.xui.widget.edittext.verify.VerifyCodeEditText;
import com.xuexiang.xui.widget.textview.autofit.AutoFitTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.rpy.wyy.R;
import cn.rpy.wyy.base.mvc.BaseFragment;
import cn.rpy.wyy.mvc.login.contract.LoginContract;
import cn.rpy.wyy.mvc.login.presenter.LoginPresenter;
import cn.rpy.wyy.mvc.login.view.activity.LoginActivity;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/3
 * @desc :
 */
public class LoginPhoneSmsFragment extends BaseFragment {

    @BindView(R.id.login_phone_sms_phone)
    AutoFitTextView loginPhoneSmsPhone;
    @BindView(R.id.login_phone_sms_send)
    CountDownButton loginPhoneSmsSend;
    @BindView(R.id.login_phone_sms_pass)
    VerifyCodeEditText loginPhoneSmsPass;
    private LoginContract.v v;
    private String phone;

    @Override
    protected void initView() {
        loginPhoneSmsSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v.sendSms(phone);
            }
        });
        loginPhoneSmsPass.setOnInputListener(new VerifyCodeEditText.OnInputListener() {
            @Override
            public void onComplete(String input) {

            }

            @Override
            public void onChange(String input) {
                if(input.length()==4){
                    v.sendCode(input);
                }
            }

            @Override
            public void onClear() {

            }
        });
    }

    public void setPhone(String phone){
        this.phone=phone;
        loginPhoneSmsPhone.setText("+86 "+phone.substring(0,3)+"****"+phone.substring(7,11));
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_loginbyphone_sms;
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

    public void setLoginListener(LoginContract.v v) {
        this.v = v;
    }

}
