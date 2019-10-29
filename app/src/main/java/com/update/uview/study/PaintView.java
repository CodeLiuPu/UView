package com.update.uview.study;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.update.uview.R;

/**
 * @author : liupu
 * date   : 2019/10/25
 * desc   : Paint 学习类
 * github : https://github.com/CodeLiuPu/
 */
public class PaintView extends View {

    private Paint mPaint;

    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
//        mPaint.setColor(Color.BLUE); // 设置颜色
//        mPaint.setAlpha(100); // 设置透明度 范围是 0 ~ 255
//        mPaint.setARGB(100,255,0,0);
        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setStrokeWidth(3);
//        mPaint.setStrokeCap(Paint.Cap.SQUARE);
//        mPaint.setStrokeJoin(Paint.Join.BEVEL);
//        mPaint.setShader(new SweepGradient(200,200,Color.BLUE,Color.RED));
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
//        mPaint.setColorFilter(new LightingColorFilter(0x00ffff,0x000000));
//        mPaint.setFilterBitmap(true);
//        mPaint.setTextScaleX(2);
//        mPaint.setTextSize(26);
//        mPaint.setTextAlign(Paint.Align.LEFT);
//        mPaint.setUnderlineText(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        Shader shader = new LinearGradient(0, 0, 500, 500, Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
//        Shader shader = new LinearGradient(0, 0, 500, 500, new int[]{Color.RED, Color.BLUE, Color.GREEN}, new float[]{0.3f, 0.6f, 1f}, Shader.TileMode.CLAMP);

//        Shader shader = new RadialGradient(250, 250, 250, Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
//        Shader shader = new RadialGradient(250, 250, 250, new int[]{Color.RED, Color.BLUE, Color.GREEN}, new float[]{0.3f, 0.6f, 1f}, Shader.TileMode.CLAMP);

//        Shader shader = new SweepGradient(250f,250f,Color.RED,Color.BLUE);
//        Shader shader = new SweepGradient(250f, 250f, new int[]{Color.RED, Color.BLUE, Color.GREEN}, new float[]{0.3f, 0.6f, 1f});

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.beauty);
//        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.beauty);
        Shader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        Shader linearGradient = new LinearGradient(0, 0, 500, 500, Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        Shader shader = new ComposeShader(bitmapShader, linearGradient, PorterDuff.Mode.MULTIPLY);

        mPaint.setShader(shader);
        canvas.drawCircle(250, 250, 250, mPaint);

//        Rect rect = new Rect(0,0,500,500);
//        RectF rect = new RectF(0, 0, 500, 500);

//        canvas.drawRect(rect, mPaint);

    }
}
