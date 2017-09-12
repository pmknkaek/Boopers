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
        dy = 0;
        dx = 4;
        score = 0;
        height = h;
        width = w/numFrames;
        x=GamePanel.WIDTH/2;
        y=GamePanel.HEIGHT-height;

        Bitmap[] image = new Bitmap[numFrames];
        spriteSheet = res;

        for (int i = 0; i < image.length; i++) {
            image[i] = Bitmap.createBitmap(spriteSheet, i*width, 0, width, height);
        }

        animation.setFrames(image);
        animation.setDelay(500);
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

        //y movement
       if (up){
            dy = -4;
        }
        else {
            dy = 4;
        }

        if (dy>14)dy=14;
        if (dy<-14)dy=-14;

        y+= dy;
        dy = 0;
        x+=dx;

        //limiting creature to canvas
        if(y<0){y=0;}
        if(y>GamePanel.HEIGHT-height){y=GamePanel.HEIGHT-height;}
        if(x<0 || x>GamePanel.WIDTH-width){dx *= -1;}
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(animation.getImage(), x, y, null);
    }
    public int getScore(){return score;}
    public boolean getPlaying(){return playing;}
    public void setPlaying(boolean b){playing = b;}
    public void resetScore(){score = 0;}
}
