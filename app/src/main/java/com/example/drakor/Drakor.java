package com.example.drakor;

public class Drakor {
    private String mId, mJudul,mGenre,mEpisode;

    public Drakor(String mId, String mNama, String mJenis, String mEpisode) {
        this.mId = mId;
        this.mJudul = mNama;
        this.mGenre = mJenis;
        this.mEpisode = mEpisode;
    }
    public Drakor(){

    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmNama() {
        return mJudul;
    }

    public void setmNama(String mNama) {
        this.mJudul = mNama;
    }

    public String getmJenis() {
        return mGenre;
    }

    public void setmJenis(String mJenis) {
        this.mGenre = mJenis;
    }

    public String getmEpisode() {
        return mEpisode;
    }

    public void setmEpisode(String mEpisode) {
        this.mEpisode = mEpisode;
    }
}
