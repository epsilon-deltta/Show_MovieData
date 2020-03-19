package com.example.devilshot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
//test
public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<SampleData> movieDataList;
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
            Toast.makeText(getApplicationContext(), myAdapter.getItem(position).getMovieName(), Toast.LENGTH_LONG).show();
        }
    };
    public void InitializeMovieData()
    {
        movieDataList = new ArrayList<SampleData>();

        movieDataList.add(new SampleData(R.drawable.image00, "미션임파서블","15세 이상관람가"));
        movieDataList.add(new SampleData(R.drawable.image01, "아저씨","19세 이상관람가"));
        movieDataList.add(new SampleData(R.drawable.image02, "어벤져스","12세 이상관람가"));
    }
}
