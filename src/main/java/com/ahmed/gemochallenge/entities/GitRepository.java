package com.ahmed.gemochallenge.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepository {
    private String name;
    private String language;
}
