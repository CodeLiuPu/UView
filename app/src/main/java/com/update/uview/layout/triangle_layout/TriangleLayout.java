package com.update.uview.layout.triangle_layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * @author : liupu
 * date   : 2019/10/14
 * desc   : 三角形布局
 * github : https://github.com/CodeLiuPu/
 */
public class TriangleLayout extends ViewGroup {
    public TriangleLayout(Context context) {
        this(context, null);
    }

    public TriangleLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TriangleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}