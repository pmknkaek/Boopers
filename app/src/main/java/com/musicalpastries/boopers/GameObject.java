package com.musicalpastries.boopers;

import android.graphics.Rect;

/**
 * Created by Andrew Groeling on 9/9/2017.
 */

public abstract class GameObject {
    protected int x, y, dy, dx, width, height;

    //getters and setters
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    //
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }
    //
    public void setDy(int dy) {
        this.dy = dy;
    }
    public int getDy() {
        return dy;
    }
    //
    public void setDx(int dx) {
        this.dx = dx;
    }
    public int getDx() {
        return dx;
    }
    //
    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }
    //
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    //
    public Rect getRectangle(){
        return new Rect(x, y, x+width, y+height);
    }
}
