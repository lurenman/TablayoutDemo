# TablayoutDemo
#导入依赖
    
    compile 'com.android.support:design:25.3.1'
android 端Tablayout加ViewPager的使用，三种adapter供参
 xml布局文件通过tab属性可以设置tab字体颜色大小等
 
     <android.support.design.widget.TabLayout
        android:id="@+id/tl"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:tabIndicatorColor="@color/colorPrimary"
        app:tabSelectedTextColor="@color/color_titlestate1"
        app:tabTextColor="@color/colorPrimary"
        app:tabIndicatorHeight="1.5dp"
        app:tabMode="scrollable"
        app:tabTextAppearance="@style/TabLayoutTextStyle"
        app:tabGravity="center"/>
  代码中主要通过三部设置就可以达到效果
   
        mTabLayout.setTabsFromPagerAdapter(mAdapter1);
        mViewPager.setAdapter(mAdapter1);
        mTabLayout.setupWithViewPager(mViewPager);
 
