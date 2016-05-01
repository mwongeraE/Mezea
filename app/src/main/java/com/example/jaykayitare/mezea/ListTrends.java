package com.example.jaykayitare.mezea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListTrends extends AppCompatActivity {

    String[] trends = {"robbery", "riot", "carjack", "violence", "crime", "murder",  "rape"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_trends);

        ListView list = (ListView)findViewById(R.id.listTrends);
        if (list != null) {
            list.setBackgroundColor(getResources().getColor(R.color.orange));
        }
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, trends);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent goToMaps = new Intent(getApplicationContext(),LocationFeed.class);
                startActivity(goToMaps);
            }
        });
    }
}
