package com.example.gridviewnangcao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ITEMActivity> listItem;
    GridAdapter gridAdapter;
    GridView gridView;

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
        listItem=new ArrayList<>();
        listItem.add(new ITEMActivity(R.drawable.a,new String[]{"adw","asdasd","adw"}));
        listItem.add(new ITEMActivity(R.drawable.adsf,new String[]{"adw","asdasd","adw"}));
        listItem.add(new ITEMActivity(R.drawable.wef,new String[]{"adw","asdasd","adw"}));
        listItem.add(new ITEMActivity(R.drawable.poster1,new String[]{"adw","asdasd","adw"}));
        listItem.add(new ITEMActivity(R.drawable.a,new String[]{"adw","asdasd","adw"}));
        listItem.add(new ITEMActivity(R.drawable.adsf,new String[]{"adw","asdasd","adw"}));
        listItem.add(new ITEMActivity(R.drawable.wef,new String[]{"adw","asdasd","adw"}));
        listItem.add(new ITEMActivity(R.drawable.poster1,new String[]{"adw","asdasd","adw"}));
        listItem.add(new ITEMActivity(R.drawable.a,new String[]{"adw","asdasd","adw"}));
        listItem.add(new ITEMActivity(R.drawable.adsf,new String[]{"adw","asdasd","adw"}));
        listItem.add(new ITEMActivity(R.drawable.wef,new String[]{"adw","asdasd","adw"}));
        listItem.add(new ITEMActivity(R.drawable.poster1,new String[]{"adw","asdasd","adw"}));

        gridView=findViewById(R.id.grview);

        gridAdapter=new GridAdapter(this,R.layout.activity_itemactivity,listItem);

        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ITEMActivity item=listItem.get(i);
                Intent intent=new Intent(MainActivity.this, PictureActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("item",item);
                intent.putExtra("data",bundle);
                startActivity(intent);
            }
        });

    }


}