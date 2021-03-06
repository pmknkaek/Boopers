package com.musicalpastries.boopers;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by Andrew Groeling on 9/7/2017.
 */

public class MainThread extends Thread{
    private int FPS = 45;
    private double avgFPS;
    private SurfaceHolder surfaceHolder;
    private boopersGLSurfaceView boopersGLSurfaceView;
    private boolean running;
    private static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, boopersGLSurfaceView boopersGLSurfaceView){
        super();
        this.surfaceHolder = surfaceHolder;
        this.boopersGLSurfaceView = boopersGLSurfaceView;
    }
/*
    @Override
    public void run(){
        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount = 0;
        long targetTime = 1000/FPS;

        while(running) {
            startTime = System.nanoTime();
            canvas = null;

            //try locking canvas
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.boopersGLSurfaceView.update();
                    this.boopersGLSurfaceView.draw(canvas);
                }
            }
            catch (Exception e) {}
            finally {
                if(canvas!=null){
                    try{surfaceHolder.unlockCanvasAndPost(canvas);
                    }catch (Exception e){e.printStackTrace();}
                }
            }
            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime-timeMillis;

            try{
                this.sleep(waitTime);
            }catch (Exception e){}

            totalTime += System.nanoTime()-startTime;
            frameCount++;
            if(frameCount == FPS){
                avgFPS = 1000/((totalTime/frameCount)/1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(avgFPS);
            }
        }
    }

    public void setRunning(boolean running){
        this.running = running;
    }*/
}
