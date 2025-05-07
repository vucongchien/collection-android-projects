package com.example.toastapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  {
    Button button;
    ConstraintLayout linearLayout;
    boolean isLayoutRed=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button=findViewById(R.id.button2);
        linearLayout=findViewById(R.id.main);

    }


    public void showToast(View view) {
        Toast.makeText(this,"this is a toast",Toast.LENGTH_SHORT).show();
        if(isLayoutRed){
            linearLayout.setBackgroundColor(Color.BLACK);
            isLayoutRed = false;
        }
        else{
            linearLayout.setBackgroundColor(Color.RED);
            isLayoutRed=true;
        }
    }
}