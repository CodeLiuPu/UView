package com.update.uview.study.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author : liupu
 * date   : 2019/11/5
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class CanvasTransformView extends View {

    private Paint mPaint;

    public CanvasTransformView(Context context) {
        this(context, null);
    }

    public CanvasTransformView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasTransformView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 1. 平移操作
        Rect rect = new Rect(0, 0, 400, 400);
        canvas.drawRect(rect, mPaint);
        mPaint.setColor(Color.BLUE);

        canvas.translate(100, 100);
        canvas.drawRect(rect, mPaint);
        canvas.drawLine(0, 0, 600, 600, mPaint);

        // 2. 缩放操作
//        Rect rect = new Rect(200, 200, 700, 700);
//        canvas.drawRect(rect, mPaint);
//        canvas.scale(0.5f, 0.5f);
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(rect, mPaint);
//        canvas.scale(1.1f, 1.1f);
//        mPaint.setColor(Color.GREEN);
//        canvas.drawRect(rect, mPaint);

    }
}
