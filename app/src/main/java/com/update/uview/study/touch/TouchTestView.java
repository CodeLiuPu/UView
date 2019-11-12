package com.update.uview.study.touch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author : liupu
 * date   : 2019/11/12
 * desc   : TouchTestView
 * github : https://github.com/CodeLiuPu/
 */
public class TouchTestView extends View {

    private Paint mPaint;
    private PointF mRect;
    private float mRadius = 10;

    public TouchTestView(Context context) {
        this(context, null);
    }

    public TouchTestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TouchTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.FILL);

        mRect = new PointF();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRect.set(w / 2, h / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mRect.x, mRect.y, mRadius, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                mRect.set(event.getX(), event.getY());
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
        }
        return true;
    }
}
