package com.update.uview.study.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author : liupu
 * date   : 2019/11/4
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class ColorFilterView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private ColorMatrixColorFilter mColorMatrixColorFilter;

    public ColorFilterView(Context context) {
        this(context, null);
    }

    public ColorFilterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }
}
