package com.pjwstk.sakila.diagnostics.selftest;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;

public interface SelfTest {
    public SelfTestResult execute();
}