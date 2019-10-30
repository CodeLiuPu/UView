package com.update.uview.study.xfermode;

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
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import com.update.uview.R;

/**
 * @author : liupu
 * date   : 2019/10/25
 * desc   : Xfermode 学习类
 * github : https://github.com/CodeLiuPu/
 */
public class XfermodeView extends View {

    private static final Xfermode[] xfermodes = {
            new PorterDuffXfermode(PorterDuff.Mode.CLEAR),
            new PorterDuffXfermode(PorterDuff.Mode.SRC),
            new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER),
            new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP),
            new PorterDuffXfermode(PorterDuff.Mode.SRC_IN),
            new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT),
            new PorterDuffXfermode(PorterDuff.Mode.DST),
            new PorterDuffXfermode(PorterDuff.Mode.DST_OVER),
            new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP),
            new PorterDuffXfermode(PorterDuff.Mode.DST_IN),
            new PorterDuffXfermode(PorterDuff.Mode.DST_OUT),
            new PorterDuffXfermode(PorterDuff.Mode.XOR),
            new PorterDuffXfermode(PorterDuff.Mode.DARKEN),
            new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN),
            new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY),
            new PorterDuffXfermode(PorterDuff.Mode.SCREEN),
            new PorterDuffXfermode(PorterDuff.Mode.ADD),
            new PorterDuffXfermode(PorterDuff.Mode.OVERLAY)
    };

    private Paint mPaint;

    public XfermodeView(Context context) {
        this(context, null);
    }

    public XfermodeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XfermodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.beauty);
        Shader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
//        Shader linearGradient = new LinearGradient(0, 0, 500, 500, Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        Shader linearGradient = new LinearGradient(250, 250, 300, 300, Color.RED, Color.BLUE, Shader.TileMode.CLAMP);
        Shader shader = new ComposeShader(bitmapShader, linearGradient, PorterDuff.Mode.DARKEN);

        mPaint.setShader(shader);
//        canvas.drawCircle(250, 250, 250, mPaint);
        Rect rect = new Rect(0, 0, 500, 500);
        canvas.drawRect(rect, mPaint);
    }

}
