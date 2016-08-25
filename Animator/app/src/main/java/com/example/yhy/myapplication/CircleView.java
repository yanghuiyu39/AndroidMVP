package com.example.yhy.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yhy on 2016/8/9.
 */
public class CircleView extends View {
    private int mColor = Color.RED;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(mColor);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setColor(mColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width=300;
        int height=300;
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode==MeasureSpec.AT_MOST&&heightMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(Math.min(width,widthSize),Math.min(height,heightSize));
        }else if(widthMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(Math.min(width,widthSize),heightSize);
        }else if(heightMode==MeasureSpec.AT_MOST){
            setMeasuredDimension((widthSize),Math.min(height,heightSize));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft=getPaddingLeft();
        int paddingRight=getPaddingRight();
        int paddingTop=getPaddingTop();
        int paddingBottom=getPaddingBottom();
        int width=getWidth()-paddingLeft-paddingRight;
        int height=getHeight()-paddingTop-paddingBottom;
        int radius=Math.min(width,height)/2;
        canvas.drawCircle(paddingLeft+width/2,paddingTop+height/2,radius,mPaint);
    }

//    private int getMeasuredLength(int length, boolean isWidth) {
//        int specMode = MeasureSpec.getMode(length);
//        int specSize = MeasureSpec.getSize(length);
//        int size;
//        int padding = isWidth ? getPaddingLeft() + getPaddingRight()
//                : getPaddingTop() + getPaddingBottom();
//        if (specMode == MeasureSpec.EXACTLY) {
//            size = specSize;
//        } else {
//            size = isWidth ? padding + mWave.length / 4 : DEFAULT_HEIGHT
//                    + padding;
//            if (specMode == MeasureSpec.AT_MOST) {
//                size = Math.min(size, specSize);
//            }
//        }
//        return size;
//    }
}
