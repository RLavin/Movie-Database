package com.ironyard.controller;

import com.ironyard.dto.Page;
import com.ironyard.dto.Movie;
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
        Page movies = restTemplate.getForObject("https://api.themoviedb.org/3/movie/now_playing?api_key=e0962a8ec3d01a8f03e49bdc15a344ad&language=en-US&page=1" , Page.class);


       List<Page> foundList = Arrays.asList(movies);
       List<Page> filteredList = new ArrayList<>();
        List<Movie> mine = new ArrayList<>();
        if (filters != null) {
            // filter the list
            for (Movie aMovie : foundList.get(0).getResults()) {
                if (aMovie.getTitle().startsWith(filters)) {
                    mine.add(aMovie);
                }

            }
            Page mv = new Page();
            mv.setResults(mine);
            filteredList.add(mv);
        }

        else {
            filteredList = foundList;
        }

        model.put("movies", filteredList.get(0).getResults());
        return "movie_list";


    }
}
