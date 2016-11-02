package edu.okstate.cs.tashwin.android_srufaceview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



class mySurfaceView extends SurfaceView implements SurfaceHolder.Callback{

    private SurfaceHolder thisHolder;
    //Constructor for my surface view
    public mySurfaceView(Context context){
        super(context);
        //Get surface holder object
        thisHolder = getHolder();
        //Add a call back to the surface holder object
        thisHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //Code to draw on surface
        drawingLogic(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int frmt, int w, int h) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}

    private void drawingLogic(SurfaceHolder holder){
        //Lock the canvas
        Canvas myCanvas = holder.lockCanvas();
        if (myCanvas==null){
            Log.e("Surface View Error", "My Canvas object is null");
        }else{
            //Drawing logic
            myCanvas.drawColor(Color.WHITE);
            myCanvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher), 250, 250,null);
            //Unlock canvas when all drawing operations are completed
            holder.unlockCanvasAndPost(myCanvas);
        }
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new mySurfaceView(this));
    }
}
