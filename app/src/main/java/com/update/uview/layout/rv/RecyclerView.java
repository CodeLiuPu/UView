package com.update.uview.layout.rv;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author : liupu
 * date   : 2019/11/25
 * desc   : 手写RecyclerView
 * github : https://github.com/CodeLiuPu/
 */
public class RecyclerView extends ViewGroup {

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint({"Recycle", "CustomViewStyleable"})
    public RecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


}
