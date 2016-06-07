/**
 * Compare Library
 * Copyright © 2016 aksappy (aksappy@gmail.com)
 *
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
package ak.compare.test;

import org.junit.Test;

import ak.compare.StringCompare;
import org.junit.Assert;
import org.junit.Ignore;

public class StringComparisonTests {

	private static final String STRING_2 = "2. Compare properties file and return the differences";
	private static final String STRING_1 = "1. Compare String and return the difference";
	private static final String STRING_1_COPY = STRING_1;
	/*
	 * @Test public void constructorTests(){
	 * 
	 * }
	 */

	@Test
	@Ignore
	public void compareWordsTests() {
		CharSequence compareWords = StringCompare.compareWords(STRING_1, STRING_2);
		Assert.assertNotSame(STRING_1, compareWords);
		CharSequence result = StringCompare.compareWords(STRING_1, STRING_1_COPY);
		Assert.assertEquals(STRING_1, result);

	}

	@Test
	public void compareLetters() {
		long start = System.currentTimeMillis();
		StringCompare.compareLetters(STRING_1, STRING_2);
		System.out.println(System.currentTimeMillis() - start);
	}
}
