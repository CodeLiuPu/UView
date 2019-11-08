package com.update.uview.study.bezier;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author : liupu
 * date   : 2019/11/8
 * desc   : 贝塞尔曲线 学习类 (QQ气泡效果)
 * github : https://github.com/CodeLiuPu/
 */
public class DragBubbleView extends View {
    private Paint mPaint;
    private Path mPath;

    public DragBubbleView(Context context) {
        this(context, null);
    }

    public DragBubbleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragBubbleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();
    }
}