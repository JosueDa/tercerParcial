package com.example.tercerparcial.bean;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("title")
    public String mTitle;
    @SerializedName("imageURL")
    public String mImageUrl;
    @SerializedName("author")
    public String mAuthor;
}
