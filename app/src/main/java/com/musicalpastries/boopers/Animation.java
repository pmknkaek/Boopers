package com.musicalpastries.boopers;

import android.graphics.Bitmap;

/**
 * Created by Andrew Groeling on 9/9/2017.
 */

public class Animation {
    private Bitmap[] frames;
    private int currentFrame;
    private long startTime;
    private long delay;
    private boolean playedOnce;

    public void setFrames(Bitmap[] frames){
        this.frames = frames;
        currentFrame = 0;
        startTime = System.nanoTime();
    }

    public boolean playedOnce(){return playedOnce;}
    //
    public void setDelay(long d){delay = d;}
    //
    public void setCurrentFrameFrame(int i){currentFrame = i;}
    public int getCurrentFrame() {
        return currentFrame;
    }
    //
    public Bitmap getImage(){
        return frames[currentFrame];
    }

    public void update(){
        long elapsed = (System.nanoTime()-startTime)/1000000;

        if (elapsed>delay){
            currentFrame++;
            startTime = System.nanoTime();
        }
        if(currentFrame == frames.length){
            currentFrame = 0;
            playedOnce = true;
        }
    }


}
