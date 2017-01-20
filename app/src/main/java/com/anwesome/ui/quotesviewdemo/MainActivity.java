package com.anwesome.ui.quotesviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.anwesome.ui.quotesview.QuotesView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap backgroundImage = BitmapFactory.decodeResource(getResources(),R.drawable.stp2);
        Bitmap profile = BitmapFactory.decodeResource(getResources(),R.drawable.pf_avtar);
        String quote = "Hello i am gonna go all the way lets see who can stop me";
        QuotesView quotesView = new QuotesView(this,backgroundImage,profile,quote, Color.parseColor("#FFEB3B"));
        addContentView(quotesView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
}
