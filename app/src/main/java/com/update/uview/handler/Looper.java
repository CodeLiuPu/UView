package com.update.uview.handler;

/**
 * @author : liupu
 * date   : 2019/11/28
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class Looper {
    private static final ThreadLocal<Looper> mThreadLocal = new ThreadLocal<>();
    final MessageQueue mQueue;

    private Looper() {
        mQueue = new MessageQueue();
    }

    public static void prepare() {
        if (mThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        mThreadLocal.set(new Looper());
    }

    public static Looper myLooper() {
        return mThreadLocal.get();
    }

    public static void loop() {
        MessageQueue messageQueue = myLooper().mQueue;
        for (; ; ) {
            Message message = messageQueue.next();
            if (message != null) {
                message.target.dispatchMessage(message);
            }
        }
    }
}
