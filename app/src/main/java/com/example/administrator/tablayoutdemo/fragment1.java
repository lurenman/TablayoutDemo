package com.example.administrator.tablayoutdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/9.
 */

public class fragment1 extends android.support.v4.app.Fragment {
    private TextView tv_title;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);
        tv_title= (TextView) view.findViewById(R.id.tv_title);
        Bundle arguments = getArguments();
        if (null!=arguments)
        {
            String fragment_title = arguments.getString("fragment_title");
            if (!fragment_title.isEmpty())
            tv_title.setText(fragment_title);
        }

        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
