package com.example.tuterdust.animenotification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchView{

    private ListView view;
    private SearchPresenter sp;
    private AnimeRepository ar;
    private String keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ar = MockUpAnimes.getInstance();
        keyword = getIntent().getStringExtra("keyword");
        ArrayList<Anime> aList = getIntent().getParcelableArrayListExtra("list");
        sp = new SearchPresenter(this, ar, keyword);
        sp.setAddedAnimes(aList);
    }

    public void onBackPressed() {
        Intent intent = new Intent(SearchActivity.this, MainActivity.class);
        intent.putParcelableArrayListExtra("list", sp.getAddedAnimes());
        SearchActivity.this.startActivity(intent);
    }

    @Override
    public void setListview(List<Anime> animes, Presenter pr) {
        view = (ListView) findViewById(R.id.search_listview);
        ArrayAdapter<Anime> adapter = new AnimeAdapter(this, animes, pr);
        view.setAdapter(adapter);
    }
}
