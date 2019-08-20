package com.materialuiux.databindingexample;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Post extends BaseObservable {

    private String title;
    private String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public String getBody() {
        return body;
    }
}
