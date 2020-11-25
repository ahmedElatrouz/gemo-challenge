package com.ahmed.gemochallenge.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubApi {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final Collection<GitRepository> items;

    public GithubApi(Collection<GitRepository> items) {
        this.items = items;
    }

    public GithubApi() {
        items=new ArrayList<>();
    }

    public Collection<GitRepository> getItems() {
        return items;
    }
}


