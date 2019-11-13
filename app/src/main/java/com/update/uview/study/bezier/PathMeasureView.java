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
    private Paint mLinePaint; //坐标系

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
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(4);

        mLinePaint = new Paint();
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setColor(Color.RED);
        mLinePaint.setStrokeWidth(6);

        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, mLinePaint);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), mLinePaint);
        canvas.translate(getWidth() / 2, getHeight() / 2);

//        Path path = new Path();
//        path.lineTo(0, 200);
//        path.lineTo(200, 200);
//        path.lineTo(200, 0);
//
//        /**
//         * pathMeasure 需要关联一个 创建好的 path
//         * forceClosed会影响Path的测量结果
//         */
//        PathMeasure pathMeasure = new PathMeasure();
//        pathMeasure.setPath(path, false);
//        log("onDraw: " + pathMeasure.getLength());
//
//        PathMeasure pathMeasure2 = new PathMeasure();
//        pathMeasure2.setPath(path, true);
//        log("onDraw2: " + pathMeasure2.getLength());
//        canvas.drawPath(path, mPaint);

// ------------------------- new PathMeasure(path, false) ------------------------------
//        PathMeasure pathMeasure = new PathMeasure(path, false);
//        log("onDraw: " + pathMeasure.getLength());
//
//        path.lineTo(200, -200);
//        log("onDraw: " + pathMeasure.getLength());
//
//        // 如果 path 进行了调整, 需要重新调用 setPath 来进行关联
//        pathMeasure.setPath(path, false);
//        log("onDraw: " + pathMeasure.getLength());
//        canvas.drawPath(path, mPaint);

        // -------------------------------------------------------------

        Path path = new Path();
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);

        Path dst = new Path();

         // forceClosed 截取一部分存入dst中，并且使用moveTo保持截取得到的Path第一个点位置不变。
        PathMeasure pathMeasure = new PathMeasure(path, false);
        pathMeasure.getSegment(200, 1000, dst, false);

        canvas.drawPath(path, mPaint);
        canvas.drawPath(dst, mLinePaint);
    }


    private void log(String msg) {
        Log.e("UPDATE", "UPDATE msg : " + msg);
    }
}
