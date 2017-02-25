package com.guigushangchengkaoshier;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.guigushangchengkaoshier.base.BaseFragment;
import com.guigushangchengkaoshier.community.CommunityFragment;
import com.guigushangchengkaoshier.fragment.HomeFragment;
import com.guigushangchengkaoshier.shopping.ShoppintCatFragment;
import com.guigushangchengkaoshier.type.TypeFragment;
import com.guigushangchengkaoshier.user.UserFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.fl_main)
    FrameLayout flMain;
    @InjectView(R.id.rg_main)
    RadioGroup rgMain;

    private ArrayList<BaseFragment> fragmens;

    private int position;

    private Fragment tempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initFragment();

        initListener();

    }

    private void initListener() {

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_main_contact:
                        position = 1;
                        break;
                    case R.id.rb_community:
                        position = 2;
                        break;

                    case R.id.rb_cart:
                        position = 3;
                        break;
                    case R.id.rb_user:
                        position = 4;
                        break;

                }
                Fragment currentFragment = fragmens.get(position);
                switchFragment(currentFragment);

            }
        });
        rgMain.check(R.id.rb_home);
    }

    private void switchFragment(Fragment currentFragment) {

        if(tempFragment!=currentFragment){

            FragmentTransaction ft=getSupportFragmentManager().beginTransaction();

            if(!currentFragment.isAdded()){

                if(tempFragment!=null){

                    ft.hide(tempFragment);

                }
                ft.add(R.id.fl_main,currentFragment);

            }else {

                if(tempFragment!=null){

                    ft.hide(tempFragment);

                }
                ft.show(currentFragment);
            }
            ft.commit();

            tempFragment=currentFragment;

        }

    }
    private void initFragment() {
        fragmens=new ArrayList<>();

        fragmens.add(new HomeFragment());
        fragmens.add(new TypeFragment());
        fragmens.add(new CommunityFragment());
        fragmens.add(new ShoppintCatFragment());
        fragmens.add(new UserFragment());

//        defaultFragment(fragmens.get(position));
    }


}
