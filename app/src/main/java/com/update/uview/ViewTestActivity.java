package com.update.uview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author : liupu
 * date   : 2019/11/7
 * desc   : ViewTest 类
 * github : https://github.com/CodeLiuPu/
 */
public class ViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new CanvasDrawView(this));
        setContentView(R.layout.activity_splash);
    }

}
