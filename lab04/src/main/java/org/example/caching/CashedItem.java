package org.example.caching;

import java.time.Instant;

public class CashedItem {
    // Time to invalidate item given in seconds
    private static final int DEFAULT_INVALIDATE_AFTER = 60 * 60 * 24;
    private final Instant validUntil = Instant.now().plusSeconds(DEFAULT_INVALIDATE_AFTER);
    private Object value;

    public CashedItem(final Object value) {
        this.value = value;
    }

    public Object getValue() {
        if (Instant.now().isAfter(validUntil)) {
            value = null;
        }

        return value;
    }
}
