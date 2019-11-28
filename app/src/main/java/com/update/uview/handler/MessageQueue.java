package com.update.uview.handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author : liupu
 * date   : 2019/11/28
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class MessageQueue {
    
    BlockingQueue<Message> blockingQueue;

    public MessageQueue() {
        blockingQueue = new ArrayBlockingQueue<>(50);
    }

    public void enqueueMessage(Message message) {
        try {
            blockingQueue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Message next() {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
