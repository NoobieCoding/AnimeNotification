package com.example.tuterdust.animenotification;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tuterdust on 31/5/2560.
 */

public class Anime implements Parcelable{
    private String name, director, description, day, time, url;
    private List<String> cvs;
    private boolean noti = false;

    public Anime(String name, String director, String description, List<String> cvs, String day, String time, String url) {
        this.name =  name;
        this.director = director;
        this.description = description;
        this.cvs = cvs;;
        this.day = day;
        this.time = time;
        this.url = url;

    }

    protected Anime(Parcel in) {
        name = in.readString();
        director = in.readString();
        description = in.readString();
        day = in.readString();
        time = in.readString();
        url = in.readString();
        cvs = in.createStringArrayList();
        noti = in.readByte() != 0;
    }

    public static final Creator<Anime> CREATOR = new Creator<Anime>() {
        @Override
        public Anime createFromParcel(Parcel in) {
            return new Anime(in);
        }

        @Override
        public Anime[] newArray(int size) {
            return new Anime[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getCvs() {
        return cvs;
    }

    public String getUrl() {
        return url;
    }

    public String getTime() {
        return time;
    }

    public String getDay() {

        return day;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(director);
        dest.writeString(description);
        dest.writeString(day);
        dest.writeString(time);
        dest.writeString(url);
        dest.writeStringList(cvs);
        dest.writeByte((byte) (noti ? 1 : 0));
    }

    public void setNoti(boolean b) {
        this.noti = b;
    }
    public boolean getNoti() {
        return noti;
    }
}
