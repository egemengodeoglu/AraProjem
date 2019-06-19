package com.example.araprojem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

public class Oneriler extends AppCompatActivity {
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10,
            textView_user, textView_basari,textView_info,textView_genel_basari;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneriler);

        textView1=(TextView) findViewById(R.id.textView_mekan1);
        textView2=(TextView) findViewById(R.id.textView_mekan2);
        textView3=(TextView) findViewById(R.id.textView_mekan3);
        textView4=(TextView) findViewById(R.id.textView_mekan4);
        textView5=(TextView) findViewById(R.id.textView_mekan5);
        textView6=(TextView) findViewById(R.id.textView_mekan6);
        textView7=(TextView) findViewById(R.id.textView_mekan7);
        textView8=(TextView) findViewById(R.id.textView_mekan8);
        textView9=(TextView) findViewById(R.id.textView_mekan9);
        textView10=(TextView) findViewById(R.id.textView_mekan10);
        textView_user=(TextView) findViewById(R.id.textView_user_id);
        textView_basari=(TextView) findViewById(R.id.textView_basari);
        textView_info=(TextView) findViewById(R.id.textView_info);
        textView_genel_basari=(TextView) findViewById(R.id.textView_genel_basari);
        checkBox1=(CheckBox) findViewById(R.id.checkBox1);
        checkBox2=(CheckBox) findViewById(R.id.checkBox2);
        checkBox3=(CheckBox) findViewById(R.id.checkBox3);
        checkBox4=(CheckBox) findViewById(R.id.checkBox4);
        checkBox5=(CheckBox) findViewById(R.id.checkBox5);
        checkBox6=(CheckBox) findViewById(R.id.checkBox6);
        checkBox7=(CheckBox) findViewById(R.id.checkBox7);
        checkBox8=(CheckBox) findViewById(R.id.checkBox8);
        checkBox9=(CheckBox) findViewById(R.id.checkBox9);
        checkBox10=(CheckBox) findViewById(R.id.checkBox10);
        checkBox1.setClickable(false);
        checkBox2.setClickable(false);
        checkBox3.setClickable(false);
        checkBox4.setClickable(false);
        checkBox5.setClickable(false);
        checkBox6.setClickable(false);
        checkBox7.setClickable(false);
        checkBox8.setClickable(false);
        checkBox9.setClickable(false);
        checkBox10.setClickable(false);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        int chooser = getIntent().getExtras().getInt("KEY");
        if(chooser==2){
            Oneri_2 oneri=(Oneri_2) bundle.getSerializable("oneri");
            textView_user.setText(oneri.getUserid());
            textView1.setText(oneri.getVenueid1());
            if(oneri.getControl1().equals("Y")){ checkBox1.setChecked(true);}
            textView2.setText(oneri.getVenueid2());
            if(oneri.getControl2().equals("Y")){ checkBox2.setChecked(true);}
            textView3.setText(oneri.getVenueid3());
            if(oneri.getControl3().equals("Y")){ checkBox3.setChecked(true);}
            textView4.setText(oneri.getVenueid4());
            if(oneri.getControl4().equals("Y")){ checkBox4.setChecked(true);}
            textView5.setText(oneri.getVenueid5());
            if(oneri.getControl5().equals("Y")){ checkBox5.setChecked(true);}
            textView6.setText(oneri.getVenueid6());
            if(oneri.getControl6().equals("Y")){ checkBox6.setChecked(true);}
            textView7.setText(oneri.getVenueid7());
            if(oneri.getControl7().equals("Y")){ checkBox7.setChecked(true);}
            textView8.setText(oneri.getVenueid8());
            if(oneri.getControl8().equals("Y")){ checkBox8.setChecked(true);}
            textView9.setText(oneri.getVenueid9());
            if(oneri.getControl9().equals("Y")){ checkBox9.setChecked(true);}
            textView10.setText(oneri.getVenueid10());
            if(oneri.getControl10().equals("Y")){ checkBox10.setChecked(true);}
            textView_basari.setText("Başarı Oranı : %"+(oneri.getCounter()*10));
            textView_genel_basari.setText("Toplam Başarı Oranı : %58,67");
            textView_info.setText("Şehir bazında en popüler mekanlar");
        }else{
            Oneri_3 oneri=(Oneri_3) bundle.getSerializable("oneri");
            textView_user.setText(oneri.getUserid());
            if(oneri.getControl1().equals("Y")){ checkBox1.setChecked(true);}
            textView2.setText(oneri.getVenueid2());
            if(oneri.getControl2().equals("Y")){ checkBox2.setChecked(true);}
            textView3.setText(oneri.getVenueid3());
            if(oneri.getControl3().equals("Y")){ checkBox3.setChecked(true);}
            textView4.setText(oneri.getVenueid4());
            if(oneri.getControl4().equals("Y")){ checkBox4.setChecked(true);}
            textView5.setText(oneri.getVenueid5());
            if(oneri.getControl5().equals("Y")){ checkBox5.setChecked(true);}
            textView6.setText(oneri.getVenueid6());
            if(oneri.getControl6().equals("Y")){ checkBox6.setChecked(true);}
            textView7.setText(oneri.getVenueid7());
            if(oneri.getControl7().equals("Y")){ checkBox7.setChecked(true);}
            textView8.setText(oneri.getVenueid8());
            if(oneri.getControl8().equals("Y")){ checkBox8.setChecked(true);}
            textView9.setText(oneri.getVenueid9());
            if(oneri.getControl9().equals("Y")){ checkBox9.setChecked(true);}
            textView10.setText(oneri.getVenueid10());
            if(oneri.getControl10().equals("Y")){ checkBox10.setChecked(true);}
            textView_basari.setText("Başarı Oranı : %"+(oneri.getCounter()*10));
            textView_genel_basari.setText("Toplam Başarı Oranı : %99,82");
            textView_info.setText("Kendine en benzer kullanıcının popüler mekanları");
        }







    }
}
