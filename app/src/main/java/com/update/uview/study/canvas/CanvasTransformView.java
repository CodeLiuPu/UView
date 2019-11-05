package com.update.uview.study.canvas;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author : liupu
 * date   : 2019/11/5
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class CanvasTransformView extends View {

    private Paint mPaint;

    public CanvasTransformView(Context context) {
        this(context, null);
    }

    public CanvasTransformView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasTransformView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }
}
