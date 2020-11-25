package com.ahmed.gemochallenge.controllers;


import com.ahmed.gemochallenge.entities.GitRepository;
import com.ahmed.gemochallenge.entities.Language;
import com.ahmed.gemochallenge.resources.ReposResource;
import com.ahmed.gemochallenge.services.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@RestController
@RequestMapping("/repos")
public class ReposController{

    @Autowired
    private SortingService sortingService;
    @Autowired
    private ReposResource reposResource;

        @GetMapping("/languages/top100")
        public List<Language> getSortedLanguages(){
            return sortingService.getSortedLanguages();
        }
        @GetMapping("")
        public Collection<GitRepository> getrepos(){
            return reposResource.getData().getItems();
        }
}
