package com.triptech.entities;

import javax.persistence.Entity;

@Entity
public class Language {
    private String lang;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
