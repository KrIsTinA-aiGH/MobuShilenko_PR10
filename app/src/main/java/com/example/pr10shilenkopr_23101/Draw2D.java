package com.example.pr10shilenkopr_23101;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import androidx.annotation.NonNull;

public class Draw2D extends View {
    private final Paint mPaint = new Paint(); //кисть для рисования
    private final Bitmap mTreeBitmap;
    private final Bitmap mCloudBitmap;

    //загружаем изображения из папки
    public Draw2D(Context context) {
        super(context);
        Resources res = this.getResources();
        mTreeBitmap = BitmapFactory.decodeResource(res, R.drawable.tree);
        mCloudBitmap = BitmapFactory.decodeResource(res, R.drawable.cloud);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) { //canvas -сам холст
        super.onDraw(canvas);
        //получаем ширину и высоту экрана
        int width = getWidth();
        int height = getHeight();

        // Заливка фона
        mPaint.setStyle(Paint.Style.FILL);//стиль заливки
        mPaint.setColor(Color.parseColor("#87CEEB"));
        canvas.drawPaint(mPaint);//заливаем весь холст

        // Солнце
        mPaint.setAntiAlias(true); //сглаживаем края
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(width - 100, 100, 60, mPaint);//распологаем в правом верхнем углу

        // Облака
        canvas.drawBitmap(mCloudBitmap, 100, 50, mPaint);

        // Трава
        mPaint.setColor(Color.parseColor("#32CD32"));
        canvas.drawRect(0, height - 200, width, height, mPaint);

        // Дерево
        int treeY = height - mTreeBitmap.getHeight() - 200;
        canvas.drawBitmap(mTreeBitmap, 200, treeY, mPaint);

        // Дом
        mPaint.setColor(Color.parseColor("#8B4513"));
        //создаем прямоугольник
        canvas.drawRect(500, height - 400, 800, height - 200, mPaint);
        mPaint.setColor(Color.RED);
        //крыша
        @SuppressLint("DrawAllocation") Path roofPath = new Path();
        //углы
        roofPath.moveTo(480, height - 400);
        roofPath.lineTo(650, height - 500);
        roofPath.lineTo(820, height - 400);
        roofPath.close();//замкнуть
        canvas.drawPath(roofPath, mPaint);

        // Окно
        mPaint.setColor(Color.CYAN);
        canvas.drawRect(600, height - 350, 700, height - 250, mPaint);
        //черные линии окна
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);//толщина
        canvas.drawLine(650, height - 350, 650, height - 250, mPaint);//вертикаль
        canvas.drawLine(600, height - 300, 700, height - 300, mPaint);//горизонталь

        // Забор
        mPaint.setColor(Color.parseColor("#D2691E"));
        for (int i = 0; i < width; i += 50) {
            canvas.drawRect(i, height - 200, i + 20, height - 100, mPaint);
        }
        canvas.drawRect(0, height - 150, width, height - 140, mPaint);
    }

}