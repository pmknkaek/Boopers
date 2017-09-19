package com.musicalpastries.boopers;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import java.util.ArrayList;

/**
 * Created by Andrew Groeling on 9/7/2017.
 */


public class boopersGLSurfaceView extends GLSurfaceView {

    private MainThread thread;
    private final boopersGLRenderer mRenderer;

    public boopersGLSurfaceView(Context context){
        super(context);
        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);
        mRenderer = new boopersGLRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);
        //set renderer to draw only when necessary
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}