package com.ahmed.gemochallenge.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepository implements Comparable<GitRepository>{

    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitRepository that = (GitRepository) o;
        return language.equals(that.language);
    }


    @Override
    public int compareTo(GitRepository o) {
        return this.getLanguage().compareTo(o.getLanguage());
    }
}
