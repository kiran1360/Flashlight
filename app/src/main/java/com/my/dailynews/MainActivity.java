package com.my.dailynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.my.dailynews.Adapter.NewsAdapter;
import com.my.dailynews.Model.NewsApi;
import com.my.dailynews.Model.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RetrofitRequest retrofitRequest=new RetrofitRequest(this);
        retrofitRequest.getDataHead(listener,"general",null);
    }
    private  final OnDataFetch<NewsApi> listener =new OnDataFetch<NewsApi>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {
            show(list);
        }

        @Override
        public void OnError(String message) {

        }
    };

    private void show(List<NewsHeadlines> list) {
        recyclerView=findViewById(R.id.recyleRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter=new NewsAdapter(this,list);
        recyclerView.setAdapter(adapter);
       /* NewsAdapter adapter=new NewsAdapter(this,list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);*/


    }
}