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
    public static void afterTestEnvelope2D() throws Exception {
        CoverageTool.printCoverageResults();
    }

    @Test
    public void testZero() {
        Envelope2D e = new Envelope2D();
        Point2D p = new Point2D();
        e._snapToBoundary(p);
    }

    @Test
    public void testOne(){
        Envelope2D e = new Envelope2D();
        Point2D p = new Point2D();
        p.x = 2;
        e.xmin = 3;
        e.xmax = 4;
        p.y = 5;
        e.ymin = 6;
        e.ymax = 7;
        e._snapToBoundary(p);
    }

    @Test
    public void testTwo(){
        Envelope2D e = new Envelope2D();
        Point2D p = new Point2D();
        p.x = 7;
        e.xmin = 6;
        e.xmax = 5;
        p.y = 4;
        e.ymin = 3;
        e.ymax = 2;
        e._snapToBoundary(p);
    }
}