package com.andresmunozl.prueba1dibujar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Vista vista = new Vista(this);
        setContentView(vista);
    }

    class Vista extends View {

        float posX,posY=1;
        String accion = "accion";
        Path ruta = new Path();

        public Vista(Context context) {
            super(context);
        }

        public void onDraw(Canvas canvas) {
            Paint pintar = new Paint();
            pintar.setStyle(Paint.Style.STROKE);
            pintar.setStrokeWidth(5);
            pintar.setColor(Color.BLUE);

            int ancho = canvas.getWidth();
            if(accion == "presionado"){
                ruta.moveTo(posX,posY);

            }
            //cambio
            if(accion== "moviendo"){
                ruta.lineTo(posX,posY);
            }
            //canvas.drawLine(20,20,ancho-10,55, pintar);

            canvas.drawPath(ruta,pintar);
        }

        public boolean onTouchEvent(MotionEvent tipomovimiento){
            posX= tipomovimiento.getX();
            posY= tipomovimiento.getY();

            if(tipomovimiento.getAction() == MotionEvent.ACTION_DOWN)
                accion="presionado";
            if(tipomovimiento.getAction() == MotionEvent.ACTION_MOVE)
                accion="moviendo";

            invalidate();
            return true;
        }
    }

}
