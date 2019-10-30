package com.example.zoy.firebasereal;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class my_activity extends AppCompatActivity {


    ListView listViewArtists;

    //our database reference object
    DatabaseReference databaseArtists;

    SearchView searchView;

    private Query_Adapter2 adapter;
    List<Query_class> queryclasses;
    EditText editsearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity);

        //getting the reference of queryclasses node
        databaseArtists = FirebaseDatabase.getInstance().getReference("Students");

        //getting views
        listViewArtists = (ListView) findViewById(R.id.listViewArtists);

        editsearch = (EditText) findViewById(R.id.search);

        queryclasses = new ArrayList<>();
        adapter = new Query_Adapter2(this, queryclasses);
        listViewArtists.setAdapter(adapter);


      //  listViewArtists.setEmptyView(imageView);


        //list to store queryclasses
               databaseArtists.addListenerForSingleValueEvent(valueEventListener);

        listViewArtists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Query_class queryclass = queryclasses.get(i);

                Intent intent = new Intent(getApplicationContext(), my_activity.class);

                startActivity(intent);
            }
        });
       // emptytext.setText("kjnbkj"+\n"kjb");


        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }


        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                queryclasses.clear();
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Query_class queryclass = snapshot.getValue(Query_class.class);
                        queryclasses.add(queryclass);

                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };


}