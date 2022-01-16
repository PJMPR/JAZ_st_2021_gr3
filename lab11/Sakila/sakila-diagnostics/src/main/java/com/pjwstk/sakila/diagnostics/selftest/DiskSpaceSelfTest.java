package com.pjwstk.sakila.diagnostics.selftest;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class DiskSpaceSelfTest extends SelfTestBase{
    private static final int REQUIRED_DISK_PERCENTAGE = 5;

    @Override
    public SelfTestResult execute() {
        List<String> errors = new ArrayList<>();
        SelfTestResult results = new SelfTestResult("DiskSpaceSelfTest", "Checks if there is >= 5% disk space left", false, errors);
        File file = new File("/");
        long totalSpace = file.getTotalSpace();
        long usableSpace = file.getUsableSpace();
        long freeSpace = file.getFreeSpace();
        long usedSpace = totalSpace - freeSpace;
        long usedPercentage = (usedSpace * 100) / totalSpace;
        if (usableSpace > REQUIRED_DISK_PERCENTAGE) {
            results.setPassed(true);
            results.getErrors().add("Disk space is ok. Used: " + usedPercentage + "%");
        } else {
            results.getErrors().add("Disk space is low. Used: " + usedPercentage + "%");
        }
        return results;
    }
}

