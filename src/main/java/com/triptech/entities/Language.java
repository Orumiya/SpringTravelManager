package com.triptech.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Language {
    @Id
    private String lang;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
