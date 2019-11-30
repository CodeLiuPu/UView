package com.update.uview.layout_inflate;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.update.uview.R;

/**
 * @author : liupu
 * date   : 2019/10/12
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class AsyncLayoutInflaterActivity extends AppCompatActivity {

    // 2 自定义实现
    // 将回调的 View对象做处理
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            View view = (View) msg.obj;
            setContentView(view);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 2.1 自定义实现
        // 创建子线程来承载View的加载
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 2 自定义实现
                // 在子线程中进行View的加载, 并将加载完成的View对象回调给主线程
                View view = getLayoutInflater().inflate(R.layout.view_drag_bubble, null);
                Message msg = Message.obtain();
                msg.obj = view;
                handler.sendMessage(msg);
            }
        }).start();


        // 1. 使用系统实现
//        new AsyncLayoutInflater(this).inflate(R.layout.view_drag_bubble, null, new AsyncLayoutInflater.OnInflateFinishedListener() {
//            @Override
//            public void onInflateFinished(@NonNull View view, int i, @Nullable ViewGroup viewGroup) {
//                setContentView(view);
//            }
//        });

//        setContentView(R.layout.view_drag_bubble);
    }

}
