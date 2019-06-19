package com.example.araprojem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Onceki_Checkinler extends AppCompatActivity {
    RecyclerView recyclerView;
    CheckinsAdapter adapter;
    List<Checkins> checkin_listesi;
    veriKaynagi vk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onceki__checkinler);
        checkin_listesi = new ArrayList<>();
        vk=new veriKaynagi(this);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        int size = getIntent().getExtras().getInt("size");
        for(int i=0;i<size;i++)
            checkin_listesi.add((Checkins) bundle.getSerializable("oneri"+i));

        adapter= new CheckinsAdapter(this, checkin_listesi);
        recyclerView.setAdapter(adapter);

    }

    public class CheckinsAdapter extends RecyclerView.Adapter<CheckinsAdapter.CheckinsViewHolder>{

        private Context myContext;
        private List<Checkins> checkin_listesi;
        private Checkins secilen;

        public CheckinsAdapter(Context myContext, List<Checkins> checkin_listesi) {
            this.myContext = myContext;
            this.checkin_listesi = checkin_listesi;
        }

        @Override
        public CheckinsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater inflater=LayoutInflater.from(myContext);
            View view=inflater.inflate(R.layout.list_layout, null);
            return new CheckinsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CheckinsViewHolder checkinsViewHolder, int i) {
            Checkins check_in=checkin_listesi.get(i);
            checkinsViewHolder.secilen=checkin_listesi.get(i);
            checkinsViewHolder.textView_user.setText("Userid->"+check_in.getUserid());
            checkinsViewHolder.textView_venueid.setText("Venueid->"+check_in.getVenueid());
            checkinsViewHolder.textView_category.setText("Category->"+check_in.getCategory());
            checkinsViewHolder.textView_city.setText("City->"+check_in.getCity());
        }

        @Override
        public int getItemCount() {
            return checkin_listesi.size();
        }

        class CheckinsViewHolder extends RecyclerView.ViewHolder{

            TextView textView_user, textView_venueid, textView_category, textView_city ;
            Checkins secilen;

            public CheckinsViewHolder(View itemView) {
                super(itemView);
                textView_user=itemView.findViewById(R.id.textView_userid_3);
                textView_venueid=itemView.findViewById(R.id.textView_venueid_3);
                textView_category=itemView.findViewById(R.id.textView_category_3);
                textView_city=itemView.findViewById(R.id.textView_city_3);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getBaseContext(), Harita.class);
                        startActivity(intent);
                    }
                });
            }
        }
    }


}

