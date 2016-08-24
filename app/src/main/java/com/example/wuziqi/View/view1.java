package com.example.wuziqi.View;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/**
 * Created by 蔡大爷 on 2016/8/22.
 */
public class view1 extends View {

    float startX;
    float startY;

    Scroller mScroller;

    public view1(Context context) {
        super(context);
        init();
    }

    public view1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public view1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {

        mScroller = new Scroller(getContext());
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:

                        startX = event.getX();
                        startY = event.getY();
                        Log.e("LogUtils", "down");
                        break;

                    case MotionEvent.ACTION_MOVE:

                        int dx = (int) (event.getX() - startX);
                        int dy = (int) (event.getY() - startY);

//                        layout((int) (getLeft() + dx), (int) (getTop() + dy), (int) (getRight() + dx), (int) (getBottom() + dy));

//                        offsetLeftAndRight(dx);
//                        offsetTopAndBottom(dy);

//                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
//                        layoutParams.leftMargin = getLeft() + dx;
//                        layoutParams.topMargin = getTop() + dy;
//                        setLayoutParams(layoutParams);

                        ((View)getParent()).scrollBy(-dx,-dy);

//                        ((View) getParent()).scrollTo(-getLeft()-dx , -getTop()-dy );
//                        Log.e("LogUtils", "dx : " + dx + " dy :" + dy + " getLetf() " + getLeft());

                        break;

                    case MotionEvent.ACTION_UP:

                        Log.e("LogUtils", "up");
                        View viewGroup = (View) getParent();
                        mScroller.startScroll(viewGroup.getScrollX(), viewGroup.getScrollY(), -viewGroup.getScrollX(), -viewGroup.getScrollY(),1000);

                        invalidate();

                        break;

                }

                return true;
            }
        });
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {

            ((View) getParent()).scrollTo(
                    mScroller.getCurrX(),
                    mScroller.getCurrY());
            invalidate();
        }
    }
}
