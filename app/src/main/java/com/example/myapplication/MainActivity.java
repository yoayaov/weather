package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());//不采用该句代码，将使用内置浏览器访问网页
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://m.weather.com.cn/mweather/101010100.shtml");//设置默认显示天气预报信息
        webView.scrollTo(0,95);//滚动页面到（0，95）位置
        webView.setInitialScale(60);//将网页内容缩放60%

        Button bj = (Button) findViewById(R.id.beijing);
        bj.setOnClickListener(this);
        Button sh = (Button) findViewById(R.id.shanghai);
        sh.setOnClickListener(this);
        Button heb = (Button) findViewById(R.id.haerbing);
        heb.setOnClickListener(this);
        Button cc = (Button) findViewById(R.id.changchun);
        cc.setOnClickListener(this);
        Button sy = (Button) findViewById(R.id.shenyang);
        sy.setOnClickListener(this);
        Button gz = (Button) findViewById(R.id.guangzhou);
        gz.setOnClickListener(this);
    }

    @Override
    public void onClick (View view) {
        switch (view.getId()){
            case R.id.beijing:
                openUrl("101010100");
                break;
            case R.id.shanghai:
                openUrl("101020100");
                break;
            case R.id.haerbing:
                openUrl("101050101");
                break;
            case R.id.changchun:
                openUrl("101060101");
                break;
            case R.id.shenyang:
                openUrl("101070101");
                break;
            case R.id.guangzhou:
                openUrl("101280101");
                break;
        }
    }

    private void openUrl(String id) {
        webView.loadUrl("http://m.weather.com.cn/mweather/"+id+".shtml");//获取并显示天气预报信息
    }
}