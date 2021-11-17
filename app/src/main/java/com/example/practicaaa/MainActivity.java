package com.example.practicaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);

    TextView a,e;
    ImageView hola;
    Animation ww,ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ww = AnimationUtils.loadAnimation(this,R.anim.animation);
        ss = AnimationUtils.loadAnimation(this,R.anim.animacion2);

        hola=findViewById(R.id.imvImgaenxd);
        a=findViewById(R.id.txvHola);
        e=findViewById(R.id.txvWenas);

        hola.setAnimation(ww);
        a.setAnimation(ss);
        e.setAnimation(ss);

        splashh();
    }
    private void splashh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(MainActivity.this,hoola.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}