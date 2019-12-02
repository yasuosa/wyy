package cn.rpy.wyy.mvc.splash;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.xuexiang.xui.utils.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.rpy.wyy.R;
import cn.rpy.wyy.base.mvc.BaseActivity;
import cn.rpy.wyy.base.mvc.BasePresenter;

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
    protected void initEvent() {

    }

    @Override
    protected void initView() {
        ViewUtils.fadeIn(splashImgLogo,2000,null);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_spalsh;
    }
}
