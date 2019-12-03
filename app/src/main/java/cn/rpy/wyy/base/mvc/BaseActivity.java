package cn.rpy.wyy.base.mvc;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.xuexiang.xui.utils.SnackbarUtils;
import com.xuexiang.xui.utils.WidgetUtils;
import com.xuexiang.xui.widget.dialog.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.rpy.wyy.R;

public abstract class BaseActivity<Presenter extends BasePresenter> extends AppCompatActivity implements IBaseView {

    protected Presenter mPresenter;
    private LoadingDialog loadingDialog;
    private Unbinder mBinder;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getColorId()!=-1) getWindow().setStatusBarColor(getResources().getColor(getColorId()));
        startEntryAnim();
        setContentView(getLayoutId());
        mBinder= ButterKnife.bind(this);
        init();
        initView();
        initEvent();
    }

    protected  void startEntryAnim(){
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

    protected abstract int getColorId();

    protected abstract void initEvent();

    protected abstract void initView();

    /**
     * 初始化
     */
    private void init() {
        mPresenter=createPresenter();
        if(null !=mPresenter) mPresenter.attchView(this);
        loadingDialog = WidgetUtils.getLoadingDialog(this);
        //设置旋转速度
        loadingDialog.setLoadingSpeed(8);
        loadingDialog.updateMessage(R.string.loadingMsg);
        loadingDialog.setIconScale(0.4f);
        loadingDialog.setLoadingIcon(R.drawable.loadmuisc);
    }

    /**
     * 初始化presenter
     * @return
     */
    protected abstract Presenter createPresenter();

    /**
     * 初始化布局
     * @return
     */
    protected abstract int getLayoutId();




    @Override
    public void showLoad() {
        loadingDialog.show();
    }

    @Override
    public void dissLoad() {
        if(loadingDialog.isLoading()){
            loadingDialog.dismiss();
        }
    }

    @Override
    public void showSnackBarMsg(String msg) {
        SnackbarUtils.Short(null,msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mBinder != null && mBinder != mBinder.EMPTY){
            if(mPresenter!=null) mPresenter.unAttachView();
            mBinder.unbind();
            mBinder = null;
        }
    }


}
