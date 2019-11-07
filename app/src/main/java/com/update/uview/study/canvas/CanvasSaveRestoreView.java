package com.update.uview.study.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author : liupu
 * date   : 2019/11/7
 * desc   : Canvas 状态保存和恢复 Api
 * github : https://github.com/CodeLiuPu/
 */
public class CanvasSaveRestoreView extends View {

    private Paint mPaint;

    public CanvasSaveRestoreView(Context context) {
        this(context, null);
    }

    public CanvasSaveRestoreView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasSaveRestoreView(Context context, AttributeSet attrs, int defStyleAttr) {
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

        // ----------------------- save & restore ----------------------
//        Log.e("update","update save count = " + canvas.getSaveCount());
//        canvas.drawRect(0, 0, 300,  300, mPaint);
//
//        // 保存当前 画布的状态(坐标系)
//        canvas.save();
//        Log.e("update","update save count = " + canvas.getSaveCount());
//
//        // 各种操作...
//        canvas.translate(100, 100);
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(0, 0, 400, 400, mPaint);
//        // 恢复到之前保存的 画布状态(坐标系)
//
//        canvas.restore();
//        Log.e("update","update save count = " + canvas.getSaveCount());
//
//        mPaint.setColor(Color.GREEN);
//        canvas.drawRect(0, 0, 400, 400, mPaint);


        // ------------------------ saveToCount ------------------------
        Log.e("update", "update save count = " + canvas.getSaveCount());
        canvas.drawRect(0, 0, 300, 300, mPaint);

        // 保存当前 画布的状态(坐标系)
        int layerCount = canvas.save();
        Log.e("update", "update save count = " + canvas.getSaveCount());

        // 各种操作...
        canvas.translate(100, 100);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, 400, 400, mPaint);
        // 再次保存
        canvas.save();

        // 恢复到第一次保存的层级
        canvas.restoreToCount(layerCount);
        Log.e("update", "update save count = " + canvas.getSaveCount());

        mPaint.setColor(Color.GREEN);
        canvas.drawRect(0, 0, 400, 400, mPaint);
    }
}
