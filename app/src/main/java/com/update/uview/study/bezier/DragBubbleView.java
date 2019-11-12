package com.update.uview.study.bezier;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.update.uview.R;

/**
 * @author : liupu
 * date   : 2019/11/8
 * desc   : 贝塞尔曲线 学习类 (QQ气泡效果)
 * github : https://github.com/CodeLiuPu/
 */
public class DragBubbleView extends View {

    /**
     * 气泡默认状态--静止
     */
    private final int BUBBLE_STATE_DEFAULT = 0;
    /**
     * 气泡相连
     */
    private final int BUBBLE_STATE_CONNECT = 1;
    /**
     * 气泡分离
     */
    private final int BUBBLE_STATE_APART = 2;
    /**
     * 气泡消失
     */
    private final int BUBBLE_STATE_DISMISS = 3;

    /**
     * 气泡半径
     */
    private float mBubbleRadius;
    /**
     * 气泡颜色
     */
    private int mBubbleColor;
    /**
     * 气泡消息文字
     */
    private String mTextStr;
    /**
     * 气泡消息文字颜色
     */
    private int mTextColor;
    /**
     * 气泡消息文字大小
     */
    private float mTextSize;
    /**
     * 不动气泡的半径
     */
    private float mBubFixedRadius;
    /**
     * 可动气泡的半径
     */
    private float mBubMovableRadius;
    /**
     * 不动气泡的圆心
     */
    private PointF mBubFixedCenter;
    /**
     * 可动气泡的圆心
     */
    private PointF mBubMovableCenter;
    /**
     * 气泡的画笔
     */
    private Paint mBubblePaint;
    /**
     * 贝塞尔曲线path
     */
    private Path mBezierPath;

    private Paint mTextPaint;

    //文本绘制区域
    private Rect mTextRect;

    private Paint mBurstPaint;

    //爆炸绘制区域
    private Rect mBurstRect;

    /**
     * 气泡状态标志
     */
    private int mBubbleState = BUBBLE_STATE_DEFAULT;
    /**
     * 两气泡圆心距离
     */
    private float mDist;
    /**
     * 气泡相连状态最大圆心距离
     */
    private float mMaxDist;
    /**
     * 手指触摸偏移量
     */
    private final float MOVE_OFFSET;

    /**
     * 气泡爆炸的bitmap数组
     */
    private Bitmap[] mBurstBitmapsArray;
    /**
     * 是否在执行气泡爆炸动画
     */
    private boolean mIsBurstAnimStart = false;

    /**
     * 当前气泡爆炸图片index
     */
    private int mCurDrawableIndex;

    /**
     * 气泡爆炸的图片id数组
     */
    private int[] mBurstDrawablesArray = {
            R.mipmap.dragbubble_burst_1,
            R.mipmap.dragbubble_burst_2,
            R.mipmap.dragbubble_burst_3,
            R.mipmap.dragbubble_burst_4,
            R.mipmap.dragbubble_burst_5
    };

    public DragBubbleView(Context context) {
        this(context, null);
    }

    public DragBubbleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragBubbleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.DragBubbleView, defStyleAttr, 0);
        mBubbleRadius = array.getDimension(R.styleable.DragBubbleView_bubble_radius, 8);
        mBubbleColor = array.getColor(R.styleable.DragBubbleView_bubble_color, Color.RED);
        mTextStr = array.getString(R.styleable.DragBubbleView_bubble_text);
        mTextSize = array.getDimension(R.styleable.DragBubbleView_bubble_textSize, 8);
        mTextColor = array.getColor(R.styleable.DragBubbleView_bubble_textColor, Color.WHITE);
        array.recycle();

        // 两个圆半径大小一致
        mBubFixedRadius = mBubbleRadius;
        mBubMovableRadius = mBubFixedRadius;
        mMaxDist = mBubbleRadius * 8;

        MOVE_OFFSET = mMaxDist / 4;

        // 抗锯齿
        mBubblePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBubblePaint.setColor(mBubbleColor);
        mBubblePaint.setStyle(Paint.Style.FILL);
        mBezierPath = new Path();

        // 文本画笔
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
        mTextRect = new Rect();

        // 爆炸画笔
        mBurstPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBubblePaint.setFilterBitmap(true);
        mBurstRect = new Rect();
        mBurstBitmapsArray = new Bitmap[mBurstDrawablesArray.length];
        for (int i = 0; i < mBurstDrawablesArray.length; i++) {
            // 将气泡爆炸的 drawable 转换为 bitmap
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), mBurstDrawablesArray[i]);
            mBurstBitmapsArray[i] = bitmap;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        initWH(w, h);
    }

    private void initWH(int w, int h) {
        mBubbleState = BUBBLE_STATE_DEFAULT;

        //设置固定气泡圆心初始坐标
        if (mBubFixedCenter == null) {
            mBubFixedCenter = new PointF(w / 2, h / 2);
        } else {
            mBubFixedCenter.set(w / 2, h / 2);
        }
        //设置可动气泡圆心初始坐标
        if (mBubMovableCenter == null) {
            mBubMovableCenter = new PointF(w / 2, h / 2);
        } else {
            mBubMovableCenter.set(w / 2, h / 2);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mBubbleState == BUBBLE_STATE_CONNECT) {
            // 控制不动气泡
            canvas.drawCircle(mBubFixedCenter.x, mBubFixedCenter.y, mBubFixedRadius, mBubblePaint);
            // 绘制贝塞尔曲线
        }

        // 静止, 连接, 分离状态都需要绘制 圆背景以及文本
        if (mBubbleState != BUBBLE_STATE_DISMISS) {
            canvas.drawCircle(mBubMovableCenter.x, mBubMovableCenter.y, mBubMovableRadius, mBubblePaint);
            mTextPaint.getTextBounds(mTextStr, 0, mTextStr.length(), mTextRect);
            canvas.drawText(mTextStr, mBubMovableCenter.x - mTextRect.width() / 2, mBubMovableCenter.y + mTextRect.height() / 2, mTextPaint);
        }


        // 1. 静止状态, 一个气泡+消息数据

        // 2. 连线状态, 一个气泡+消息数据 贝塞尔曲线, 原本位置上的小球

        // 3. 分离状态, 一个气泡+消息数据

        // 4, 消失状态, 消失的气泡

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (mBubbleState != BUBBLE_STATE_DISMISS) {
                    mDist = (float) Math.hypot(event.getX() - mBubFixedCenter.x, event.getY() - mBubFixedCenter.y);
                    // 加上 MOVE_OFFSET 为了方便拖拽
                    if (mDist < mBubbleRadius + MOVE_OFFSET) {
                        mBubbleState = BUBBLE_STATE_CONNECT;
                    } else {
                        mBubbleState = BUBBLE_STATE_DEFAULT;
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mBubbleState != BUBBLE_STATE_DEFAULT) {
                    mDist = (float) Math.hypot(event.getX() - mBubFixedCenter.x, event.getY() - mBubFixedCenter.y);
                    mBubMovableCenter.x = event.getX();
                    mBubMovableCenter.y = event.getY();
                    if (mBubbleState == BUBBLE_STATE_CONNECT) {
                        if (mDist < mMaxDist - MOVE_OFFSET){
                            mBubFixedRadius   = mBubbleRadius - mDist /8;
                        } else {
                            mBubbleState = BUBBLE_STATE_APART;
                        }
                    }
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
        }
        return true;
    }
}