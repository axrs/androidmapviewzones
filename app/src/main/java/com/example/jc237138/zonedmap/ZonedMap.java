package com.example.jc237138.zonedmap;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Vector;

/**
 * Created by jc237138 on 7/04/2015.
 */
public class ZonedMap extends RelativeLayout {

    private Vector<Zone> zones;

    public ZonedMap(Context context) {
        super(context);
        init();
    }

    public ZonedMap(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ZonedMap(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        for(Zone z : getZones()){
            ZoneView v = new ZoneView(this.getContext());
            v.setZone(z);
            Log.d("ZonedMap",String.format("%dx%d@%f,%f",v.getWidth(),v.getHeight(),v.getX(),v.getY()));
            addView(v);
            v.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ZoneView zv = (ZoneView)v;
                    Toast.makeText(v.getContext(),zv.getZone().getName(),Toast.LENGTH_LONG).show();
                }
            });
        }

    }
    public Vector<Zone> getZones() {
        if (zones == null) {
            zones = new Vector<>();
            //ToDo: Factory generate zones on map and their status
            for (int i = 0; i < 5; i++){
                Zone z = new Zone();
                z.setName(String.format("Zone %d",i));

                z.setX((float)Math.random()*2048);
                z.setY((float)Math.random()*1068);
                zones.add(z);
            }

        }
        return zones;
    }
}
