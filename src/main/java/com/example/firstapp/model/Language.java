package com.example.firstapp.model;

public class Language {
    private String name;
    private int languageId;

    public Language(String name, int languageId) {
        this.name = name;
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

}
