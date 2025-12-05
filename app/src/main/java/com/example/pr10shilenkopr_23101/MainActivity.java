package com.example.pr10shilenkopr_23101;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Draw2D draw2D = new Draw2D(this);//создаем наш Draw2D
        setContentView(draw2D);//устанавливаем как содержимое экрана
    }
}