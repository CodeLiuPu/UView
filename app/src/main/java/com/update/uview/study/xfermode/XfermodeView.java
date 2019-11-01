package com.update.uview.study.xfermode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

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
    private int mWidth;
    private int mHeight;


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
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //禁止硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        setBackgroundColor(Color.GRAY);

        // 离屏绘制
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), mPaint, Canvas.ALL_SAVE_FLAG);

        // 绘制
        Bitmap srcBitmap = createCircleBitmap(mWidth, mHeight);
        canvas.drawBitmap(srcBitmap, 0, 0, mPaint);

        // 设置 图层混合模式
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));

        // 绘制 dst 图层
        Bitmap dstBitmap = createRectBitmap(mWidth, mHeight);
        canvas.drawBitmap(dstBitmap, 0, 0, mPaint);

        // 清除 图层混合模式
        mPaint.setXfermode(null);

        canvas.restoreToCount(layerId);
    }

    private Bitmap createRectBitmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        Rect rect = new Rect(width / 20, height / 3, width * 2 / 3, height * 19 / 20);
        canvas.drawRect(rect, paint);
        return bitmap;
    }

    private Bitmap createCircleBitmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        canvas.drawCircle(width * 2 / 3, height / 3, height / 4, paint);
        return bitmap;
    }

}
