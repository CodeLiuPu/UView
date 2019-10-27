package com.update.uview.study;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.SweepGradient;
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
//        mPaint.setAlpha(100); // 设置透明度 范围是 0 ~ 255
        mPaint.setARGB(100,255,0,0);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        mPaint.setShader(new SweepGradient(200,200,Color.BLUE,Color.RED));
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
        mPaint.setColorFilter(new LightingColorFilter(0x00ffff,0x000000));
        mPaint.setFilterBitmap(true);
        mPaint.setTextScaleX(2);
        mPaint.setTextSize(26);
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setUnderlineText(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText("Hello", 100, 100, mPaint);

    }
}
