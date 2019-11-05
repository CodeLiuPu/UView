package com.update.uview.study.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

        canvas.drawCircle(100,100,50,mPaint);
    }
}
