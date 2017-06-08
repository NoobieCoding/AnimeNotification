package com.example.tuterdust.animenotification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuterdust on 1/6/2560.
 */

public class MainPresenter implements Presenter{

    private MainView view;
    private AnimeRepository ar;
    private List<Anime> animes;
    private List<Anime> addedAnimes = new ArrayList<>();

    public MainPresenter(MainView view, AnimeRepository ar) {
        this.view = view;
        this.ar = ar;
        animes = ar.getAnimes();
        setUpListview();
    }

    public void setUpListview() {
        view.setListview(animes, this);
    }

    public ArrayList<Anime> getAddedAnimes() {
        return (ArrayList) addedAnimes;
    }

    public void setAddedAnimes(List<Anime> newAdded) {
        if (newAdded != null)
            addedAnimes = newAdded;
    }

    public void addAnime(Anime anime) {
        addedAnimes.add(anime);
    }
}
