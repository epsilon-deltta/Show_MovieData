package com.example.devilshot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
//test+in github
public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<MovieData> movieDataList= new ArrayList<MovieData>();
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeMovieData();
        myAdapter = new MyAdapter(this,movieDataList);

        listView    =(ListView)findViewById(R.id.listView);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(itemClickListener);

    }
    AdapterView.OnItemClickListener itemClickListener =new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView parent, View v, int position, long id){
            Toast.makeText(getApplicationContext(), myAdapter.getItem(position).getTittle(), Toast.LENGTH_LONG).show();
        }
    };
    public void InitializeMovieData()
    {
        new Scracher(movieDataList);
    }
}
