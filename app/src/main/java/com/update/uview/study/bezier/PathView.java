package com.update.uview.study.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author : liupu
 * date   : 2019/11/8
 * desc   : Path 学习类
 * github : https://github.com/CodeLiuPu/
 */
public class PathView extends View {

    private Paint mPaint;
    private Path mPath;

    public PathView(Context context) {
        this(context, null);
    }

    public PathView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPath.moveTo(100,70);
//        mPath.lineTo(500, 800);//连线

        // ------------------ 添加图形 --------------------

        // 添加弧形
//        mPath.addArc(100,100,200,200,0,200);

        // 添加 矩形
//        mPath.addRect(500, 500, 900, 900, Path.Direction.CCW);

//        mPath.addCircle(0, 0, 10, Path.Direction.CW);


        // ------------------ 追加图形 ---------------------
        // xxxTo画线
//        mPath.arcTo(400, 200, 600, 400, -180, 225, false);

        // 添加一个路径
//        mPath.moveTo(100, 70);
//        mPath.lineTo(140, 180);
//        mPath.lineTo(250, 330);
//        mPath.lineTo(400, 630);
//        mPath.lineTo(100, 830);
//
//        Path newPath = new Path();
//        newPath.moveTo(100, 1000);
//        newPath.lineTo(600, 1300);
//        newPath.lineTo(400, 1700);
//        mPath.addPath(newPath);

        //画二阶贝塞尔曲线
//        mPath.moveTo(300, 500);
//        mPath.quadTo(500, 100, 800, 500);
        //参数表示相对位置，等同于上面一行代码
//        mPath.rQuadTo(200, -400, 500, 0);

        //画三阶贝塞尔曲线
        mPath.moveTo(300, 500);
//        mPath.cubicTo(500, 100, 600, 1200, 800, 500);
        //参数表示相对位置，等同于上面一行代码
        mPath.rCubicTo(200, -400, 300, 700, 500, 0);

        canvas.drawPath(mPath, mPaint);
    }
}
