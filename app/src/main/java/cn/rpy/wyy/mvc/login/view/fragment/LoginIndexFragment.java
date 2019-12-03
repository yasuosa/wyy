package cn.rpy.wyy.mvc.login.view.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.xuexiang.xui.widget.button.ButtonView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.rpy.wyy.R;
import cn.rpy.wyy.base.mvc.BaseFragment;
import cn.rpy.wyy.base.mvc.BasePresenter;
import cn.rpy.wyy.constant.AppConstant;
import cn.rpy.wyy.mvc.login.contract.LoginContract;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/3
 * @desc :
 */
public class LoginIndexFragment extends BaseFragment  {
    @BindView(R.id.login_btn_phoneLogin)
    ButtonView loginBtnPhoneLogin;
    @BindView(R.id.login_cb_xy)
    CheckBox loginCbXy;
    @BindView(R.id.login_ll_xy)
    LinearLayout loginLlXy;
    Unbinder unbinder;

    //底部抖动
    private float x;
    private ObjectAnimator transXtoRight;
    private ObjectAnimator transRighttoX;
    private ObjectAnimator transLefttoX;
    private ObjectAnimator transXtoLeft;
    private AnimatorSet set;
    private static final int speed=10;

    private LoginContract.v v;

    @Override
    protected void initView() {
        initAnim();
        initEvent();
    }

    private void initAnim() {
        x = loginLlXy.getX();
        transXtoRight = ObjectAnimator.ofFloat(loginLlXy,"translationX",x,x+speed);
        transXtoRight.setDuration(50);
        transRighttoX= ObjectAnimator.ofFloat(loginLlXy,"translationX",x+speed,x);
        transRighttoX.setDuration(50);
        transXtoLeft = ObjectAnimator.ofFloat(loginLlXy, "translationX", x , x-speed);
        transXtoLeft.setDuration(50);
        transLefttoX = ObjectAnimator.ofFloat(loginLlXy, "translationX", x - speed, x);
        transLefttoX.setDuration(50);
        set = new AnimatorSet();
        set.playSequentially(transXtoRight,transRighttoX,transXtoLeft,transLefttoX);
    }

    private void initEvent() {
        loginBtnPhoneLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkXy()){
                    //dosth

                }
            }
        });
    }

    private boolean checkXy(){
        if(loginCbXy.isChecked()){
            v.next(AppConstant.LOGIN_PHONE_FRAGMENT);
            return true;
        }else {
            set.start();
            Toast.makeText(getContext(), "请先勾选同意\"用户协议\"和\"隐私政策\"", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login_index;
    }

    @Override
    protected BasePresenter createrPresenter() {
        return null;
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

    public  void setOnNextListener(LoginContract.v v){
        this.v=v;
    }


}
