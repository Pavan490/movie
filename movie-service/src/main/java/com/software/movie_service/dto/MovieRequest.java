package com.software.movie_service.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class MovieRequest {
    private String movieName;
    private String movieDescription;
    private String director;
    private List<String> actors=new ArrayList<>();
}
