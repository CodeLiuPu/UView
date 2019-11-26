package com.update.uview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.update.uview.choreographer.ChoreographerFragment;

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
