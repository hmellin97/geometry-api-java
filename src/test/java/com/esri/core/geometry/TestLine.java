package com.esri.core.geometry;

import org.junit.Test;

import static com.esri.core.geometry.Line._intersectLineLine;
import static org.junit.Assert.*;

public class TestLine {
    /**
     * 2. There are no tests for the function _intersectLineLine when the argument intersectingPoint is not null
     * a. We have to test that if the two lines are the same the 1st and 2nd element of intersctionPoint are res-
     *     pectively the point of start of the line and the point of end.
     * b. We have to check that if the two lines have the same start point the second element in  intersctionPoint
     *      is the point of end of the second line
     * c. We have to check that if the two lines have the same end point the first element in  intersctionPoint
     *      is the point of start of the first line (not the second because at the end a swap should happens)
     *
     * 3. This is too hard to expand on existing tests because the function tested is called via 10 other functions
     *      so it is really hard to have control on the arguments
     */

    @Test
    public void test_interOf2SameLine_NotNullIntersectionPoint() {
        double [] param1 = new double[15];
        double [] param2 = new double[15];
        double x_start = 0, y_start = -1, x_end = 2, y_end = -2;
        double tolerance = 0.0001;
        Point2D [] intersectiongPoints = new Point2D[10];
        Line line1 = new Line(x_start, y_start, x_end, y_end);
        Line line2 = new Line(x_start, y_start, x_end, y_end);
        int r = _intersectLineLine(line1,line2, intersectiongPoints, param1, param2, tolerance);
        assertTrue(intersectiongPoints[0].isEqual(x_start,y_start));
        assertTrue(intersectiongPoints[1].isEqual(x_end,y_end));
    }

    @Test
    public void test_interOf2SameStart_NotNullIntersectionPoint() {
        double [] param1 = new double[15];
        double [] param2 = new double[15];
        double x_start = 25.64954283965118, y_start = -31.734133611649398;
        double tolerance = 2.318145675417327E-11;
        Point2D [] intersectiongPoints = new Point2D[10];
        Line line1 = new Line(x_start, y_start, 24.999999999999996, -31.20106757941305);
        Line line2 = new Line(x_start, y_start, 23.62616739599725, -30.07359229915909);
        int r = _intersectLineLine(line1,line2, intersectiongPoints, param1, param2, tolerance);
        assertTrue(intersectiongPoints[1].isEqual(23.62616739599725,-30.07359229915909));
    }

    @Test
    public void test_interOf2SameEnd_NotNullIntersectionPoint() {
        double [] param1 = new double[15];
        double [] param2 = new double[15];
        double x_end = 25.64954283965118, y_end = -31.734133611649398;
        double tolerance = 2.318145675417327E-11;
        Point2D [] intersectiongPoints = new Point2D[10];
        Line line1 = new Line(24.999999999999996, -31.20106757941305, x_end, y_end);
        Line line2 = new Line(23.62616739599725, -30.07359229915909,  x_end, y_end);
        int r = _intersectLineLine(line1,line2, intersectiongPoints, param1, param2, tolerance);
        assertTrue(intersectiongPoints[0].isEqual(24.999999999999996,-31.20106757941305));
    }

}