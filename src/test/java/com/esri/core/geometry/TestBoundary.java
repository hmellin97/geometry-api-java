package com.esri.core.geometry;

import big.brain.CoverageTool;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class TestBoundary extends TestCase {
    @AfterClass
    public static void afterAllTests() {
        System.out.println("afterAllTests TestWktParser");
        CoverageTool.printCoverageResults();
    }

    /**
     * A point without specified coordinates does not have a non-empty boundary.
     */
    @Test
    public void testEmptyGeometry() {
        Geometry g = new Point();
        assertFalse(Boundary.hasNonEmptyBoundary(g, null));
    }

    /**
     * A polygon without area does not have a non-empty boundary.
     */
    @Test
    public void testPolygonNonEmptyBoundaryNoArea() {
        Polygon g = new Polygon();
        g.startPath(0, 0);
        g.lineTo(1, 1);
        assertFalse(Boundary.hasNonEmptyBoundary(g, null));
    }

    /**
     * A polygon with area has a non-empty boundary.
     */
    @Test
    public void testPolygonNonEmptyBoundaryWithArea() {
        Polygon pg = new Polygon();
        pg.startPath(-130, 10);
        pg.lineTo(-131, 15);
        pg.lineTo(-140, 20);
        assertTrue(Boundary.hasNonEmptyBoundary(pg, null));
    }

    /**
     * A polyline with some paths has a non-empty boundary.
     */
    @Test
    public void testPolylineNonEmptyBoundary() {
        Polyline g = new Polyline();
        g.startPath(0, 0);
        g.lineTo(1, 1);
        assertTrue(Boundary.hasNonEmptyBoundary(g, null));
    }

    /**
     * An envelope with specified coordinates has a non-empty boundary.
     */
    @Test
    public void testEnvelopeNonEmptyBoundary() {
        Envelope g = new Envelope();
        g.setCoords(0, 0, 1, 1);
        assertTrue(Boundary.hasNonEmptyBoundary(g, null));
    }

    /**
     * A point with specified coordinate does not have a non-empty boundary.
     */
    @Test
    public void testPointNonEmptyBoundary() {
        Point g = new Point();
        g.setXY(1, 1);
        assertFalse(Boundary.hasNonEmptyBoundary(g, null));
    }
}
