package com.update.uview.layout.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * @author : liupu
 * date   : 2019/10/12
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


}