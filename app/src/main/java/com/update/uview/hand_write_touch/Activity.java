package com.update.uview.hand_write_touch;

/**
 * @author : liupu
 * date   : 2019/11/13
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class Activity {
    ViewGroup decorView;

    public Activity(){
        decorView = new ViewGroup(0, 0, 1080, 1920);
        decorView.setName("顶层容器");
    }

    private void setContentView() {

    }


    public static void main(String[] args) {

        System.out.println("Hello");
    }
}
