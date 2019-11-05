package com.update.uview.study.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.View;

import com.update.uview.R;

/**
 * @author : liupu
 * date   : 2019/11/4
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class ColorFilterView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;

    public ColorFilterView(Context context) {
        this(context, null);
    }

    public ColorFilterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.colorfilter_girl);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


// ------------------- LightingColorFilter ------------------------
//        // 原图
//        LightingColorFilter lightingColorFilter = new LightingColorFilter(0xffffff,0x000000);
//        // 过滤红色
////        LightingColorFilter lightingColorFilter = new LightingColorFilter(0x00ffff,0x000000);
//        // 绿色更亮
////        LightingColorFilter lightingColorFilter = new LightingColorFilter(0xffffff,0x003000);
//
//        mPaint.setColorFilter(lightingColorFilter);
//        canvas.drawBitmap(mBitmap,100,100,mPaint);
// ---------------------------------------------------------------


// ------------------- PorterDuffColorFilter ------------------------
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD);
        mPaint.setColorFilter(porterDuffColorFilter);
        canvas.drawBitmap(mBitmap, 100, 100, mPaint);
// ---------------------------------------------------------------


// ------------------- ColorMatrixColorFilter ------------------------

//        float[] colorMatrix = {
//                1, 0, 0, 0, 0,   //red
//                0, 1, 0, 0, 0,   //green
//                0, 0, 1, 0, 0,   //blue
//                0, 0, 0, 1, 0    //alpha
//        };
//
//        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
//        mPaint.setColorFilter(colorMatrixColorFilter);
//        canvas.drawBitmap(mBitmap, 100, 100, mPaint);


        ColorMatrix cm = new ColorMatrix();
        //亮度调节
//        cm.setScale(100, 1, 1, 1);

        //饱和度调节
        cm.setSaturation(1);

        //色调调节
        cm.setRotate(0, 45);

        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(cm);
        mPaint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(mBitmap, 100, 100, mPaint);

// ---------------------------------------------------------------
    }

}
