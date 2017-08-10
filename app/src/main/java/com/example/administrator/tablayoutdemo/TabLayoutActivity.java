package com.example.administrator.tablayoutdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/10.
 */

public class TabLayoutActivity extends FragmentActivity {
    private Context mContext;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private NoScrollViewPager noscroll_viewpager;//禁止滑动的viewPager
    private String[] mTitle = new String[10];
    private String[] mData = new String[10];
    private String[] mFragmentTitle=new String[10];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        mContext=this;
        initdata();
        initViews();
        initEvents();
    }

    private void initdata()
    {
        for(int i=0;i<10;i++) {
            mTitle[i] = "title" + i;
            mData[i] = "data" + i;
            mFragmentTitle[i]="fragment"+(i+1);
        }
    }

    private void initViews() {
        mTabLayout = (TabLayout) findViewById(R.id.tl);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        noscroll_viewpager= (NoScrollViewPager) findViewById(R.id.noscroll_viewpager);
    }
    private void initEvents()
    {
        mTabLayout.setTabsFromPagerAdapter(mAdapter1);
        mViewPager.setAdapter(mAdapter1);
        mTabLayout.setupWithViewPager(mViewPager);


//        mTabLayout.setTabsFromPagerAdapter(mAdapter1);
//        noscroll_viewpager.setAdapter(mAdapter1);
//        mTabLayout.setupWithViewPager(noscroll_viewpager);


    }

    private PagerAdapter mAdapter = new PagerAdapter() {
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }

        @Override
        public int getCount() {
            return mData.length;
        }

        @Override
        public Object instantiateItem(View container, int position) {
            TextView tv = new TextView(TabLayoutActivity.this);
            tv.setTextSize(30.f);
            tv.setText(mData[position]);
            ((ViewPager) container).addView(tv);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    };
    private FragmentPagerAdapter mAdapter1=new FragmentPagerAdapter
            (TabLayoutActivity.this.getSupportFragmentManager()) {
    @Override
        public Fragment getItem(int position) {
        fragment1 fragment1 = new fragment1();
        Bundle args=new Bundle();
        args.putString("fragment_title",mFragmentTitle[position]);
        fragment1.setArguments(args);
        return fragment1;
    }

    @Override
        public int getCount() {
        return mTitle.length;
     }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitle[position];
        }
    };
    private FragmentStatePagerAdapter mAdapter2=new
            FragmentStatePagerAdapter(TabLayoutActivity.this.getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            fragment1 fragment1 = new fragment1();
            Bundle args=new Bundle();
            args.putString("fragment_title",mFragmentTitle[position]);
            fragment1.setArguments(args);
            return fragment1;
        }

        @Override
        public int getCount() {
            return mTitle.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {

            return mTitle[position];
                }
            };
}
