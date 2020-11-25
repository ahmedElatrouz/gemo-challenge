package com.ahmed.gemochallenge.entities;

import java.util.Objects;

public class Language implements Comparable<Language> {
    private String language;
    private int numberOfUses;

    public Language(String language, int numberOfUses) {
        this.language = language;
        this.numberOfUses = numberOfUses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language1 = (Language) o;
        return language.equals(language1.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberOfUses() {
        return numberOfUses;
    }

    public void setNumberOfUses(int numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

    @Override
    public int compareTo(Language o) {
        return o.getNumberOfUses()-this.getNumberOfUses();
    }
}
