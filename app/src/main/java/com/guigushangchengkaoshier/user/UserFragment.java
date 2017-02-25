package com.guigushangchengkaoshier.user;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.guigushangchengkaoshier.base.BaseFragment;

/**
 * Created by 潘鹏程 on 2017/2/22.
 * 微信:13212223597
 * QQ:591738374
 * 作用:
 */

public class UserFragment extends BaseFragment {

    private TextView textView;
    @Override
    public View initView() {

        textView=new TextView(mContext);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e("TAG","用户的数据被初始化了");
        textView.setText("用户内容");
    }
}
