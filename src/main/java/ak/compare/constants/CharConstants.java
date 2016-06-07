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
package ak.compare.constants;

/**
 * <p>CharConstants interface.</p>
 *
 * @author aksappy
 * @version 0.0.1
 */
public interface CharConstants {
	/** Constant <code>DIFF_START_CHAR='('</code> */
	char DIFF_START_CHAR = '(';
	/** Constant <code>DIFF_END_CHAR=')'</code> */
	char DIFF_END_CHAR = ')';
	/** Constant <code>DIFF_DELIM_CHAR='|'</code> */
	char DIFF_DELIM_CHAR = '|';
	/** Constant <code>DIFF_SPACE_CHAR=' '</code> */
	char DIFF_SPACE_CHAR = ' ';

	/** Constant <code>DIFF_SPACE_STR="String.valueOf(DIFF_SPACE_CHAR)"</code> */
	String DIFF_SPACE_STR = String.valueOf(DIFF_SPACE_CHAR);

}
