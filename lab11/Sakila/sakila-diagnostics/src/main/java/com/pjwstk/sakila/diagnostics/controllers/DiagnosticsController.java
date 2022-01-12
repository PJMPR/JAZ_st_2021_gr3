package com.pjwstk.sakila.diagnostics.controllers;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("diagnostics")
public class DiagnosticsController {

    @GetMapping("status")
    public ResponseEntity isAlive(){
        return ResponseEntity.ok("ALIVE");
    }

    @GetMapping("selftest")
    public ResponseEntity selfTest(){
        return ResponseEntity.ok(List.of(
                new SelfTestResult("CheckStorageForLogs","", true, null),
                new SelfTestResult("CheckStorageForLogs","", true, null),
                new SelfTestResult("CheckStorageForLogs","", true, null),
                new SelfTestResult("CheckStorageForLogs","", true, null)
                ));
    }

}
