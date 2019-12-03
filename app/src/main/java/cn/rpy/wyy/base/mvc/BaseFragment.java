package cn.rpy.wyy.base.mvc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *
 *     author : renpy
 *     time   : 2019/12/03
 *     desc   :
 *
 */

public abstract class BaseFragment<Presenter extends BasePresenter> extends Fragment implements IBaseView {
    private Unbinder mBinder;
    protected Activity mActivity;
    protected abstract void initView(); //初始化控件
    protected abstract void loadData(); //加载数据
    protected abstract int getLayoutId(); //获取Fragment的布局id

    protected Presenter mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container,false);
        mBinder = ButterKnife.bind(this,view);
        mPresenter=createrPresenter();
        if(null!=null){
            mPresenter.attchView(this);
        }
        initView();
        return view;
    }



    protected abstract Presenter createrPresenter();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mBinder != null && mBinder != Unbinder.EMPTY){
            if(null!=mPresenter)mPresenter.unAttachView();
            mBinder.unbind();
            mBinder = null;
        }
    }




}
