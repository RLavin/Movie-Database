package com.ironyard.controller;

import com.ironyard.dto.Movie;
import com.ironyard.dto.Results;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Raul on 10/29/16.
 * **/

@Controller
public class MovieJspController {

    @RequestMapping(value = "/movie/titles", method = RequestMethod.GET)
    public String list(@RequestParam(value = "filter", required = false) String filters,
                       Map<String, Object> model) {


        RestTemplate restTemplate = new RestTemplate();
        Movie movies = restTemplate.getForObject("https://api.themoviedb.org/3/movie/now_playing?api_key=e0962a8ec3d01a8f03e49bdc15a344ad&language=en-US&page=1" , Movie.class);


       List<Movie> foundList = Arrays.asList(movies);
       List<Movie> filteredList = new ArrayList<>();
        List<Results> res = new ArrayList<>();
        if (filters != null) {
            // filter the list
            for (Results aResults : foundList.get(0).getResults()) {
                if (aResults.getTitle().startsWith(filters)) {
                    res.add(aResults);
                }

            }
            Movie mv = new Movie();
            mv.setResults(res);
            filteredList.add(mv);
        }

        else {
            filteredList = foundList;
        }

        model.put("movies", filteredList);
        return "movie_list";


    }
}
