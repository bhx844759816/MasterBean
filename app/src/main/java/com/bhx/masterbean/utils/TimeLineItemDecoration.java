package com.bhx.masterbean.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;

import com.bhx.masterbean.R;

public class TimeLineItemDecoration extends RecyclerView.ItemDecoration {

    private int mCircleSize = 14;//圆圈的半径
    private Paint mPaint;//画笔
    private Paint mLinePaint;
    private int mPaintSize = 3;//画笔宽度
    private String mPaintColor = "#013453";//画笔默认颜色
    private String mLinePaintColor = "#707070";//画笔默认颜色

    public TimeLineItemDecoration() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor(mPaintColor));
        mLinePaint = new Paint();
        mLinePaint.setStrokeWidth(mPaintSize);
        mLinePaint.setColor(Color.parseColor(mLinePaintColor));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        Rect rect = new Rect(120, 0, 0, 0);//使item从outRect中右移200px
        outRect.set(rect);
    }

    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(canvas, parent, state);

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            int left = child.getLeft();
            int top = child.getTop();
            int bottom = child.getBottom();
            int right = child.getRight();
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int bottomMargin = params.bottomMargin;//防止在item根布局中设置marginTop和marginBottom
            int topMargin = params.topMargin;

            int leftX = left *2 / 3;//轴线的x轴坐标
            int height = child.getHeight();//item的高度，不包含Margin

            if (childCount == 1) {
                canvas.drawLine(leftX, top, leftX, bottom - height * 1.0f / 2, mPaint);
            } else {
                if (i == 0) {
                    canvas.drawLine(leftX, top + child.getPaddingTop() + 30, leftX, bottom + bottomMargin, mLinePaint);
                } else if (i == childCount - 1) {
                    canvas.drawLine(leftX, top - topMargin, leftX, top + child.getPaddingTop() + 30, mLinePaint);
                } else {
                    canvas.drawLine(leftX, top - topMargin, leftX, top + child.getPaddingTop() + 30, mLinePaint);
                    canvas.drawLine(leftX, top + child.getPaddingTop() - 3, leftX, bottom + bottomMargin, mLinePaint);
                }
            }
            canvas.drawCircle(leftX, top + child.getPaddingTop() + 30, mCircleSize, mPaint);
        }
    }
}
