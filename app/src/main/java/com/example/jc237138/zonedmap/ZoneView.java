package com.example.jc237138.zonedmap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by jc237138 on 7/04/2015.
 */
public class ZoneView extends ImageView {
    private Zone zone;

    public ZoneView(Context context) {
        super(context);
    }

    public ZoneView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZoneView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
        this.setX(zone.getX());
        this.setY(zone.getY());
        this.setLayoutParams(new ViewGroup.LayoutParams(zone.getWidth(),zone.getWidth()));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(Color.parseColor("Black"));
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), p);
    }
}
