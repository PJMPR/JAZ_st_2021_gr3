package com.pjwstk.sakila.filmsupdater.steps.updater;

import com.pjwstk.sakila.data.model.Language;
import com.pjwstk.sakila.data.repositories.IDbContext;
import com.pjwstk.sakila.filmsupdater.steps.ProcessStepBase;
import info.movito.themoviedbapi.TmdbApi;
import org.springframework.stereotype.Service;

@Service
public class MapLanguages extends ProcessStepBase {
    public MapLanguages(TmdbApi moviesClient, IDbContext dbContext) {
        super(moviesClient, dbContext);
    }

    @Override
    public boolean canExecute() {
        return context.getLanguages().size()>0;
    }

    @Override
    protected void doAction() {


    }
}
