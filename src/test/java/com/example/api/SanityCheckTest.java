package com.example.api;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class SanityCheckTest {
    @Test
    public void sanity() {
        assertTrue(true, "Toolchain is wired correctly.");
    }
}
