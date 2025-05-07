package com.example.gridviewnangcao;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;

public class ITEMActivity implements Serializable {
    private int Hinh;
    private  String[] Ten;

    public ITEMActivity(int hinh,String[] Ten) {
        Hinh = hinh;
        this.Ten=Ten;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String[] getTen() {
        return Ten;
    }

    public void setTen(String[] ten) {
        Ten = ten;
    }
}