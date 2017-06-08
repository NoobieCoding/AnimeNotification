package com.example.tuterdust.animenotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity implements UserView{

    private UserPresenter up;
    private ListView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ArrayList<Anime> aList = new ArrayList<>();
        aList = getIntent().getParcelableArrayListExtra("list");
        up = new UserPresenter(this, aList, this);
    }

    @Override
    public void setListview(List<Anime> addedanime, UserPresenter pr) {
        view = (ListView) findViewById(R.id.user_listview);
        ArrayAdapter<Anime> adapter = new AnimeAdapter2(this, addedanime, pr);
        view.setAdapter(adapter);
    }


}

