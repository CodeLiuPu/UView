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
            // 所绘制不会提交到画布上
            new PorterDuffXfermode(PorterDuff.Mode.CLEAR),
            // 显示上层绘制的图像
            new PorterDuffXfermode(PorterDuff.Mode.SRC),
            // 显示下层绘制图像
            new PorterDuffXfermode(PorterDuff.Mode.DST),
            // 正常绘制显示,上下层绘制叠盖
            new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER),
            // 上下层都显示,下层居中显示
            new PorterDuffXfermode(PorterDuff.Mode.DST_OVER),
            // 取两层绘制交集,显示上层
            new PorterDuffXfermode(PorterDuff.Mode.SRC_IN),
            // 取两层绘制交集,显示下层
            new PorterDuffXfermode(PorterDuff.Mode.DST_IN),
            // 取上层绘制非交集部分,交集部分变成透明
            new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT),
            // 取下层绘制非交集部分,交集部分变成透明
            new PorterDuffXfermode(PorterDuff.Mode.DST_OUT),
            // 取上层交集部分 和 下层非交集部分
            new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP),
            // 取下层交集部分 和 上层非交集部分
            new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP),
            // 去除两图层交集部分, 显示两图层非交集部分
            new PorterDuffXfermode(PorterDuff.Mode.XOR),
            // 取两图层全部区域, 交集部分颜色加深
            new PorterDuffXfermode(PorterDuff.Mode.DARKEN),
            // 取两图层全部区域, 交集部分颜色点亮
            new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN),
            // 取两图层交集部分, 颜色叠加
            new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY),
            // 取两图层全部区域, 交集部分滤色
            new PorterDuffXfermode(PorterDuff.Mode.SCREEN),
            // 取两图层全部区域, 交集部分饱和度相加
            new PorterDuffXfermode(PorterDuff.Mode.ADD),
            // 取两图层全部区域, 交集部分叠加(上层直接压在下层)
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
//        setBackgroundColor(Color.TRANSPARENT);

        // 离屏绘制
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), mPaint, Canvas.ALL_SAVE_FLAG);

        // 绘制
        Bitmap srcBitmap = createCircleBitmap(mWidth, mHeight);
        canvas.drawBitmap(srcBitmap, 0, 0, mPaint);

        // 设置 图层混合模式
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.OVERLAY));

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
