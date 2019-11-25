package com.update.uview.layout.rv;


import android.view.View;

import java.util.Stack;

/**
 * @author : liupu
 * date   : 2019/11/25
 * desc   : 回收池
 * github : https://github.com/CodeLiuPu/
 */
public class Recycler {
    private Stack<View>[] mViews;

    public Recycler(int typeNumber) {
        mViews = new Stack[typeNumber];
        for (int i = 0; i < typeNumber; i++) {
            mViews[i] = new Stack<>();
        }
    }

    public void put(int type, View view) {
        mViews[type].push(view);
    }

    public View get(int type) {
        try {
            return mViews[type].pop();
        } catch (Exception e) {
            return null;
        }
    }

}
