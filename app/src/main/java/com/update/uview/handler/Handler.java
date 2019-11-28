package com.update.uview.handler;

/**
 * @author : liupu
 * date   : 2019/11/28
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class Handler {
    private Looper mLooper;
    private MessageQueue mQueue;

    public Handler(){
        this(Looper.myLooper());
    }

    public Handler(Looper looper){
        mLooper = looper;
        if (mLooper == null) {
            throw new RuntimeException(
                    "Can't create handler inside thread " + Thread.currentThread()
                            + " that has not called Looper.prepare()");
        }
        mQueue = mLooper.mQueue;
    }

    public void sendMessage(Message msg){
        enqueueMessage(msg);
    }

    public void enqueueMessage(Message msg){
        mQueue.enqueueMessage(msg);
    }


    public void dispatchMessage(Message msg){
        handleMessage(msg);
    }

    public void handleMessage(Message msg){

    }


}
