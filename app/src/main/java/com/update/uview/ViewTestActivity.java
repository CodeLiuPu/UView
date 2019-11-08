package com.update.uview;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.update.uview.study.bezier.PathView;

/**
 * @author : liupu
 * date   : 2019/11/7
 * desc   : ViewTest 类
 * github : https://github.com/CodeLiuPu/
 */
public class ViewTestActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PathView(this));
//        setContentView(R.layout.activity_splash);
    }

}
