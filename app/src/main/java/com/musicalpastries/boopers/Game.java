package com.musicalpastries.boopers;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Game extends AppCompatActivity {
    private GLSurfaceView glView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //turn off title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //set to full screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActivityManager mgr = (ActivityManager) this.getSystemService(Activity.ACTIVITY_SERVICE);
        ConfigurationInfo info = mgr.getDeviceConfigurationInfo();
        if (info.reqGlEsVersion >= 0x20000){
            glView = new boopersGLSurfaceView(this);
        }


        setContentView(glView);
    }


}
