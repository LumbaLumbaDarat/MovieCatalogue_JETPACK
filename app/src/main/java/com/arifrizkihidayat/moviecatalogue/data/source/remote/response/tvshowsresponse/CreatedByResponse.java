package com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class CreatedByResponse {

    @SerializedName("id")
    @Expose
    @Getter @Setter
    private Integer id;
    @SerializedName("credit_id")
    @Expose
    @Getter @Setter
    private String creditId;
    @SerializedName("name")
    @Expose
    @Getter @Setter
    private String name;
    @SerializedName("gender")
    @Expose
    @Getter @Setter
    private Integer gender;
    @SerializedName("profile_path")
    @Expose
    @Getter @Setter
    private Object profilePath;

    public CreatedByResponse() {
    }

    @Override
    public String toString() {
        return "CreatedByResponse{" +
                "id=" + id +
                ", creditId='" + creditId + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", profilePath=" + profilePath +
                '}';
    }
}
