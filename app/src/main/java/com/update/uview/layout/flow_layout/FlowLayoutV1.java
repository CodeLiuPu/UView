package com.update.uview.layout.flow_layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liupu
 * date   : 2019/10/12
 * desc   : 流布局V1
 * github : https://github.com/CodeLiuPu/
 */
public class FlowLayoutV1 extends ViewGroup {

    // 保存 每行View 的列表
    protected List<List<View>> mAllViews = new ArrayList<>();
    // 保存行高列表
    protected List<Integer> mLineHeights = new ArrayList<>();

    public FlowLayoutV1(Context context) {
        this(context, null);
    }

    public FlowLayoutV1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint({"Recycle", "CustomViewStyleable"})
    public FlowLayoutV1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int measureWidth = 0;
        int measureHeight = 0;
        int currentLineW = 0;
        int currentLineH = 0;

        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            measureWidth = widthSize;
            measureHeight = heightSize;
        } else {
            int childW;
            int childH;
            int childCount = getChildCount();
            List<View> viewList = new ArrayList<>();
            for (int i = 0; i < childCount; i++) {
                View childView = getChildAt(i);
                measureChild(childView, widthMeasureSpec, heightMeasureSpec);
                MarginLayoutParams layoutParams = (MarginLayoutParams) childView.getLayoutParams();
                childW = childView.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                childH = childView.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;

                if (currentLineW + childW > widthSize) {
                    // 需要换行记录当前行信息
                    // 记录当前行的最大高度, 高度累加
                    measureWidth = Math.max(measureWidth, currentLineW);
                    measureHeight += currentLineH;
                    mAllViews.add(viewList);
                    mLineHeights.add(currentLineH);

                    // 记录新一行信息
                    currentLineW = childW;
                    currentLineH = childH;
                    viewList = new ArrayList<>();
                    viewList.add(childView);

                } else {
                    // 不需要换行 宽度叠加
                    currentLineW += childW;
                    currentLineH = Math.max(currentLineH, childH);
                    viewList.add(childView);
                }

                // 如果是最后一行 不管View满不满 都需要换行
                if (i == childCount - 1) {
                    // 记录当前行的最大宽度, 高度累加
                    measureWidth = Math.max(measureWidth, currentLineW);
                    measureHeight += currentLineH;

                    // 将当前行的ViewList 添加至总的 Views 中,行高也添加进去
                    mAllViews.add(viewList);
                    mLineHeights.add(currentLineH);
                }
            }
        }
        setMeasuredDimension(measureWidth, measureHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left, top, right, bottom;
        int currentTop = 0;
        int currentLeft = 0;
        int lineCount = mAllViews.size();

        for (int i = 0; i < lineCount; i++) {
            List<View> viewList = mAllViews.get(i);
            int lineViewSize = viewList.size();
            for (int j = 0; j < lineViewSize; j++) {
                View childView = viewList.get(i);
                MarginLayoutParams layoutParams = (MarginLayoutParams) childView.getLayoutParams();

                left = currentLeft + layoutParams.leftMargin;
                top = currentTop + layoutParams.topMargin;
                right = left + childView.getMeasuredWidth() + layoutParams.rightMargin;
                bottom = top + childView.getMeasuredHeight() + layoutParams.bottomMargin;
                childView.layout(left, top, right, bottom);
                currentLeft += layoutParams.leftMargin + childView.getMeasuredWidth() + layoutParams.rightMargin;
            }
            currentLeft = 0;
            currentTop += mLineHeights.get(i);
        }
        mAllViews.clear();
        mLineHeights.clear();
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }
}