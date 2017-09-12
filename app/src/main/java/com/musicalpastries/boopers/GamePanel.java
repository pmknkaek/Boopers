package com.musicalpastries.boopers;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/**
 * Created by Andrew Groeling on 9/7/2017.
 */


public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{

    private MainThread thread;
    public static final int HEIGHT = 576;
    public static final int WIDTH = 1024;
    private Creature creature;

    public GamePanel(Context context){
        super(context);

        //add callback to surfaceholder to intercept events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        //make gamepanel focusable so it can handle events
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        int counter = 0;
        while (retry && counter<1000){
            counter++;
            try{
                thread.setRunning(false);
                thread.join();
                retry = false;
            }catch (Exception e){e.printStackTrace();}
        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        creature = new Creature(BitmapFactory.decodeResource(getResources(), R.drawable.duck), 213, 64, 3);
        //can safely start game loop
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            if(!creature.getPlaying()){
                creature.setPlaying(true);
            }
            else{
                creature.setUp(true);
            }
            return true;
        }
        if(event.getAction()==MotionEvent.ACTION_UP){
            creature.setUp(false);
            return true;
        }

        return super.onTouchEvent(event);
    }

    public void update(){
        creature.update();
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        final float scaleFactorX = getWidth()/(WIDTH*1.f);
        final float scaleFactorY = getHeight()/(HEIGHT*1.f);

        if(canvas != null){
            final int savedState =  canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            creature.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }
}
