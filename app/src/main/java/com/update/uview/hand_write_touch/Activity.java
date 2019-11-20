package com.update.uview.hand_write_touch;

import com.update.uview.hand_write_touch.listener.OnClickListener;
import com.update.uview.hand_write_touch.listener.OnTouchListener;

/**
 * @author : liupu
 * date   : 2019/11/13
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class Activity {
    ViewGroup decorView;

    public Activity() {
        decorView = new ViewGroup(0, 0, 1080, 1920);
        decorView.setName("顶层容器");
        decorView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("顶级容器的 onClick 事件");
            }
        });

        decorView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                System.out.println("顶级容器的 onTouch 事件");
                return false;
            }
        });
    }

    public void setContentView(View view) {
        decorView.addView(view);
    }

    public void dispatchTouchEvent() {
        MotionEvent motionEvent = new MotionEvent(100, 100);
        motionEvent.setActionMasked(MotionEvent.ACTION_DOWN);
        //顶层容器传递事件
        decorView.dispatchTouchEvent(motionEvent);
    }

    public static void main(String[] args) {

        ViewGroup viewGroup = new ViewGroup(0, 0, 600, 600);
        viewGroup.setName("第二级容器");
        View view = new View(0, 0, 300, 300);
        view.setName("自控件");
        viewGroup.addView(view);
        viewGroup.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                System.out.println("第二级的 OnTouch 事件");
                return false;
            }
        });
        viewGroup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("第二级的 onClick 事件");

            }
        });
        view.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                System.out.println("View的 OnTouch 事件");
                return false;
            }
        });
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("View的 onClick 事件");
            }
        });

        Activity activity = new Activity();
        activity.setContentView(viewGroup);
        activity.dispatchTouchEvent();
    }
}
