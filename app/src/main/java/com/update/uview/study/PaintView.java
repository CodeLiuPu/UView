package com.update.uview.study;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author : liupu
 * date   : 2019/10/25
 * desc   : Paint 学习类
 * github : https://github.com/CodeLiuPu/
 */
public class PaintView extends View {
    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
