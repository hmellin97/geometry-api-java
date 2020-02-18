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
import org.junit.Test;

public class TestEnvelope3D extends TestCase {



    @Test
    public void testIsIntersectingTrue() {
        Envelope3D e1 = new Envelope3D();
        Envelope3D e2 = new Envelope3D();
        e1.zmin = 1;
        e1.zmax = 5;
        e1.ymin = 1;
        e1.ymax = 1;
        e1.xmin = 1;
        e1.xmax = 5;

        e2.zmin = 2;
        e2.zmax = 3;
        e2.ymin = 1;
        e2.ymax = 1;
        e2.xmin = 2;
        e2.xmax = 4;
        assertTrue(e1.isIntersecting(e2));
    }

    @Test
    public void testIsIntersectingFalse() {
        Envelope3D e1 = new Envelope3D();
        Envelope3D e2 = new Envelope3D();
        e1.zmin = 1;
        e1.zmax = 5;
        e1.ymin = 1;
        e1.ymax = 1;
        e1.xmin = 1;
        e1.xmax = 5;

        e2.zmin = 5;
        e2.zmax = 10;
        e2.ymin = 5;
        e2.ymax = 6;
        e2.xmin = 1;
        e2.xmax = 10;
        assertFalse(e1.isIntersecting(e2));
    }
}