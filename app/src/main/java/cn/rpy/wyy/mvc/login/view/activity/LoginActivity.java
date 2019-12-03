package cn.rpy.wyy.mvc.login.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xuexiang.xui.utils.StatusBarUtils;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xui.widget.toast.XToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.rpy.wyy.R;
import cn.rpy.wyy.base.mvc.BaseActivity;
import cn.rpy.wyy.base.mvc.BaseFragment;
import cn.rpy.wyy.base.mvc.BasePresenter;
import cn.rpy.wyy.constant.AppConstant;
import cn.rpy.wyy.domain.LoginInfo;
import cn.rpy.wyy.mvc.index.IndexActivity;
import cn.rpy.wyy.mvc.login.contract.LoginContract;
import cn.rpy.wyy.mvc.login.presenter.LoginPresenter;
import cn.rpy.wyy.mvc.login.view.fragment.LoginIndexFragment;
import cn.rpy.wyy.mvc.login.view.fragment.LoginPassFragment;
import cn.rpy.wyy.mvc.login.view.fragment.LoginPhoneFragment;
import cn.rpy.wyy.mvc.login.view.fragment.LoginPhoneSmsFragment;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/2 23:11
 * @desc :
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.v {


    @BindView(R.id.login_tb_title)
    TitleBar loginTbTitle;
    private LoginIndexFragment indexFragment = new LoginIndexFragment();
    private LoginPhoneFragment phoneFragment = new LoginPhoneFragment();
    private LoginPassFragment passFragment=new LoginPassFragment();
    private LoginPhoneSmsFragment smsFragment=new LoginPhoneSmsFragment();
    //手机号
    public  String phone;
    private Bundle bundle;


    @Override
    protected int getColorId() {
        return R.color.xui_btn_blue_normal_color;
    }

    @Override
    protected void initEvent() {

        indexFragment.setOnNextListener(this);
        phoneFragment.setLoginListener(this);
        smsFragment.setLoginListener(this);
        passFragment.setLoginListener(this);
        loginTbTitle.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popBackFragment();
            }
        });
    }

    /***
     * 依次回退
     */
    private void popBackFragment(){
        if(fragments.size()!=0) {
            Fragment fragment = fragments.get(fragments.size() - 1);
            getSupportFragmentManager().beginTransaction()
                    .hide(currentFragment)
                    .show(fragment)
                    .commit();
            currentFragment=fragment;
            fragments.remove(fragment);
            if(currentFragment instanceof LoginIndexFragment){
                loginTbTitle.setVisibility(View.GONE);
            }
        }
    }

    @Override
    protected void initView() {
        initFragment();
    }

    private void initFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.login_ll_fgm, indexFragment)
                .add(R.id.login_ll_fgm, phoneFragment)
                .add(R.id.login_ll_fgm,passFragment)
                .add(R.id.login_ll_fgm,smsFragment)
                .hide(indexFragment)
                .hide(phoneFragment)
                .hide(passFragment)
                .hide(smsFragment)
                .show(currentFragment)
                .commit();
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void next(String name) {
        showFragment(name);
    }


    @Override
    public void nextPhone(String phone) {
        this.phone=phone;
        showLoad();
        mPresenter.is_register(phone);
    }


    /**
     * 判断是否注册过
     * @param isB
     */
    @Override
    public void isRegister(boolean isB) {
        dissLoad();
        if(isB){
            next(AppConstant.PHONE_IS_REGISTER);
        }else {
            next(AppConstant.PHONE_SMS);
        }
    }

    @Override
    public void netErr(String err) {
        dissLoad();
        Toast.makeText(this, ""+err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void login(String phone, String pass) {
        showLoad();
        mPresenter.login(phone,pass);
    }

    @Override
    public void sendSms(String phone) {
        showLoad();
        mPresenter.getCode(phone);
    }

    @Override
    public void sendCode(String code) {
        showLoad();
        mPresenter.loginByPhoneCode(phone,code);
    }

    @Override
    public void loginBySuc(LoginInfo.AccountBean account) {
        dissLoad();
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, IndexActivity.class));
        finish();
    }

    @Override
    public void loginByFail(String msg) {
        dissLoad();
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }


    private List<Fragment> fragments=new ArrayList<>();
    private Fragment currentFragment=indexFragment;
    private void showFragment(String name) {
        bundle = new Bundle();
        loginTbTitle.setVisibility(View.VISIBLE);
        fragments.add(currentFragment);
        switch (name) {
            case AppConstant.LOGIN_PHONE_FRAGMENT:
                getSupportFragmentManager().beginTransaction()
                        .hide(currentFragment)
                        .show(phoneFragment).commit();
                currentFragment=phoneFragment;
                break;

            case AppConstant.PHONE_IS_REGISTER:
                passFragment.setPhone(phone);
                getSupportFragmentManager().beginTransaction()
                        .hide(currentFragment)
                        .show(passFragment)
                        .commit();
                currentFragment=passFragment;
                break;

            case AppConstant.PHONE_SMS:
                smsFragment.setPhone(phone);
                getSupportFragmentManager().beginTransaction()
                        .hide(currentFragment)
                        .show(smsFragment)
                        .commit();
                currentFragment=smsFragment;
                break;
        }
    }


    @Override
    public void onSuccess(String msg) {
        dissLoad();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail(String msg) {
        dissLoad();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            popBackFragment();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
