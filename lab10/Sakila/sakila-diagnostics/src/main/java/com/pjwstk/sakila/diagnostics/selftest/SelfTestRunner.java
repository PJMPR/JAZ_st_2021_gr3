package com.pjwstk.sakila.diagnostics.selftest;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SelfTestRunner {
    List<SelfTest> selfTestList;

    public List<SelftestResult> run(){
        List<SelftestResult> result = new ArrayList<>();
        selfTestList.forEach(selfTest -> result.add(selfTest.execute()));
        return result;
    }
}
