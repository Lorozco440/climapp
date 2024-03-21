package com.umglorozco.climapp.Activitis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.umglorozco.climapp.Adapters.HourlyAdapters;
import com.umglorozco.climapp.Domains.Hourly;
import com.umglorozco.climapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterHourly;
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initiRecylerView();
        setVaribla();
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }

    private void setVaribla() {
        TextView next7dayBtn = findViewById(R.id.nextBtn);
        next7dayBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FutureActivity.class)));
    }

    private void initiRecylerView() {
        ArrayList<Hourly> items=new ArrayList<>();

        items.add(new Hourly("9 pm",28,"cloudy"));
        items.add(new Hourly("11 pm",29,"sunny"));
        items.add(new Hourly("12 pm",30,"wind"));
        items.add(new Hourly("1 am",29,"rainy"));
        items.add(new Hourly("2 am",27,"storm"));

        recyclerView=findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterHourly=new HourlyAdapters(items);
        recyclerView.setAdapter(adapterHourly);
    }
}