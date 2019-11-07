package com.update.uview.study.canvas;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;


/**
 * @author : liupu
 * date   : 2019/11/7
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class CanvasSplashView extends View {

    // 旋转圆的画笔
    private Paint mPaint;
    // 扩散圆的画笔
    private Paint mHolePaint;


    // 背景色
    private int mBackgroundColor = Color.WHITE;
    private int[] mCircleColors;

    // 旋转圆的 中心坐标
    private float mCenterX;
    private float mCenterY;
    // 斜对角线长度的一半, 扩散圆最大半径
    private float mDistance;

    // 6个小球的半径
    private float mCircleRadius = 18;
    // 旋转大圆的半径
    private float mRetateCircleRadius = 90;

    // 当前大圆的旋转角度
    private float mCurrentRotateAngle = 0f;
    // 当前大圆的半径
    private float mCurrentRotateRadius = mRetateCircleRadius;
    // 扩散圆的半径
    private float mCurrentHoleRadius = 0f;
    // 旋转动画的时长
    private int mRotateDuration = 1200;

    public CanvasSplashView(Context context) {
        this(context, null);
    }

    public CanvasSplashView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasSplashView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mHolePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHolePaint.setStyle(Paint.Style.STROKE);
        mHolePaint.setColor(mBackgroundColor);

        mCircleColors = new int[]{
                Color.parseColor("#FF9600"),
                Color.parseColor("#02D1AC"),
                Color.parseColor("#FFD200"),
                Color.parseColor("#00C6FF"),
                Color.parseColor("#00E099"),
                Color.parseColor("#FF3892")};
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mState == null) {
            mState = new RotateState();
        }
        mState.drawState(canvas);
    }

    private SplashState mState;

    private abstract class SplashState {
        abstract void drawState(Canvas canvas);
    }

    // 1. 旋转
    private class RotateState extends SplashState {

        private RotateState() {
            // 属性动画
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, (float) (Math.PI * 2));
            valueAnimator.setRepeatCount(2);
            valueAnimator.setDuration(mRotateDuration);
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCurrentRotateAngle =(float) animation.getAnimatedValue();
                    invalidate();
                }
            });
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
//                    mState = new
                }
            });
            valueAnimator.start();
        }

        @Override
        void drawState(Canvas canvas) {

        }
    }

    // 2. 扩散聚合
    private class MerginState extends SplashState {

        @Override
        void drawState(Canvas canvas) {

        }
    }

    // 3. 水波纹
    private class ExpandState extends SplashState {

        @Override
        void drawState(Canvas canvas) {

        }
    }
    private void drawBackground(Canvas canvas){

    }
}