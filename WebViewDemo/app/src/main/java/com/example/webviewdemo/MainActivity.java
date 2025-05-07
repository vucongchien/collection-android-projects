package com.example.webviewdemo;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText editText;

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

        webView=findViewById(R.id.webVIew);
        editText=findViewById(R.id.editTextText3);
        webView.setWebViewClient(new WebViewClient());
    }

    public void backButton(View view) {
        if(webView.canGoBack()){
            webView.goBack();
        }
    }

    public void ReloadButton(View view) {
        webView.reload();
    }

    public void goBack(View view) {
        webView.loadUrl(editText.getText().toString());
    }

    public void fwdButton(View view) {
        if (webView.canGoForward()){
            webView.goForward();
        }
    }
}