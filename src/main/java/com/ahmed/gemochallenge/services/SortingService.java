package com.ahmed.gemochallenge.services;

import com.ahmed.gemochallenge.entities.GitRepository;
import com.ahmed.gemochallenge.entities.GithubApi;
import com.ahmed.gemochallenge.entities.Language;
import com.ahmed.gemochallenge.resources.ReposResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SortingService {

    @Autowired
    private ReposResource reposResource;

    public List<Language> getSortedLanguages(){
        //getting the data from the resource
        GithubApi githubApi=reposResource.getData();

        //sorting extracting every language with the number of its uses
        List<Language> languages=new ArrayList<>();
        for (GitRepository gr : githubApi.getItems()) {
            //if no language then skip
            if(gr.getLanguage()==null)
                continue;

            //else create a language object (language, numberOfUses)
            Language aLanguage=new Language(gr.getLanguage(),Collections.frequency(githubApi.getItems(),gr));
            if(languages.contains(aLanguage))
                continue;

            languages.add(aLanguage);
        }
        //sorting the languages according to the number Of Uses, using the compareTo() methode
        Collections.sort(languages);

        return languages;
    }

}
