package com.update.uview.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.util.concurrent.Executors;

/**
 * @author : liupu
 * date    : 2019/12/31
 * github : https://github.com/CodeLiuPu/
 * desc    : 自定义TextView 性能更好
 */
public class StaticTextView extends View {

    private String mText = "我是StaticLayout显示出来的文本";
    private TextPaint mTextPaint;
    private StaticLayout mStaticLayout;

    public StaticTextView(Context context) {
        this(context, null);
    }

    public StaticTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint({"Recycle", "CustomViewStyleable"})
    public StaticTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLabelView();
    }

    private void initLabelView() {
        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(16 * getResources().getDisplayMetrics().densityDpi);
        mTextPaint.setColor(Color.BLACK);
        int width = (int) mTextPaint.measureText(mText);

        // 在主线程创建 会耗时
//        mStaticLayout = new StaticLayout(mText,mTextPaint,width);
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                // 放置在子线程创建
//        mStaticLayout = new StaticLayout(mText,mTextPaint,width);
                // 需要调用 postInvalidate 通知界面重绘
                postInvalidate();
            }
        });
    }
}
