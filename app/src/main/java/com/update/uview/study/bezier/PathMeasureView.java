package com.update.uview.study.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author : liupu
 * date   : 2019/11/13
 * desc   : PathMeasure 学习类
 * github : https://github.com/CodeLiuPu/
 */
public class PathMeasureView extends View {

    private Paint mPaint;
    private Path mPath;

    public PathMeasureView(Context context) {
        this(context, null);
    }

    public PathMeasureView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathMeasureView(Context context, AttributeSet attrs, int defStyleAttr) {
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();
        path.lineTo(0, 200);
        path.lineTo(200, 200);
        path.lineTo(200, 0);

        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, mPaint);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), mPaint);
        canvas.translate(getWidth() / 2, getHeight() / 2);

        /**
         * pathMeasure 需要关联一个 创建好的 path
         * forceClosed会影响Path的测量结果
         */
        PathMeasure pathMeasure = new PathMeasure();
        pathMeasure.setPath(path, false);
        log("onDraw: forceCloseed = false " + pathMeasure.getLength());

        canvas.drawPath(path, mPaint);
    }


    private void log(String msg) {
        Log.e("UPDATE", "UPDATE msg : " + msg);
    }
}
