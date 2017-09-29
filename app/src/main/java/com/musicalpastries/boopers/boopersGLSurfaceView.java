package com.musicalpastries.boopers;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.microedition.khronos.opengles.GL10;

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
        BitmapChoocher.loadAllBitmaps(context);


    }
    public static int loadTexture(Bitmap bitmap, int copy) {
        // This is to check for possible reinitialization to prevent black textures
        if (bitmap.isRecycled()) {
            Log.e("Entity", "Bitmap is already recycled. Detected too soon.");
            bitmap = BitmapChoocher.copy(BitmapChoocher.slime);
        }
        //Texture loading
        final int[] textureID = new int[1];
        GLES20.glGenTextures(1, textureID, 0);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureID[0]);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_NEAREST);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_NEAREST);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_CLAMP_TO_EDGE);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_CLAMP_TO_EDGE);
        GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);	GLES20.glGenerateMipmap(GLES20.GL_TEXTURE_2D);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, 0);

        bitmap.recycle();
        copy = textureID[0];
        return textureID[0];
    }


}