package com.update.uview.study;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author : liupu
 * date   : 2019/10/25
 * desc   : Paint 学习类
 * github : https://github.com/CodeLiuPu/
 */
public class PaintView extends View {

    private Paint mPaint;

    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE); // 设置颜色
        mPaint.setAlpha(100); // 设置透明度 范围是 0 ~ 255

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("Hello", 100, 100, mPaint);

    }
}
