package com.arifrizkihidayat.moviecatalogue.data.source.remote.response.tvshowsresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.Setter;

public class NetworkResponse {

    @SerializedName("name")
    @Expose
    @Getter @Setter
    private String name;
    @SerializedName("id")
    @Expose
    @Getter @Setter
    private Integer id;
    @SerializedName("logo_path")
    @Expose
    @Getter @Setter
    private String logoPath;
    @SerializedName("origin_country")
    @Expose
    @Getter @Setter
    private String originCountry;

    public NetworkResponse() {
    }

    @NotNull
    @Override
    public String toString() {
        return "NetworkResponse{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", logoPath='" + logoPath + '\'' +
                ", originCountry='" + originCountry + '\'' +
                '}';
    }
}
