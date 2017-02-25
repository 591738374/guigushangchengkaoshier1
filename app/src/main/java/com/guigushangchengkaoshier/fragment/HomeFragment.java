package com.guigushangchengkaoshier.fragment;

import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.guigushangchengkaoshier.Constants;
import com.guigushangchengkaoshier.R;
import com.guigushangchengkaoshier.base.BaseFragment;
import com.guigushangchengkaoshier.bean.HomeBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 潘鹏程 on 2017/2/24.
 * 微信:13212223597
 * QQ:591738374
 * 作用:
 */

public class HomeFragment  extends BaseFragment{

    private static final String TAG=HomeFragment.class.getSimpleName();

    @InjectView(R.id.ll_main_scan)
    LinearLayout llMainScan;
    @InjectView(R.id.tv_search_home)
    TextView tvSearchHome;
    @InjectView(R.id.tv_message_home)
    TextView tvMessageHome;
    @InjectView(R.id.rv_home)
    android.support.v7.widget.RecyclerView rvHome;
    @InjectView(R.id.ib_top)
    ImageButton ibTop;




    @Override
    public View initView() {
        Log.e(TAG, "主页Fragment初始化了");
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        //让当前类和视图绑定起来
        ButterKnife.inject(HomeFragment.this, view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e("TAG", "主页的数据被初始化了");

        getDataFromNet();
    }

    public void getDataFromNet() {
        OkHttpUtils
                .get()
                .url(Constants.HOME_URL)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG","联网失败==" +e.getMessage());
                    }

                    @Override
                    public void onError(okhttp3.Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG","联网成功==");
//                        processData(response);

                    }
                });
    }
    private void processedData(String response) {

        //使用fastJson解析json数据
        HomeBean homeBean= JSON.parseObject(response,HomeBean.class);

        Log.e("TAG","解析数据成功=="+homeBean.getResult().getHot_info().get(0).getName());

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.tv_search_home, R.id.tv_message_home, R.id.ib_top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search_home:
                Toast.makeText(mContext,"搜索",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_message_home:
                Toast.makeText(mContext,"查看消息",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ib_top:
                Toast.makeText(mContext,"回到顶部",Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
