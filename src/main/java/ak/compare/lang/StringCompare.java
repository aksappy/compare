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
/**
 * <p>StringCompare class.</p><br />
 * <p>This class contains the methods to compare Strings in various ways</p>
 *
 * @author aksappy
 * @version 0.0.1
 */
package ak.compare.lang;

import ak.compare.constants.CharConstants;

public class StringCompare implements CharConstants {

	/**
	 * Comparison of two input string, character by character. <br />
	 * <p>
	 * The output is in a console centric format, by default
	 * <p>
	 *
	 * @param s1
	 *            a {@link java.lang.CharSequence} object.
	 * @param s2
	 *            a {@link java.lang.CharSequence} object.
	 * @return a {@link java.lang.CharSequence} object.
	 */
	public static CharSequence compareLetters(CharSequence s1, CharSequence s2) {
		if (s1 == null || s2 == null)
			return null;
		if (s1.equals(s2))
			return s1;
		int s1Len = s1.length();
		int s2Len = s2.length();
		StringBuffer builder = new StringBuffer();
		for (int i = 0; i < s1Len; i++) {
			if (i < s2Len && s1.charAt(i) != s2.charAt(i)) {
				builder.append(DIFF_START_CHAR).append(s1.charAt(i)).append(DIFF_DELIM_CHAR).append(s2.charAt(i)).append(DIFF_END_CHAR);
			} else {
				builder.append(s1.charAt(i));
			}
		}
		return builder;
	}

	/**
	 * Comparison of two input strings, word by word. Uses String split with
	 * delimiter as a SPACE The output is in a console centric format for easier
	 * reading in a standalone program
	 *
	 * @param s1
	 *            a {@link java.lang.CharSequence} object.
	 * @param s2
	 *            a {@link java.lang.CharSequence} object.
	 * @return a {@link java.lang.CharSequence} object.
	 */
	public static CharSequence compareWords(CharSequence s1, CharSequence s2) {
		if (s1 == null || s2 == null)
			return null;
		if (s1.equals(s2))
			return s1;
		String[] s1Array = s1.toString().split(DIFF_SPACE_STR);
		String[] s2Array = s2.toString().split(DIFF_SPACE_STR);
		StringBuffer builder = new StringBuffer();
		int index = 0;
		for (; index < s1Array.length; index++) {
			String first = s1Array[index];
			String second = null;
			if (index < s2Array.length)
				second = s2Array[index];

			if (!equals(first, second)) {
				builder.append(DIFF_START_CHAR).append(first).append(DIFF_DELIM_CHAR).append(second).append(DIFF_END_CHAR);
			} else {
				builder.append(first);
			}
			builder.append(DIFF_SPACE_CHAR);
		}
		while (index < s2Array.length) {
			builder.append(DIFF_START_CHAR).append(DIFF_SPACE_CHAR).append(DIFF_DELIM_CHAR).append(s2Array[index]).append(DIFF_END_CHAR).append(DIFF_SPACE_CHAR);
			index++;
		}

		return builder;
	}

	/**
	 * <p>
	 * equals.
	 * </p>
	 *
	 * @param cs1
	 *            a {@link java.lang.CharSequence} object.
	 * @param cs2
	 *            a {@link java.lang.CharSequence} object.
	 * @return a boolean.
	 */
	public static boolean equals(final CharSequence cs1, final CharSequence cs2) {
		if (cs1 == cs2) {
			return true;
		}
		if (cs1 == null || cs2 == null) {
			return false;
		}
		if (cs1 instanceof String && cs2 instanceof String) {
			return cs1.equals(cs2);
		}
		return regionMatches(cs1, false, 0, cs2, 0, Math.max(cs1.length(), cs2.length()));
	}

	static boolean regionMatches(final CharSequence cs, final boolean ignoreCase, final int thisStart, final CharSequence substring, final int start, final int length) {
		if (cs instanceof String && substring instanceof String) {
			return ((String) cs).regionMatches(ignoreCase, thisStart, (String) substring, start, length);
		}
		int index1 = thisStart;
		int index2 = start;
		int tmpLen = length;

		while (tmpLen-- > 0) {
			final char c1 = cs.charAt(index1++);
			final char c2 = substring.charAt(index2++);

			if (c1 == c2) {
				continue;
			}

			if (!ignoreCase) {
				return false;
			}

			// The same check as in String.regionMatches():
			if (Character.toUpperCase(c1) != Character.toUpperCase(c2) && Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
				return false;
			}
		}

		return true;
	}
}
