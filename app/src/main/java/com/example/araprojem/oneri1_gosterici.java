package com.example.araprojem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

public class oneri1_gosterici extends AppCompatActivity {
    TextView textView1, textView_user, textView_basari,textView_info,textView_genel_basari;
    CheckBox checkBox1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneri1_gosterici);
        textView1=(TextView) findViewById(R.id.textView_mekan1_2);
        textView_user=(TextView) findViewById(R.id.textView_user_id2);
        textView_basari=(TextView) findViewById(R.id.textView_basari2);
        textView_info=(TextView) findViewById(R.id.textView_info2);
        textView_genel_basari=(TextView) findViewById(R.id.textView_genel_basari2);
        checkBox1=(CheckBox) findViewById(R.id.checkBox1_2);
        checkBox1.setClickable(false);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        Oneri_1 oneri=(Oneri_1) bundle.getSerializable("oneri");
        textView_user.setText(oneri.getUserid());
        textView1.setText(oneri.getVenueid());
        if(oneri.getControl().equals("Y")){
            checkBox1.setChecked(true);
            textView_basari.setText("Başarı Oranı : %100");
        }else{
            checkBox1.setChecked(false);
            textView_basari.setText("Başarı Oranı : %0");
        }
        textView_info.setText("Kategorilere Göre En Popüler Mekan Önerisi");
        textView_genel_basari.setText("Toplam Başarı : % 85,74");
    }
}
