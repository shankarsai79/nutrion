package com.example.nutritiousfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    String id,string;
    RecyclerView recyclerView;
    List<String> ids = new ArrayList<>();
    ArrayList<String> idss= new ArrayList<>();
    MyAdapater adapter;
    Context context;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("food").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    id = ds.child("id").getValue(String.class);
                    idss.add(id);
                    i++;
                    string = string + id;
                    if (i == 45) {
                        hii();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //
        recyclerView = findViewById(R.id.recyclerview);

    }
    void hii(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MyAdapater(this, idss);
        recyclerView.setAdapter(adapter);
        Drawable mDivider = ContextCompat.getDrawable(this, R.drawable.divider);
       DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
       dividerItemDecoration.setDrawable(mDivider);
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

}
