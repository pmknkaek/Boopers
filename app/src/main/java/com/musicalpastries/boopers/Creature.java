package com.musicalpastries.boopers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.provider.Settings;

/**
 * Created by loads on 9/9/2017.
 */

public class Creature extends GameObject {
    private Bitmap spriteSheet;
    private int score;
    private boolean playing;
    private boolean up;
    private Animation animation = new Animation();
    private long startTime;

    public Creature(Bitmap res, int w, int h, int numFrames){
        x=10;
        y=10;
        dy = 0;
        score = 0;
        height = h;
        width = w;

        Bitmap[] image = new Bitmap[numFrames];
        spriteSheet = res;

        for (int i = 0; i < image.length; i++) {
            image[i] = Bitmap.createBitmap(spriteSheet, i*width, 0, width, height);
        }

        animation.setFrames(image);
        animation.setDelay(1000);
        startTime = System.nanoTime();
    }

    public void setUp(boolean b){up = b;}

    public void update(){
        long elapsed = (System.nanoTime()-startTime)/1000000;
        if(elapsed>100){
            score++;
            startTime = System.nanoTime();
        }
        animation.update();
       if (up){
            dy -= 2;
        }
        else {
            dy += 2;
        }

        if (dy>14)dy=14;
        if (dy<-14)dy=-14;

        y+= dy*2;
        dy = 0;
        if(y<0){
            y=0;
        }
        if (y>GamePanel.HEIGHT-300){
            y=GamePanel.HEIGHT-300;
        }
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(animation.getImage(), x, y, null);
    }
    public int getScore(){return score;}
    public boolean getPlaying(){return playing;}
    public void setPlaying(boolean b){playing = b;}
    public void resetScore(){score = 0;}
}
