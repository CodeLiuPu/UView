package com.update.uview.study.canvas.split;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.update.uview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liupu
 * date   : 2019/11/7
 * desc   : Canvas 粒子扩散效果
 * github : https://github.com/CodeLiuPu/
 */
public class CanvasSplitView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private float d = 4; // 粒子直径
    private ValueAnimator mValueAnimator;
    private List<SplitBall> mBalls;

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
        mBalls = new ArrayList<>();

        // 初始化 所有的粒子
        for (int i = 0; i < mBitmap.getWidth(); i++) {
            for (int j = 0; j < mBitmap.getHeight(); j++) {
                SplitBall ball = new SplitBall();
                ball.color = mBitmap.getPixel(i, j);
                ball.x = i * d + d / 2;
                ball.y = j * d + d / 2;
                ball.r = d / 2;

                // 速度
                ball.vX = SpeedHelper.getSpeedX();
                ball.vY = SpeedHelper.getSpeedY();
                //加速度
                ball.aX = 0;
                ball.aY = 0.98f;

                mBalls.add(ball);
            }
        }

        // 初始化属性动画
        mValueAnimator = ValueAnimator.ofFloat(0, 1);
        mValueAnimator.setRepeatCount(-1);
        mValueAnimator.setDuration(1000 * 2);
        mValueAnimator.setInterpolator(new LinearInterpolator());
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                updateBall();
                invalidate();
            }
        });
    }

    private void updateBall() {
        //更新粒子的位置
        for (SplitBall ball : mBalls) {
            ball.x += ball.vX;
            ball.y += ball.vY;

            ball.vX += ball.aX;
            ball.vY += ball.aY;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(500, 500);
        for (SplitBall ball : mBalls) {
            mPaint.setColor(ball.color);
            canvas.drawCircle(ball.x, ball.y, ball.r, mPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (MotionEvent.ACTION_DOWN == event.getAction()) {
            mValueAnimator.start();
        }
        return super.onTouchEvent(event);
    }

}
