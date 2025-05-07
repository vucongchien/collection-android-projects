package com.example.gridviewnangcao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class PictureActivity extends AppCompatActivity {
    private ImageView imageView;
    ArrayList<TextView> listTxtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_picture);
        imageView=findViewById(R.id.imageView);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("data");
        ITEMActivity item = (ITEMActivity) bundle.getSerializable("item");
        imageView.setImageResource(item.getHinh());

        listTxtView=new ArrayList<>();

        listTxtView.add(findViewById(R.id.textView4));
        listTxtView.add(findViewById(R.id.textView5));
        listTxtView.add(findViewById(R.id.textView6));

        listTxtView.get(0).setText(item.getTen()[0]);
        listTxtView.get(1).setText(item.getTen()[1]);
        listTxtView.get(2).setText(item.getTen()[2]);




    }

    public void BackActivity(View view) {
        finish();
    }
}