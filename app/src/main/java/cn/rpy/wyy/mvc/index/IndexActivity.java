package cn.rpy.wyy.mvc.index;

import cn.rpy.wyy.R;
import cn.rpy.wyy.base.mvc.BaseActivity;
import cn.rpy.wyy.base.mvc.BasePresenter;

/**
 * @author : renpy
 * @e-mail : 601529188@qq.com
 * @date : 2019/12/3
 * @desc :
 */
public class IndexActivity extends BaseActivity {
    @Override
    protected int getColorId() {
        return -1;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_index;
    }

    @Override
    public void onSuccess(String msg) {

    }

    @Override
    public void onFail(String msg) {

    }
}
