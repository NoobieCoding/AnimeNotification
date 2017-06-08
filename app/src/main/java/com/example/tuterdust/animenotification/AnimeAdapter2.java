package com.example.tuterdust.animenotification;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by tuterdust on 2/6/2560.
 */

public class AnimeAdapter2 extends ArrayAdapter<Anime> {

    public UserPresenter presenter;

    static class ViewHolder {
        public ImageView img;
        public TextView name;
        public Button turnButton;
        public TextView status;
    }

    public AnimeAdapter2(Context context, List<Anime> animes, UserPresenter pr) {
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
            convertView = inflater.inflate(R.layout.anime_view2, parent, false);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.turnButton = (Button) convertView.findViewById(R.id.turnButton);
            viewHolder.status = (TextView) convertView.findViewById(R.id.status);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(anime.getName());
        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.turnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean status = presenter.turn(anime);
                if (status)
                    finalViewHolder.status.setText("Notification: on");
                else
                    finalViewHolder.status.setText("Notification: off");
            }
        });
        // Lookup view for data population
        // Populate the data into the template view using the data object
        Picasso.with(getContext()).load(Uri.parse(anime.getUrl())).into(viewHolder.img);
        // Return the completed view to render on screen
        return convertView;
    }
}


