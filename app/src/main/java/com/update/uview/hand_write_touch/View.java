package com.update.uview.hand_write_touch;

import com.update.uview.hand_write_touch.listener.OnClickListener;
import com.update.uview.hand_write_touch.listener.OnTouchListener;

/**
 * @author : liupu
 * date   : 2019/11/14
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class View {
    protected String name;

    private int left;
    private int top;
    private int right;
    private int bottom;

    private OnClickListener onClickListener;
    private OnTouchListener onTouchListener;

    public View() {
    }

    public View(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.onTouchListener = onTouchListener;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "" + name;
    }
}
