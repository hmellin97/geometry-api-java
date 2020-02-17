package com.esri.core.geometry;

import big.brain.CoverageTool;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TestEnvelope2D {
    @AfterClass
    public static void afterAllTests() {
        System.out.println("afterAllTests");
        CoverageTool.printCoverageResults();
    }
    @Test
    public void testClipLine(){
        // 0 - the segment is outside of the clipping window
        Envelope2D envelope2D = new Envelope2D();
        assertEquals(0, envelope2D.clipLine(new Point2D(), new Point2D(), 0, new double[]{0, 0, 0}, new double[]{0,0,0}));
    }
}
