package com.pjwstk.sakila.diagnostics.controllers;

import com.pjwstk.sakila.diagnostics.selftest.DiskSpaceSelfTest;
import com.pjwstk.sakila.diagnostics.selftest.SelfTestRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("diagnostics")
public class DiagnosticsController {

    @GetMapping("status")
    public ResponseEntity isAlive(){
        return ResponseEntity.ok("ALIVE");
    }

    @GetMapping("selftest")
    public ResponseEntity selfTest(){
        SelfTestRunner selfTestRunner = new SelfTestRunner();
        selfTestRunner.setSelfTestList(Arrays.asList(new DiskSpaceSelfTest()));
        return ResponseEntity.ok(selfTestRunner.run());
    }

}
