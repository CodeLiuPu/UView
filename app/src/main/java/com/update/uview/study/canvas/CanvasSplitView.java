package com.update.uview.study.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.update.uview.R;

/**
 * @author : liupu
 * date   : 2019/11/7
 * desc   : Canvas 粒子效果
 * github : https://github.com/CodeLiuPu/
 */
public class CanvasSplitView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;

    public CanvasSplitView(Context context) {
        this(context, null);
    }

    public CanvasSplitView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasSplitView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.split_pic);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}
