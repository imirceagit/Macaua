package com.example.mirceaionita.macaua.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import com.example.mirceaionita.macaua.*;

/**
 * Created by mircea.ionita on 10/17/2016.
 */

public class TitleView extends View {

    private Context currentContext;

    private int screenW;
    private int screenH;

    private Bitmap playButtonUp;
    private Bitmap playButtonDown;
    private boolean playButtonPressed = false;

    public TitleView(Context context) {
        super(context);
        currentContext = context;
        playButtonUp = BitmapFactory.decodeResource(getResources(), R.drawable.play_button);
        playButtonDown = BitmapFactory.decodeResource(getResources(), R.drawable.play_button_pressed);
    }

    @Override
    public void onSizeChanged (int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        screenW = w;
        screenH = h;
    }

    @Override
    protected void onDraw(Canvas canvas){
        if(playButtonPressed){
            canvas.drawBitmap(playButtonDown, (screenW - playButtonDown.getWidth()) / 2, (int)(screenH * 0.7), null);
        }else {
            canvas.drawBitmap(playButtonUp, (screenW - playButtonUp.getWidth()) / 2, (int)(screenH * 0.7), null);
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        int X = (int)event.getX();
        int Y = (int)event.getY();

        switch (eventaction ) {
            case MotionEvent.ACTION_DOWN:
                if (X > (screenW - playButtonUp.getWidth())/2 && X < ((screenW - playButtonUp.getWidth())/2 + playButtonUp.getWidth())
                        && Y > (int)(screenH * 0.7) && Y < (int)(screenH * 0.7) + playButtonUp.getHeight()) {
                    playButtonPressed = true;
                }
            break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                playButtonPressed = false;
                break;
        }
        invalidate();
        return true;
    }
}
