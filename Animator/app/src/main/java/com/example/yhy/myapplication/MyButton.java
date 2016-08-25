package com.example.yhy.myapplication;

/**
 * Created by yhy on 2016/8/9.
 */
public class MyButton {
    private MyOnclickListener listener;

    public void setOnclickListener(MyOnclickListener listener){
        this.listener=listener;
    }
    public void doClick(){
        listener.onClick();
    }
}
