package com.ahmed.gemochallenge.resources;

import com.ahmed.gemochallenge.entities.GithubApi;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@Service
public class ReposResource {

    private final WebClient webClient;
    private final String url="https://api.github.com/search/repositories";

    public ReposResource(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.codecs(configurer -> configurer
                .defaultCodecs()
                .maxInMemorySize(16 * 1024 * 1024))
                .baseUrl(url)
                .build();
    }

    public GithubApi getData() {
        //creating a date object with yesterdays value (because the api doesn't provide data for the current day)
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        LocalDate date = LocalDate.now().minusDays(1);
        Date yesterday = java.sql.Date.valueOf(date);
        //getting the data from the api
        return this.webClient
                .get()
                .uri("?q=created:>"+df.format(yesterday)+"&sort=stars&order=desc&per_page=100")
                .retrieve()
                .bodyToMono(GithubApi.class)
                .block();
    }
}
