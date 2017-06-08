package com.example.tuterdust.animenotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by tuterdust on 4/6/2560.
 */

public class UserPresenter {

    private UserView view;
    private List<Anime> addedAnime;
    private int mInterval = 1000;
    private android.os.Handler mHandler;
    private Context context;


    public UserPresenter(UserView view, List<Anime> addedAnime, Context context) {
        this.view = view;
        this.addedAnime = addedAnime;
        this.context = context;
        setUpListview();
        mHandler = new android.os.Handler();
        startRepeatingTask();
    }

    public void setUpListview() {
        view.setListview(addedAnime, this);
    }

    public boolean turn(Anime anime) {
        if (anime.getNoti() == true) {
            anime.setNoti(false);
            return false;
        } else {
            anime.setNoti(true);
            return true;
        }
    }

    Runnable mStatusChecker = new Runnable() {
        @Override
        public void run() {
            try {
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("EEEE");
                DateFormat timeFormat = new SimpleDateFormat("H.mm");
                String day = dateFormat.format(date);
                String time = timeFormat.format(date);
                for(int i = 0; i < addedAnime.size(); i++) {
                    Anime anime = addedAnime.get(i);
                    if (anime.getNoti()) {
                      if (anime.getDay().equals(day) && anime.getTime().equals(time)) {
                          sendNoti(anime);
                      }
                    }
                }
            } finally {
                mHandler.postDelayed(mStatusChecker, mInterval);
            }
        }

    };

    public void startRepeatingTask() {
        mStatusChecker.run();
    }

    public void sendNoti(Anime anime) {
        NotificationManager notif =(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notify=new Notification.Builder
                (context.getApplicationContext()).setContentTitle(anime.getName()).setContentText("this anime is airing").
                setContentTitle("Aired!").setSmallIcon(R.drawable.light).build();

        notify.flags |= Notification.FLAG_AUTO_CANCEL;
        notif.notify(0, notify);
        anime.setNoti(false);
    }
}
