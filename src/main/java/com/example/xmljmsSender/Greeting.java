package com.example.xmljmsSender;

import java.util.ArrayList;
import java.util.List;

public class Greeting {

    private long id;
    private String content;
    private List<String> listContent = new ArrayList<>();

    public List<String> getListContent() {
        return listContent;
    }

    public void setListContent(List<String> listContent) {
        this.listContent = listContent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}