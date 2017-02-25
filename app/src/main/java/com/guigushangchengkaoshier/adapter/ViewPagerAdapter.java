package com.guigushangchengkaoshier.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.guigushangchengkaoshier.Constants;
import com.guigushangchengkaoshier.bean.HomeBean;

import java.util.List;

/**
 * Created by 潘鹏程 on 2017/2/25.
 * 微信:13212223597
 * QQ:591738374
 * 作用:
 */

public class ViewPagerAdapter extends PagerAdapter {

    private final Context mContext;

    private final List<HomeBean.ResultEntity.ActInfoEntity> datas;


    public ViewPagerAdapter(Context mContext, List<HomeBean.ResultEntity.ActInfoEntity> act_info) {
        this.mContext = mContext;
        this.datas = act_info;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        ImageView imageView=new ImageView(mContext);

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        Glide.with(mContext).load(Constants.
                BASE_URL_IMAGE+datas.get(position).getIcon_url()).into(imageView);

        container.addView(imageView);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null) {
                    listener.onItemClick(v, position);
                }
            }
        });
        return imageView;

    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view==object;
    }

    public interface OnItemCliclkListener{

        public void onItemClick(View v,int position);
    }

    private OnItemCliclkListener listener;

    public void setOnItemClickListener(OnItemCliclkListener listener){

        this.listener=listener;

    }


}
