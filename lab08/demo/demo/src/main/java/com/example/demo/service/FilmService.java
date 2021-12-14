package com.example.demo.service;

import com.example.demo.contract.DiscoveryTheMovieDbDTO;
import com.example.demo.contract.FilmDTO;
import com.example.demo.contract.IMDBMovieDto;
import com.example.demo.contract.MovieDto;
import com.example.demo.handlers.ActorsHandler;
import com.example.demo.handlers.Handler;
import com.example.demo.model.Film;
import com.example.demo.quartz.ScheduleInfo;
import com.example.demo.quartz.UpdateDB;
import com.example.demo.repository.ActorRepository;
import com.example.demo.repository.FilmRepository;
import com.example.demo.status.SystemStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Service
public class FilmService {
    private ModelMapper modelMapper;
    RestTemplate rest;
    ActorRepository actorRepository;
    FilmRepository filmRepository;
    ActorService actorService;
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(FilmService.class));
    FileHandler fh;
    private final SystemStatus systemStatus;
    private final ScheduleService scheduler;

    @Autowired
    public FilmService(RestTemplate rest, ActorRepository actorRepository, SystemStatus systemStatusInfo, ScheduleService scheduler) throws IOException {
        fh = new FileHandler("Log.txt", true);
        LOGGER.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        LOGGER.info("Logger started working");

        this.rest = rest;
        this.actorRepository = actorRepository;
        this.systemStatus = systemStatusInfo;
        this.scheduler = scheduler;
    }

    public void startUpdate(int year){
        DiscoveryTheMovieDbDTO discovery;
        SystemStatus status = SystemStatus.getInstance();
        FilmDTO filmDTO = new FilmDTO();

        for(int selectedYear = year; selectedYear <= Calendar.getInstance().get(Calendar.YEAR); selectedYear++){
            discovery = getMovies(selectedYear, 1);
            status.setMoviesToUptade(status.getMoviesToUptade() + discovery.getTotal_pages());
            for (int selectedPage = 1; selectedPage <= discovery.getTotal_pages();selectedPage++){
                for (var result : discovery.getResults()){
                    var movieDbDTO = getMovieFromTheMovieDb(result.getId());
                    var IMDBdto = getMovieFromIMDB(movieDbDTO.getImdbId());
                    BeanUtils.copyProperties(movieDbDTO, filmDTO);
                    BeanUtils.copyProperties(IMDBdto, filmDTO);
                }
            }
        }
    }

    public MovieDto getMovieFromTheMovieDb(int id){
        return rest.getForEntity(
                "https://api.themoviedb.org/3/movie/" +
                        id +
                        "?api_key=" + System.getenv("TheMovieDbApiKey"), MovieDto.class).getBody();
    }

    public IMDBMovieDto getMovieFromIMDB(String imdb_id){
        return rest.getForEntity( "http://www.omdbapi.com/?i=" + imdb_id + "&apikey=" + System.getenv("TheOMBdAPIkey"), IMDBMovieDto.class).getBody();
    }

    public DiscoveryTheMovieDbDTO getMovies(int year, int page){
        return rest.getForEntity("https://api.themoviedb.org/3/discover/movie"+ "?api_key=" + System.getenv("TheMovieDbApiKey") + "&sort_by=popularity.desc" +
                "&page=" + page +
                "&primary_release_year=" + year, DiscoveryTheMovieDbDTO.class).getBody();
    }

}
