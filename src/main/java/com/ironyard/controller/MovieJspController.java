package com.ironyard.controller;

import com.ironyard.dto.Page;
import com.ironyard.dto.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Raul on 10/29/16.
 * **/

@Controller
public class MovieJspController {

    @RequestMapping(value = "/movie/titles", method = RequestMethod.GET)
    public String list(Map<String, Object> model) {


        RestTemplate restTemplate = new RestTemplate();
        Page movies = restTemplate.getForObject("https://api.themoviedb.org/3/movie/now_playing?api_key=e0962a8ec3d01a8f03e49bdc15a344ad&language=en-US&page=1" , Page.class);


        model.put("movies", movies.getResults());
        return "movie_list";


    }
}
