package com.pjwstk.sakila.diagnostics.controllers;


import com.pjwstk.sakila.diagnostics.selftest.IMDBServiceSelfTest;
import com.pjwstk.sakila.diagnostics.selftest.SakillaDBConnectioSelfTest;
import com.pjwstk.sakila.diagnostics.selftest.SelfTestRunner;
import com.pjwstk.sakila.diagnostics.selftest.TheMovieDbServiceConnectionSelfTest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("diagnostics")
public class DiagnosticsController {

    @GetMapping("status")
    public ResponseEntity status(){
        return ResponseEntity.ok("ALIVE");
    }


    @GetMapping("selftest")
    public ResponseEntity selftest(){
        SelfTestRunner selfTestRunner = new SelfTestRunner();
        selfTestRunner.setSelfTestList(Arrays.asList(
                new IMDBServiceSelfTest(),
                new SakillaDBConnectioSelfTest(),
                new TheMovieDbServiceConnectionSelfTest()));
        return ResponseEntity.ok(selfTestRunner.run());
    }
}
