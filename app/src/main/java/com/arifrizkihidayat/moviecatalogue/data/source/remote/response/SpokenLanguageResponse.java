package com.arifrizkihidayat.moviecatalogue.data.source.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class SpokenLanguageResponse {

    @SerializedName("english_name")
    @Expose
    @Getter @Setter
    private String englishName;
    @SerializedName("iso_639_1")
    @Expose
    @Getter @Setter
    private String iso6391;
    @SerializedName("name")
    @Expose
    @Getter @Setter
    private String name;

    public SpokenLanguageResponse() {
    }

    @Override
    public String toString() {
        return "SpokenLanguageResponse{" +
                "englishName='" + englishName + '\'' +
                ", iso6391='" + iso6391 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
