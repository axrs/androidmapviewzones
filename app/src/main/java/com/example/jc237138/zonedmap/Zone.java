package com.example.jc237138.zonedmap;

import android.graphics.RectF;

/**
 * Created by jc237138 on 7/04/2015.
 */
public class Zone {

    private static int HIT_BOX_SIZE = 44;
    //Top left corner of hit box
    private float x, y;
    private RectF hitRegion;
    private String name = "Unnamed Zone";

    public Zone() {
        updateHitRegion();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
        updateHitRegion();
    }

    public float getY() {
        return y;
    }
    public int getWidth(){
        return HIT_BOX_SIZE;
    }

    public void setY(float y) {
        this.y = y;
        updateHitRegion();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void updateHitRegion() {
        hitRegion = new RectF(x, y, x + HIT_BOX_SIZE, y + HIT_BOX_SIZE);
    }

    //Test taps in this zone for a hit
    public boolean hitTest(float x, float y) {
        return hitRegion != null && hitRegion.contains(x, y);
    }

    public enum State {
        UNLOCKED,
        LOCKED,
        COMPLETED
    }

}
