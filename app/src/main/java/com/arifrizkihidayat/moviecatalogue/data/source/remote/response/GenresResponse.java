package com.arifrizkihidayat.moviecatalogue.data.source.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import lombok.Getter;
import lombok.Setter;

public class GenresResponse {

    @SerializedName("id")
    @Expose
    @Getter @Setter
    private Integer id;
    @SerializedName("name")
    @Expose
    @Getter @Setter
    private String name;

    public GenresResponse() {
    }

    @NotNull
    @Override
    public String toString() {
        return "GenresResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
