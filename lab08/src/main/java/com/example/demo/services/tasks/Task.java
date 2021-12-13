package com.example.demo.services.tasks;

import com.example.demo.repositories.BulkRepository;
import com.example.demo.services.ExternalAPIFetcher;
import com.example.demo.services.TaskSummary;

interface TaskBody {
    void execute(ExternalAPIFetcher fetcher, BulkRepository repository);
}

public enum Task {
    REFRESH_ACTORS("refresh actors", (fetcher, repository) -> repository.actorRepository().saveAll(fetcher.fetchActors())),
    REFRESH_FILMS("refresh films", (fetcher, repository) -> repository.filmRepository().saveAll(fetcher.fetchFilms())),
    REFRESH_LANGUAGES("refresh languages", (fetcher, repository) -> repository.languageRepository().saveAll(fetcher.fetchLanguages())),
    REFRESH_CATEGORY("refresh categories", (fetcher, repository) -> repository.categoryRepository().saveAll(fetcher.fetchCategories()));

    final TaskBody body;
    final String name;
    Task(String name, TaskBody body) {
        this.name = name;
        this.body = body;
    }

    public TaskSummary execute(ExternalAPIFetcher fetcher, BulkRepository repository) {
        long start = System.nanoTime();
        body.execute(fetcher, repository);
        long execution = System.nanoTime() - start;

        return new TaskSummary(name, Runtime.getRuntime().totalMemory(), execution);
    }
}
