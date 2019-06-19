package com.example.araprojem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button button_kontrol,button_checkins,button_oneri1,button_oneri2,button_oneri3,button_oneri4;
    EditText id;
    veriKaynagi vk;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=(EditText) findViewById(R.id.editText_userid);
        vk=new veriKaynagi(this);
        textView = (TextView) findViewById(R.id.textView1);

        button_checkins=(Button) findViewById(R.id.button_checkins);
        button_checkins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExist_user()) {
                    Intent i = new Intent(getBaseContext(), Onceki_Checkinler.class);
                    onResume();
                    List<Checkins> checkinsList=new ArrayList<>();
                    checkinsList=vk.checkins_listele(id.getText().toString());
                    int size=checkinsList.size();
                    i.putExtra("size",size);
                    Bundle bundle = new Bundle();
                    for(int x=0;x<size;x++){
                        bundle.putSerializable("oneri"+x,checkinsList.get(x));
                    }
                    i.putExtras(bundle);
                    startActivity(i);
                }
            }
        });

        button_kontrol=(Button) findViewById(R.id.button_kontrol);
        button_kontrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isExist_user();
            }
            });

        button_oneri1=(Button) findViewById(R.id.button_oneri1);
        button_oneri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExist_user()) {
                    Intent intent = new Intent(getBaseContext(), oneri1_gosterici.class);
                    onResume();
                    Oneri_1 oneri = vk.getir_oneri_1(id.getText().toString());
                    Toast.makeText(getApplicationContext(), "Userid="+oneri.getUserid(), Toast.LENGTH_LONG).show();
                    onPause();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("oneri", oneri);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        button_oneri2=(Button) findViewById(R.id.button_oneri2);
        button_oneri2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExist_user()) {
                    Intent intent = new Intent(getBaseContext(), Oneriler.class);
                    onResume();
                    Oneri_2 oneri = vk.getir_oneri_2(id.getText().toString());
                    Toast.makeText(getApplicationContext(), "Userid="+oneri.getUserid(), Toast.LENGTH_LONG).show();
                    onPause();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("oneri", oneri);
                    intent.putExtra("KEY",2);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        button_oneri3=(Button) findViewById(R.id.button_oneri3);
        button_oneri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isExist_user()) {
                    Intent intent = new Intent(getBaseContext(), Oneriler.class);
                    onResume();
                    Oneri_3 oneri = vk.getir_oneri_3(id.getText().toString());
                    Toast.makeText(getApplicationContext(), "Userid="+oneri.getUserid(), Toast.LENGTH_LONG).show();
                    onPause();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("oneri", oneri);
                    intent.putExtra("Key",3);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });

        button_oneri4=(Button) findViewById(R.id.button_oneri4);
        button_oneri4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*try {
                    onResume();
                    InputStream inputStream = getAssets().open("Poi.txt");
                    BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
                    int count=0;
                    String converter="";
                    converter=r.readLine();
                    while(converter!=null) {
                        char[] line = converter.toCharArray();
                        int i = 0;
                        String venueid = "";
                        while (line[i] != ';')
                            venueid += line[i++];
                        i++;
                        String latitude = "";
                        while (line[i] != ';')
                            latitude += line[i++];
                        i++;
                        String longitude = "";
                        while (line[i] != '*')
                            longitude += line[i++];

                        vk.placesEkle(venueid,latitude,longitude);
                        converter=r.readLine();
                        count++;
                    }
                    Toast.makeText(getApplicationContext(), "Total="+count, Toast.LENGTH_LONG).show();
                    r.close();
                    inputStream.close();
                    onPause();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                textView.setText("Bitti");*/
                /*onResume();
                Places pc=vk.getir_place("41.039743");
                onPause();

                Toast.makeText(getApplicationContext(), pc.getVenueid()+"-"+pc.latitude+"-"+pc.longitude, Toast.LENGTH_LONG).show();*/
/*
                Intent intent = new Intent(getBaseContext(), Harita.class);
                vk.ac();
                vk.tablosil();
                vk.kapat();
*/
                Intent intent=new Intent (getBaseContext(), Karsilastirma.class);
                startActivity(intent);
            }
        });


    }
    private boolean isExist_user(){
        onResume();
        String userid=id.getText().toString();
        if(id.getText().toString().length()==0){
            textView.setText("Lütfen kullanıcı adı giriniz!");
            onPause();
            return false;
        }else if(vk.isExistOneri_1(userid)){
            textView.setText(userid+" adlı kullanıcı vardır. Önerilere bakabilirsiniz!");
            onPause();
            return true;
        }else{
            textView.setText(userid+" adlı kullanıcı bulunamadı. Tekrar deneyin!");
            onPause();
            return false;
        }
    }

    protected void onResume(){
        vk.ac();
        super.onResume();
    }
    protected void onPause(){
        vk.kapat();
        super.onPause();
    }
}
