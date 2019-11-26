package com.update.uview.layout_inflate;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.update.uview.R;
import com.update.uview.choreographer.ChoreographerFragment;

/**
 * @author : liupu
 * date   : 2019/10/12
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class LayoutInflaterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        LayoutInflaterCompat.setFactory2(getLayoutInflater(), new LayoutInflater.Factory2() {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
                // 对View执行一些 Hook 逻辑
                /**
                 * 使用场景 2
                 * 计算 View 创建消耗的时间
                 */
                long startTime = System.currentTimeMillis();
                View view = getDelegate().createView(parent, name, context, attrs);
                Log.e("update", "viewName " + name + " costTime " + (System.currentTimeMillis() - startTime));
                return view;
            }

            @Override
            public View onCreateView(String name, Context context, AttributeSet attrs) {
                return null;
            }
        });


        super.onCreate(savedInstanceState);
//        setContentView(new PathMeasureView(this));
//        setContentView(R.layout.view_drag_bubble);
        addFragment(new ChoreographerFragment());
    }

    private void addFragment(@NonNull Fragment fragment) {
        setContentView(R.layout.activity_fragment_container);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_container, fragment);
        ft.commitAllowingStateLoss();
    }
}
