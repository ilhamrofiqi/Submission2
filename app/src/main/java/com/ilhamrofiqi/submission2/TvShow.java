package com.ilhamrofiqi.submission2;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private int photo;
    private String title;
    private String genre;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getSynopsi() {
        return synopsi;
    }

    public void setSynopsi(String synopsi) {
        this.synopsi = synopsi;
    }

    private String creator;
    private String year;
    private String runtime;
    private String synopsi;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.title);
        dest.writeString(this.genre);
        dest.writeString(this.creator);
        dest.writeString(this.year);
        dest.writeString(this.runtime);
        dest.writeString(this.synopsi);
    }

    public TvShow() {
    }

    protected TvShow(Parcel in) {
        this.photo = in.readInt();
        this.title = in.readString();
        this.genre = in.readString();
        this.creator = in.readString();
        this.year = in.readString();
        this.runtime = in.readString();
        this.synopsi = in.readString();
    }

    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
