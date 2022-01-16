package com.pjwstk.sakila.diagnostics.selftest;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;

public abstract class SelfTestBase implements SelfTest {
    public String name;
    public String description;

    abstract public SelfTestResult execute();
}
