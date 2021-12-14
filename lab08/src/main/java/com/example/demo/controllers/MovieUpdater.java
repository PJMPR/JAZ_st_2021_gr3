package com.example.demo.controllers;

import com.example.demo.services.ActorService;
import com.example.demo.services.Status;
import com.example.demo.services.UpdaterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("updater")
@AllArgsConstructor
public class MovieUpdater {
    UpdaterService updaterService;
    ActorService actorService;

    @GetMapping(value = "/reload?year={year}")
    @ResponseBody
    public ResponseEntity<?> getUpdate(@RequestParam(defaultValue = "1980", value = "year", required = false) String year) {
        Status.getInstance().setStartStatus();
        updaterService.startUpdate(Integer.parseInt(year));
        Status.getInstance().setEndStatus();
        return ResponseEntity.ok(Status.getInstance());
    }


    @GetMapping("/status")
    public ResponseEntity<?> getStatus() {
        return ResponseEntity.ok(Status.getInstance());
    }
}