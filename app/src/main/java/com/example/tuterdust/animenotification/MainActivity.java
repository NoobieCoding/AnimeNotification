package com.example.tuterdust.animenotification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private ListView view;
    private MainPresenter mp;
    private AnimeRepository ar;
    private List<Anime> animes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ar = MockUpAnimes.getInstance();
        ArrayList<Anime> aList = getIntent().getParcelableArrayListExtra("list");
        mp = new MainPresenter(this, ar);
        mp.setAddedAnimes(aList);
    }

    public void search(View view) {
        EditText editText = (EditText) findViewById(R.id.search_input);
        String keyword = editText.getText().toString();
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        intent.putExtra("keyword", keyword);
        intent.putParcelableArrayListExtra("list", mp.getAddedAnimes());
        MainActivity.this.startActivity(intent);
    }

    public void goUserActivity(View view) {
        Intent intent = new Intent(MainActivity.this, UserActivity.class);
        intent.putParcelableArrayListExtra("list", mp.getAddedAnimes());
        MainActivity.this.startActivity(intent);
    }

    public void setListview(List<Anime> animes, Presenter pr) {
        view = (ListView) findViewById(R.id.listview);
        this.animes = animes;
        ArrayAdapter<Anime> adapter = new AnimeAdapter(this, animes, pr);
        view.setAdapter(adapter);
    }
}
