package com.ironyard.controller;

import com.ironyard.dto.Page;
import com.ironyard.dto.Movie;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Raul on 10/28/16.
 */
@RestController
public class MovieController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/service/movies", method = RequestMethod.GET)
    public Iterable<Page> list(@RequestParam(value = "Page number", required = true) int page_number,
                               @RequestParam(value = "filter", required = false) String filter) {

        log.debug("Request to list movies started.");
        RestTemplate restTemplate = new RestTemplate();
        Page movies = restTemplate.getForObject("https://api.themoviedb.org/3/movie/now_playing?api_key=e0962a8ec3d01a8f03e49bdc15a344ad&language=en-US&page=" + page_number, Page.class);
        log.info(movies.toString());
        log.debug("Fetch movie complete.");
        List<Page> foundAllList = Arrays.asList(movies);
        List<Page> filteredList = new ArrayList<>();
        List<Movie> res = new ArrayList<>();
        if (filter != null) {
            // filter the list
                for (Movie aMovie : foundAllList.get(0).getResults()) {
                    if (aMovie.getTitle().startsWith(filter)) {
                        res.add(aMovie);
                    }
                }
            Page mv = new Page();
            mv.setResults(res);
            filteredList.add(mv);
        }

        else {
           filteredList = foundAllList;
        }

        return filteredList;


        }
    }
