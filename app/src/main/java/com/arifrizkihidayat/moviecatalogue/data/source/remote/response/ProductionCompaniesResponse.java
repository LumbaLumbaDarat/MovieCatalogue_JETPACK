package com.arifrizkihidayat.moviecatalogue.data.source.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.Setter;

public class ProductionCompaniesResponse {

    @SerializedName("id")
    @Expose
    @Getter @Setter
    private Integer id;
    @SerializedName("logo_path")
    @Expose
    @Getter @Setter
    private Object logoPath;
    @SerializedName("name")
    @Expose
    @Getter @Setter
    private String name;
    @SerializedName("origin_country")
    @Expose
    @Getter @Setter
    private String originCountry;

    public ProductionCompaniesResponse() {
    }

    @NotNull
    @Override
    public String toString() {
        return "ProductionCompaniesResponse{" +
                "id=" + id +
                ", logoPath=" + logoPath +
                ", name='" + name + '\'' +
                ", originCountry='" + originCountry + '\'' +
                '}';
    }
}
