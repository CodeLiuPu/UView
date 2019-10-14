package com.update.uview.layout.flow_layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.update.uview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liupu
 * date   : 2019/10/12
 * desc   : 流布局
 * github : https://github.com/CodeLiuPu/
 */
public class FlowLayout extends ViewGroup {
    private static final String TAG = "FlowLayout";
    private static final int LEFT = -1;
    private static final int CENTER = 0;
    private static final int RIGHT = 1;

    protected List<List<View>> mAllViews = new ArrayList<>();
    protected List<Integer> mLineHeight = new ArrayList<>();
    protected List<Integer> mLineWidth = new ArrayList<>();
    private int mGravity;
    private List<View> lineViews = new ArrayList<>();

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.flow_layout);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


}