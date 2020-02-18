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
public class TestMultiPathImpl extends TestCase {
    @AfterClass
    public static void afterTestMultiPathImpl() throws Exception {
        CoverageTool.printCoverageResults();
    }

    @Test
    public void testSame() {
        MultiPath m = new MultiPath() {
            @Override
            public Type getType() {
                return Type.Polygon;
            }

            @Override
            public int getDimension() {
                return 3;
            }

            @Override
            public long estimateMemorySize() {
                return 3;
            }
            @Override
            public Geometry createInstance() {
                return new MultiPathImpl(true, getDescription());
            }
        };
        m.startPath(0,0);
        m.lineTo(0,10);
        m.lineTo(20,10);
        m.lineTo(20,0);
        m.insertPath(-1,m,1,true);
    }
}