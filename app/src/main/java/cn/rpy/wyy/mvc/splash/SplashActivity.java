package cn.rpy.wyy.mvc.splash;

import android.content.Intent;
import android.widget.ImageView;

import com.xuexiang.xui.utils.ViewUtils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import cn.rpy.wyy.R;
import cn.rpy.wyy.base.mvc.BaseActivity;
import cn.rpy.wyy.base.mvc.BasePresenter;
import cn.rpy.wyy.mvc.login.view.activity.LoginActivity;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/2 22:33
 * @desc :
 */
public class SplashActivity extends BaseActivity {
    @BindView(R.id.splash_img_logo)
    ImageView splashImgLogo;

    @Override
    protected int getColorId() {
        return -1;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {
        ViewUtils.fadeIn(splashImgLogo,1500,null);
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        };
        timer.schedule(timerTask,2000);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_spalsh;
    }

    @Override
    public void onSuccess(String msg) {

    }

    @Override
    public void onFail(String msg) {

    }
}
