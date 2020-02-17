package com.esri.core.geometry;

import big.brain.CoverageTool;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestEnvelope2D {
    @AfterClass
    public static void afterAllTests() {
        System.out.println("afterAllTests");
        CoverageTool.printCoverageResults();
    }

    @Test
    public void testClipLine(){

    }
}
