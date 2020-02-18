package com.esri.core.geometry;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestSegmentIntersector {

    @Test(expected = GeometryException.class)
    public void test_intersect_throwException() {
        SegmentIntersector sI = new SegmentIntersector();
        final double tolerance = 0.00001;
        sI.intersect(tolerance, true);
    }

    @Test(expected = GeometryException.class)
    public void test_intersect_notLine() {
        SegmentIntersector sI = new SegmentIntersector();
        sI.pushSegment(new Segment() {
            @Override
            double _calculateArea2DHelper(double xorg, double yorg) {
                return 0;
            }

            @Override
            public void getCoord2D(double t, Point2D dst) {

            }

            @Override
            public double getClosestCoordinate(Point2D inputPoint, boolean bExtrapolate) {
                return 0;
            }

            @Override
            int getYMonotonicParts(SegmentBuffer[] monotonicSegments) {
                return 0;
            }

            @Override
            public int intersectionWithAxis2D(boolean bAxisX, double ordinate, double[] resultOrdinates, double[] parameters) {
                return 0;
            }

            @Override
            boolean isDegenerate(double tolerance) {
                return false;
            }

            @Override
            boolean isCurve() {
                return false;
            }

            @Override
            Point2D _getTangent(double t) {
                return null;
            }

            @Override
            boolean _isDegenerate(double tolerance) {
                return false;
            }

            @Override
            void _copyToImpl(Segment dst) {

            }

            @Override
            public Segment cut(double t1, double t2) {
                return null;
            }

            @Override
            void cut(double t1, double t2, SegmentBuffer subSegmentBuffer) {

            }

            @Override
            public double getAttributeAsDbl(double t, int semantics, int ordinate) {
                return 0;
            }

            @Override
            boolean _isIntersectingPoint(Point2D pt, double tolerance, boolean bExcludeExactEndpoints) {
                return false;
            }

            @Override
            double intersectionOfYMonotonicWithAxisX(double y, double xParallel) {
                return 0;
            }

            @Override
            double tToLength(double t) {
                return 0;
            }

            @Override
            double lengthToT(double len) {
                return 0;
            }

            @Override
            public Type getType() {
                return null;
            }

            @Override
            public long estimateMemorySize() {
                return 0;
            }

            @Override
            public void queryEnvelope(Envelope env) {

            }

            @Override
            public void queryEnvelope2D(Envelope2D env) {

            }

            @Override
            void queryEnvelope3D(Envelope3D env) {

            }

            @Override
            public void applyTransformation(Transformation2D transform) {

            }

            @Override
            void applyTransformation(Transformation3D transform) {

            }

            @Override
            public Geometry createInstance() {
                return null;
            }

            @Override
            public void replaceNaNs(int semantics, double value) {

            }
        });
        final double tolerance = 0.00001;
        sI.intersect(tolerance, true);
    }

}