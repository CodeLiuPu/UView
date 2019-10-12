package com.update.uview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.update.uview.R;


/**
 * @author : liupu
 * date   : 2019/4/26
 * desc   :
 */
public class InfoChooseLayout extends LinearLayout {
    View view;
    TypedArray typedArray;
    TextView tv_title;
    TextView tv_content;
    ImageView iv_right;
    LinearLayout ll_error_container;
    TextView tv_error;

    String title;
    String content;
    String error;
    public InfoChooseLayout(Context context) {
        this(context, null);
    }

    public InfoChooseLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InfoChooseLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initAppTypedArray(context,attrs);
    }

    private void initView(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.view_info_choose, this, true);
        tv_title = findViewById(R.id.tv_title);
        tv_content = findViewById(R.id.tv_content);
        iv_right = findViewById(R.id.iv_right);
        ll_error_container = findViewById(R.id.ll_error_container);
        tv_error = findViewById(R.id.tv_error);

    }

    private void initAppTypedArray(Context context, AttributeSet attrs) {
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.info_choose);
        title = typedArray.getString(R.styleable.info_choose_icv_title);
        content = typedArray.getString(R.styleable.info_choose_icv_content);
        error = typedArray.getString(R.styleable.info_choose_icv_error_message);
        tv_title.setText(title);
        tv_content.setText(content);
        tv_error.setText(error);
    }

}
