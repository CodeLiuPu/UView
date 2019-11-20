package com.update.uview.hand_write_touch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liupu
 * date   : 2019/11/14
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class ViewGroup extends View {
    private List<View> childList;
    private View[] mChildrens;
    private TouchTarget mFirstTouchTarget;

    public ViewGroup() {
    }

    public ViewGroup(int left, int top, int right, int bottom) {
        super(left, top, right, bottom);
        childList = new ArrayList<>();
        mChildrens = new View[0];
    }

    public void addView(View view) {
        if (view == null) {
            return;
        }
        childList.add(view);
        mChildrens = childList.toArray(new View[childList.size()]);
    }

    private static final class TouchTarget {
    }
}
