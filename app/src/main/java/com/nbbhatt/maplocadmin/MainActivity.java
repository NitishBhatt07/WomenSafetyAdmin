package com.nbbhatt.maplocadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    FirebaseFirestore db;
    ArrayList<model> dataList;
    MyAdapter adapter;

    FloatingActionButton floatingActionButton;

    static int toatalElement;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataList = new ArrayList<>();

        adapter = new MyAdapter(dataList);
        recyclerView.setAdapter(adapter);

        db  = FirebaseFirestore.getInstance();

        db.collection("Users").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                for(DocumentSnapshot d:list){
                    model obj = d.toObject(model.class);
                    dataList.add(obj);
                }
                adapter.notifyDataSetChanged();
            }
        });



        floatingActionButton = findViewById(R.id.floatingActionButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               //Intent i = new Intent(MainActivity.this,LatLongActivity.class);
               Intent i = new Intent(MainActivity.this,Map.class);
               Bundle bundle = new Bundle();
               bundle.putSerializable("LatLongData",dataList);
               i.putExtras(bundle);
               startActivity(i);
            }

        });


    }
}
