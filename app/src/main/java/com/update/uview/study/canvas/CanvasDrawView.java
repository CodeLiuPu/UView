package com.update.uview.study.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.update.uview.R;

/**
 * @author : liupu
 * date   : 2019/11/7
 * desc   : Canvas 绘制 Api
 * github : https://github.com/CodeLiuPu/
 */
public class CanvasDrawView extends View {

    private Paint mPaint;

    public CanvasDrawView(Context context) {
        this(context, null);
    }

    public CanvasDrawView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
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

//        canvas.drawRect(200, 200,800, 700, mPaint);

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.colorfilter_girl);
//        canvas.drawBitmap(bitmap,100,100,mPaint);

        canvas.drawCircle(300,300,100,mPaint);
    }
}
