package com.update.uview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.update.uview.study.canvas.CanvasDrawView;
import com.update.uview.study.canvas.CanvasTransformView;

/**
 * google APIDemo
 */
public class ViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new SampleView(this));
        setContentView(new CanvasDrawView(this));
    }


}
