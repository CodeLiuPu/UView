package com.update.uview.layout_inflate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.AsyncLayoutInflater;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.update.uview.R;

/**
 * @author : liupu
 * date   : 2019/10/12
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class AsyncLayoutInflaterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new AsyncLayoutInflater(this).inflate(R.layout.view_drag_bubble, null, new AsyncLayoutInflater.OnInflateFinishedListener() {
            @Override
            public void onInflateFinished(@NonNull View view, int i, @Nullable ViewGroup viewGroup) {
                setContentView(view);
            }
        });

//        setContentView(R.layout.view_drag_bubble);

    }

}
