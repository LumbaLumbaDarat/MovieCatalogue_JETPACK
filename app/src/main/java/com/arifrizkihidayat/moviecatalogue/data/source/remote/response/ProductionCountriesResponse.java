package com.arifrizkihidayat.moviecatalogue.data.source.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.Setter;

public class ProductionCountriesResponse {

    @SerializedName("iso_3166_1")
    @Expose
    @Getter @Setter
    private String iso31661;
    @SerializedName("name")
    @Expose
    @Getter @Setter
    private String name;

    public ProductionCountriesResponse() {
    }

    @NotNull
    @Override
    public String toString() {
        return "ProductionCountriesResponse{" +
                "iso31661='" + iso31661 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
