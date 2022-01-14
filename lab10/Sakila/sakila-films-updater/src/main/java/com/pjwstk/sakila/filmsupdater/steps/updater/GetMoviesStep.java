package com.pjwstk.sakila.filmsupdater.steps.updater;

import com.pjwstk.sakila.data.repositories.IDbContext;
import com.pjwstk.sakila.filmsupdater.steps.ProcessStepBase;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.Discover;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

@Service
public class GetMoviesStep extends ProcessStepBase {

    public GetMoviesStep(TmdbApi moviesClient, IDbContext dbContext, MapLanguages nextStep) {
        super(moviesClient, dbContext);
        super.nextStep = nextStep;
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    @Override
    protected void doAction() {
        var movies = super.moviesClient
                .getDiscover()
                .getDiscover(
                        new Discover()
                                .page(1)
                                .releaseDateGte(
                                        new SimpleDateFormat("yyyy-MM-dd")
                                                .format(context.getDateRange().getStart()))
                                .releaseDateLte(new SimpleDateFormat("yyyy-MM-dd")
                                        .format(context.getDateRange().getEnd())));
        context.setMoviesFromService(movies.getResults());
        var cast =movies.getResults().stream().flatMap(x->x.getCast().stream()).collect(Collectors.toList());
        var languages = movies.getResults().stream().map(x->x.getOriginalLanguage()).collect(Collectors.toList());
        var categories = movies.getResults().stream().flatMap(x->x.getGenres().stream().map(y->y.getName())).collect(Collectors.toList());
        context.setCast(cast);
        context.setCategories(categories);
        context.setLanguages(languages);
    }
}
