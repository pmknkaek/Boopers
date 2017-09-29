package com.musicalpastries.boopers;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Andrew Groeling on 9/28/2017.
 */

public class BitmapChoocher {

    public static Bitmap slime;

    public static void loadAllBitmaps(Context context){
        final AssetManager mgr = context.getAssets();
        slime = load(mgr, "slime.png");	}

    private static Bitmap load(final AssetManager manager, String filename){
        Bitmap result = null;
        try {
            result = BitmapFactory.decodeStream(manager.open(filename));
        } catch (IOException e) {
            Log.e("BitmapChoocher", "Error loading art resource.", e);
        }

        return result;
    }

    public static Bitmap copy(Bitmap b){
        Bitmap copy = null;

        return copy;
    }
}
