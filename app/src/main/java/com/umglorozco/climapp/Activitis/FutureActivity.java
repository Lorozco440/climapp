package com.umglorozco.climapp.Activitis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.umglorozco.climapp.Adapters.FutureAdapter;
import com.umglorozco.climapp.Domains.FutureDomain;
import com.umglorozco.climapp.R;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTommorow;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_future);

        initRecyclerView();
        setVariable();
        
      /*  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }

    private void setVariable() {
        ConstraintLayout backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v -> startActivity(new Intent(FutureActivity.this,MainActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items = new ArrayList<>();
        items.add(new FutureDomain("Sat","storm","storm",25,10));
        items.add(new FutureDomain("Sun","cloudy","cloudy",24,16));
        items.add(new FutureDomain("Mon","windy","windy",29,15));
        items.add(new FutureDomain("Tue","cloudy_sunny","Cloudy Sunny",22,13));
        items.add(new FutureDomain("Wen","sunny","sunny",28,11));
        items.add(new FutureDomain("Thu","rainy","Rainy",23,12));

        recyclerView=findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterTommorow=new FutureAdapter(items);
        recyclerView.setAdapter(adapterTommorow);
    }
}