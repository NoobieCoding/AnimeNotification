package com.example.tuterdust.animenotification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuterdust on 3/6/2560.
 */

public class SearchPresenter implements Presenter {

    private SearchView view;
    private AnimeRepository ar;
    private List<Anime> animes;
    private List<Anime> addedAnimes = new ArrayList<>();
    private String keyword;

    public SearchPresenter(SearchView view, AnimeRepository ar, String keyword) {
        this.view = view;
        this.ar = ar;
        this.keyword = keyword;
        animes = ar.getAnimes();
        setUpListview();
    }

    public void setUpListview() {
        List<Anime> filteredAnimes = new ArrayList<>();
        filteredAnimes = searchFromKeyword();
        view.setListview(filteredAnimes, this);
    }

    public List<Anime> searchFromKeyword(){
        List<Anime> outList = new ArrayList<>();
        for (int i = 0; i < animes.size(); i++) {
            Anime currAnime = animes.get(i);
            if (currAnime.getName().contains(keyword))
                outList.add(currAnime);
        }
        return outList;
    }

    public ArrayList<Anime> getAddedAnimes() {
        return (ArrayList) addedAnimes;
    }

    public void setAddedAnimes(List<Anime> newAdded) {
        if(newAdded != null)
            addedAnimes = newAdded;
    }

    @Override
    public void addAnime(Anime anime) {
        addedAnimes.add(anime);
    }
}
