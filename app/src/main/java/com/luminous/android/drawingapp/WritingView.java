package com.luminous.android.drawingapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WritingView extends View {
    Paint paint;
    int x1, y1, x2, y2;
    MyPoint lastPoint;

    ArrayList<Line> lines = new ArrayList<>();

    public WritingView(Context context) {
        super(context);
        init();
    }

    public WritingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Line l: lines) {
            canvas.drawLine(l.start.x, l.start.y, l.end.x, l.end.y, paint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            x1 = (int) event.getX();
            y1 = (int) event.getY();

            lastPoint = new MyPoint(x1, y1);
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            x2 = (int) event.getX();
            y2 = (int) event.getY();

            MyPoint newPoint = new MyPoint(x2, y2);
            lines.add(new Line(lastPoint, newPoint));

            lastPoint = newPoint;
            invalidate();
        } else {

        }

        return super.onTouchEvent(event);
    }
}
