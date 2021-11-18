package com.github.electroluxv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SafeInvokerTest {

    @Test
    public void test1() {
        assertEquals(SafeInvoker.INSTANCE, SafeInvoker.INSTANCE, "SafeInvoker is not singleton");
    }
}
