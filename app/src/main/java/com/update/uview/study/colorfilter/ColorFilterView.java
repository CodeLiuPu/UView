package com.update.uview.study.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
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
    private ColorMatrixColorFilter mColorMatrixColorFilter;

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

//        ColorMatrix cm = new ColorMatrix();
//        //亮度调节
//        cm.setScale(1,2,1,1);

//        //饱和度调节0-无色彩， 1- 默认效果， >1饱和度加强
//        cm.setSaturation(2);

        //色调调节
//        cm.setRotate(0, 45);

//        mColorMatrixColorFilter = new ColorMatrixColorFilter(cm);


        LightingColorFilter lightingColorFilter = new LightingColorFilter(0x00ffff,0x000000);
        mPaint.setColorFilter(lightingColorFilter);
        canvas.drawBitmap(mBitmap,100,0,mPaint);
    }











    private void test(){
        float[] colorMatrix = {
                2, 0, 0, 0, 0,   //red
                0, 1, 0, 0, 0,   //green
                0, 0, 1, 0, 0,   //blue
                0, 0, 0, 1, 0    //alpha
        };

        ColorMatrix cm = new ColorMatrix();

        // 亮度调节
        cm.setScale(1,2,1,1);
    }
}
