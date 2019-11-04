package com.update.uview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.update.uview.study.xfermode.XfermodeEraserView;

/**
 * google APIDemo
 */
public class ViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new SampleView(this));
        setContentView(new XfermodeEraserView(this));
    }


}
