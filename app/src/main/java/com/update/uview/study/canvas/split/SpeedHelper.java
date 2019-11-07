package com.update.uview.study.canvas.split;

/**
 * @author : liupu
 * date   : 2019/11/7
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class SpeedHelper {


    public static float getSpeedX() {

        return (float) (Math.pow(-1, Math.ceil(Math.random() * 1000)) * 20 * Math.random());
    }

    public static int getSpeedY() {
        int i = -15;
        int j = 35;
        int max = Math.max(i, j);
        int min = Math.min(i, j) - 1;
        //在0到(max - min)范围内变化，取大于x的最小整数 再随机
        return (int) (min + Math.ceil(Math.random() * (max - min)));
    }
}
