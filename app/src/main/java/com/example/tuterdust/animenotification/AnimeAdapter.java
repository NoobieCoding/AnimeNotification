package com.example.tuterdust.animenotification;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by tuterdust on 2/6/2560.
 */

public class AnimeAdapter extends ArrayAdapter<Anime> {

    public Presenter presenter;

    static class ViewHolder {
        public ImageView img;
        public ImageButton addButton;
        public TextView name;
    }

    public AnimeAdapter(Context context, List<Anime> animes, Presenter pr) {
        super(context, 0, animes);
        presenter = pr;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ViewHolder viewHolder = new ViewHolder();
        final Anime anime = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.anime_view, parent, false);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.addButton = (ImageButton) convertView.findViewById(R.id.add_button);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(anime.getName());
        viewHolder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addAnime(anime);
            }
        });
        // Lookup view for data population
        // Populate the data into the template view using the data object
        Picasso.with(getContext()).load(Uri.parse(anime.getUrl())).into(viewHolder.img);
        // Return the completed view to render on screen
        return convertView;
    }
}


