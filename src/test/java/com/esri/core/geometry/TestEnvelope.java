/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.esri.core.geometry;

import big.brain.CoverageTool;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestEnvelope
{

	@AfterClass
	public static void afterAllTests() {
		System.out.println("afterAllTests");
		CoverageTool.printCoverageResults();
	}


	// Here we test merging a smaller one into a bigger envelope.
	@Test
	public void testMergeOne(){
		Envelope1D envelope = new Envelope1D();
		envelope.vmin = 14; envelope.vmax = 21;

		Envelope1D envelopeOther = new Envelope1D();
		envelopeOther.vmin = 10; envelopeOther.vmax = 22;

		envelope.merge(envelopeOther);

		assertEquals(22.0, envelope.vmax, 0.5);
		assertEquals(10.0, envelope.vmin, 0.5);
		//System.out.println(envelope.vmin);
	}

	// Here we test inserting a faulty envelope.
	@Test
	public void testMergeTwo(){
		Envelope1D envelope = new Envelope1D();
		envelope.vmin = 22; envelope.vmax = 21;

		Envelope1D envelopeOther = new Envelope1D();
		envelopeOther.vmin = 22; envelopeOther.vmax = 21;

		envelope.merge(envelopeOther);

		assertEquals(Double.NaN, envelope.vmax, 0.5);
		assertEquals(Double.NaN, envelope.vmin, 0.5);
		//assertEquals(null, envelope.vmin);
		//System.out.println(envelope.vmin);
	}

	// Here we test merging an empty envelope with a filled one.
	@Test
	public void testMergeThree(){
		Envelope1D envelope = new Envelope1D();
		envelope.vmin = Double.NaN; envelope.vmax = Double.NaN;

		Envelope1D envelopeOther = new Envelope1D();
		envelopeOther.vmin = 21; envelopeOther.vmax = 22;

		envelope.merge(envelopeOther);

		assertEquals(22.0, envelope.vmax, 0.5);
		assertEquals(21.0, envelope.vmin, 0.5);
		//assertEquals(null, envelope.vmin);
		//System.out.println(envelope.vmin);
	}

	// Here we test merging an empty envelope with a filled one.
	@Test
	public void testMergeFour(){
		Envelope1D envelope = new Envelope1D();
		envelope.vmin = 21; envelope.vmax = 22;

		Envelope1D envelopeOther = new Envelope1D();
		envelopeOther.vmin = Double.NaN; envelopeOther.vmax = Double.NaN;

		envelope.merge(envelopeOther);

		assertEquals(22.0, envelope.vmax, 0.5);
		assertEquals(21.0, envelope.vmin, 0.5);
		//assertEquals(null, envelope.vmin);
		//System.out.println(envelope.vmin);
	}




	@Test
	public void testIntersect() {
		assertIntersection(new Envelope(0, 0, 5, 5), new Envelope(0, 0, 5, 5), new Envelope(0, 0, 5, 5));
		assertIntersection(new Envelope(0, 0, 5, 5), new Envelope(1, 1, 6, 6), new Envelope(1, 1, 5, 5));
		assertIntersection(new Envelope(1, 2, 3, 4), new Envelope(0, 0, 2, 3), new Envelope(1, 2, 2, 3));

		assertNoIntersection(new Envelope(), new Envelope());
		assertNoIntersection(new Envelope(0, 0, 5, 5), new Envelope());
		assertNoIntersection(new Envelope(), new Envelope(0, 0, 5, 5));
	}

	@Test
	public void testEquals() {
		Envelope env1 = new Envelope(10, 9, 11, 12);
		Envelope env2 = new Envelope(10, 9, 11, 13);
		Envelope1D emptyInterval = new Envelope1D();
		emptyInterval.setEmpty();
		assertFalse(env1.equals(env2));
		env1.queryInterval(VertexDescription.Semantics.M, 0).equals(emptyInterval);
		env2.setCoords(10, 9, 11, 12);
		assertTrue(env1.equals(env2));
		env1.addAttribute(VertexDescription.Semantics.M);
		env1.queryInterval(VertexDescription.Semantics.M, 0).equals(emptyInterval);
		assertFalse(env1.equals(env2));
		env2.addAttribute(VertexDescription.Semantics.M);
		assertTrue(env1.equals(env2));
		Envelope1D nonEmptyInterval = new Envelope1D();
		nonEmptyInterval.setCoords(1, 2);
		env1.setInterval(VertexDescription.Semantics.M, 0, emptyInterval);
		assertTrue(env1.equals(env2));
		env2.setInterval(VertexDescription.Semantics.M, 0, emptyInterval);
		assertTrue(env1.equals(env2));
		env2.setInterval(VertexDescription.Semantics.M, 0, nonEmptyInterval);
		assertFalse(env1.equals(env2));
		env1.setInterval(VertexDescription.Semantics.M, 0, nonEmptyInterval);
		assertTrue(env1.equals(env2));
		env1.queryInterval(VertexDescription.Semantics.M, 0).equals(nonEmptyInterval);
		env1.queryInterval(VertexDescription.Semantics.POSITION, 0).equals(new Envelope1D(10, 11));
		env1.queryInterval(VertexDescription.Semantics.POSITION, 0).equals(new Envelope1D(9, 13));
	}
	
	private static void assertIntersection(Envelope envelope, Envelope other, Envelope intersection) {
		boolean intersects = envelope.intersect(other);
		assertTrue(intersects);
		assertEquals(envelope, intersection);
	}

	private static void assertNoIntersection(Envelope envelope, Envelope other) {
		boolean intersects = envelope.intersect(other);
		assertFalse(intersects);
		assertTrue(envelope.isEmpty());
	}
	
}

