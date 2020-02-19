/*
 Copyright 1995-2017 Esri
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 For additional information, contact:
 Environmental Systems Research Institute, Inc.
 Attn: Contracts Dept
 380 New York Street
 Redlands, California, USA 92373
 email: contracts@esri.com
 */

package com.esri.core.geometry;

import junit.framework.TestCase;
import big.brain.CoverageTool;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.esri.core.geometry.ogc.OGCGeometry;

@RunWith(JUnit4.class)
public class TestEnvelope2D extends TestCase {

    @AfterClass
    public static void afterAllTests() {
        System.out.println("afterAllTests");
        CoverageTool.printCoverageResults();
    }


    // Here we want to test when p.x = e.xmax
    @Test
    public void testXmaxEqualsPx(){
        Envelope2D envelope = new Envelope2D();
        envelope.xmin = 14; envelope.xmax = 21;
        envelope.ymin = 1; envelope.ymax = 7;

        Point2D point = new Point2D();
        point.y = 13;
        point.x = 21;

        assertEquals(7.0, envelope._boundaryDistance(point));
        //System.out.println(e._boundaryDistance(p));
    }

    // Here we want to test when p.y = e.ymax
    @Test
    public void testYmaxEqualsPy(){
        Envelope2D envelope = new Envelope2D();
        envelope.xmin = 14; envelope.xmax = 21;
        envelope.ymin = 1; envelope.ymax = 7;

        Point2D point = new Point2D();
        point.y = 7;
        point.x = 25;

        assertEquals(17.0, envelope._boundaryDistance(point));
        //System.out.println(envelope._boundaryDistance(point));
    }

    // Here we want to test when p.x = e.xmin
    @Test
    public void testXminEqualsPx(){
        Envelope2D envelope = new Envelope2D();
        envelope.xmin = 14; envelope.xmax = 21;
        envelope.ymin = 1; envelope.ymax = 7;

        Point2D point = new Point2D();
        point.y = 9;
        point.x = 14;

        assertEquals(8.0, envelope._boundaryDistance(point));
        //System.out.println(envelope._boundaryDistance(point));
    }

    // Here we want to test when p.y = e.ymin
    @Test
    public void testYminEqualsPy(){
        Envelope2D envelope = new Envelope2D();
        envelope.xmin = 14; envelope.xmax = 21;
        envelope.ymin = 1; envelope.ymax = 7;

        Point2D point = new Point2D();
        point.y = 1;
        point.x = 16;

        assertEquals(24.0, envelope._boundaryDistance(point));
        //System.out.println(envelope._boundaryDistance(point));
    }

    // Here we want to test when point is undefined
    @Test
    public void testLast(){
        Envelope2D envelope = new Envelope2D();
        envelope.xmin = 14; envelope.xmax = 21;
        envelope.ymin = 1; envelope.ymax = 7;

        Point2D point = new Point2D();

        assertEquals(0.0, envelope._boundaryDistance(point));
        //System.out.println(envelope._boundaryDistance(point));
    }


}