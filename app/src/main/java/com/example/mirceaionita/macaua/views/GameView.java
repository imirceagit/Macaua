package com.example.mirceaionita.macaua.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import com.example.mirceaionita.macaua.entity.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mircea.ionita on 10/17/2016.
 */

public class GameView extends View {

    private Context currentContext;
    private List<Card> deck = new ArrayList<Card>();
    private int scaledCardW;
    private int scaledCardH;

    private int screenW;
    private int screenH;

    public GameView(Context context) {
        super(context);
        currentContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas){

    }

    @Override
    public void onSizeChanged (int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        screenW = w;
        screenH = h;
    }

    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        int X = (int)event.getX();
        int Y = (int)event.getY();

        switch (eventaction ) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }

    private void initCards() {
        for (int i = 0; i < 4; i++) {
            for (int j = 102; j < 115; j++) {
                int tempId = j + (i*100);
                Card tempCard = new Card(tempId);
                int resourceId = getResources().getIdentifier("card" + tempId, "drawable", currentContext.getPackageName());
                Bitmap tempBitmap = BitmapFactory.
                        decodeResource(currentContext.getResources(),
                                resourceId);
                scaledCardW = (int) (screenW/8);
                scaledCardH = (int) (scaledCardW*1.28);
                Bitmap scaledBitmap = Bitmap.
                        createScaledBitmap(tempBitmap,
                                scaledCardW, scaledCardH, false);
                tempCard.setBitmap(scaledBitmap);
                deck.add(tempCard);
            }
        }
    }
}
