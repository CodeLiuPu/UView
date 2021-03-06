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

    // 事件分发入口
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int actionMasked = event.getActionMasked();
        boolean intercepted = onInterceptTouchEvent(event);
        boolean handled = false;
        TouchTarget newTouchTarget;
        if (actionMasked != MotionEvent.ACTION_CANCEL && !intercepted) {
            if (actionMasked == MotionEvent.ACTION_DOWN) {
                final View[] childrens = mChildrens;
                // 遍历 倒序
                for (int i = mChildrens.length - 1; i >= 0; i--) {
                    View child = mChildrens[i];
                    // 如果View不能接收事件
                    if (!child.isContainer(event.getX(), event.getY())) {
                        continue;
                    }

                    // 能够接收事件 则将事件分发给 child
                    if (dispatchTransformedTouchEvent(event, child)) {
                        handled = true;
                        newTouchTarget = addTouchTarget(child);
                        break;
                    }
                }
            }
        }

        if (mFirstTouchTarget == null) {
            handled = dispatchTransformedTouchEvent(event, null);
        }
        return handled;
    }

    // 分发处理
    private boolean dispatchTransformedTouchEvent(MotionEvent event, View child) {
        boolean handled = false;
        if (child != null) {
            handled = child.dispatchTouchEvent(event);
        } else {
            super.dispatchTouchEvent(event);
        }
        return handled;
    }

    // 拦截事件
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }

    private TouchTarget addTouchTarget(View child) {
        final TouchTarget target = TouchTarget.obtain(child);
        target.next = mFirstTouchTarget;
        mFirstTouchTarget = target;
        return target;
    }

    private static final class TouchTarget {
        // 当前缓存的View
        private View child;
        // 回收池
        private static TouchTarget sRecycleBin;
        // size
        private static int sRecycleCount;
        private static final Object sRecycleLock = new Object[0];
        public TouchTarget next;

        private TouchTarget() {
        }

        public static TouchTarget obtain(View child) {
            TouchTarget target;
            synchronized (sRecycleLock) {
                if (sRecycleBin == null) {
                    target = new TouchTarget();
                } else {
                    target = sRecycleBin;
                }
                sRecycleBin = target.next;
                sRecycleCount++;
                target.next = null;
            }
            target.child = child;
            return target;
        }

        public void recycle() {
            if (child == null) {
                throw new IllegalStateException("已经被回收过了");
            }
            synchronized (sRecycleLock) {
                if (sRecycleCount < 32) {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycleCount++;
                }
            }
        }
    }
}
