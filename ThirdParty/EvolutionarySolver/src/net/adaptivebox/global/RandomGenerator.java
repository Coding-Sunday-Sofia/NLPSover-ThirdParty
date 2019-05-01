/**
 * Description: For generating random numbers.
 *
 * Author          Create/Modi     Note
 * Xiaofeng Xie    Feb 22, 2001
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * Please acknowledge the author(s) if you use this code in any way.
 *
 * @version 1.0
 * @Since MAOS1.0
 */

package net.adaptivebox.global;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
	/**
	 * Pseudo random number generator instance.
	 */
	private static Random PRNG = new Random();

	/**
	 * This function returns a random integer number between the lowLimit and
	 * upLimit (inclusive).
	 *
	 * @param lowLimit
	 *            lower limits upLimit The upper limits (between which the
	 *            random number is to be generated)
	 * @return int return value Example: for find [0,1,2]
	 */
	public static int intRangeRandom(int lowLimit, int upLimit) {
		int number = lowLimit + PRNG.nextInt(upLimit - lowLimit + 1);

		return number;
	}

	/**
	 * This function returns a random double number between the lowLimit and
	 * upLimit (exclusive).
	 *
	 * @param lowLimit
	 *            lower limits upLimit The upper limits (between which the
	 *            random number is to be generated)
	 * @return double return value
	 */
	public static double doubleRangeRandom(double lowLimit, double upLimit) {
		double number = lowLimit + PRNG.nextDouble() * (upLimit - lowLimit);

		return number;
	}

	public static int[] randomSelection5(int size, int times) {
		if (size < 0) {
			size = 0;
		}

		if (times < 0) {
			times = 0;
		}

		int[] all = new int[size];
		for (int i = 0; i < all.length; i++) {
			all[i] = i;
		}

		/* https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle */
		int[] indices = new int[Math.min(size, times)];
		for (int i = 0, j, value; i < indices.length; i++) {
			j = intRangeRandom(i, all.length - 1);

			value = all[j];
			all[j] = all[i];
			indices[i] = all[i] = value;
		}

		return indices;
	}

	public static int[] randomSelection4(int totalSize, int times) {
		int[] indices = new int[Math.min(totalSize, times)];
		boolean[] selected = new boolean[totalSize];

		for (int i = 0; i < indices.length; i++) {
			indices[i] = intRangeRandom(0, totalSize - 1);

			if (selected[indices[i]] == true) {
				i--;
				continue;
			}

			selected[indices[i]] = true;
		}

		return indices;
	}

	public static int[] randomSelection3(int totalSize, int times) {
		List<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < totalSize; i++) {
			values.add(i);
		}
		Collections.shuffle(values);

		int[] indices = new int[Math.min(totalSize, times)];
		for (int i = 0; i < times; i++) {
			indices[i] = values.get(i);
		}

		return indices;
	}

	public static int[] randomSelection2(int totalSize, int times) {
		if (times <= 0) {
			return new int[0];
		}

		boolean isBelowHalf = 2 * times < totalSize;

		int howManyToPickUp = times = Math.min(totalSize, times);

		if (isBelowHalf == false) {
			howManyToPickUp = totalSize - times;
		}

		int[] indices = new int[times];
		boolean[] flags = new boolean[totalSize];

		for (int i = 0; i < howManyToPickUp;) {
			indices[i] = intRangeRandom(0, totalSize - 1);

			if (flags[indices[i]] == true) {
				continue;
			}

			flags[indices[i]] = true;
			i++;
		}

		if (isBelowHalf == false) {
			for (int i = 0, j = 0; i < totalSize && j < times; i++) {
				if (flags[i] == true) {
					continue;
				}

				indices[j] = i;
				j++;
			}
		}

		return indices;
	}

	public static int[] randomSelection(int maxNum, int times) {
		if (times <= 0)
			return new int[0];
		int realTimes = Math.min(maxNum, times);
		boolean[] flags = new boolean[maxNum];
		boolean isBelowHalf = times < maxNum * 0.5;
		int virtualTimes = realTimes;
		if (!isBelowHalf) {
			virtualTimes = maxNum - realTimes;
		}
		int i = 0;
		int upper = maxNum - 1;
		int[] indices = new int[realTimes];

		while (i < virtualTimes) {
			indices[i] = intRangeRandom(0, upper);
			if (!flags[indices[i]]) {
				flags[indices[i]] = true;
				i++;
			}
		}
		if (!isBelowHalf) {
			int j = 0;
			for (i = 0; i < maxNum; i++) {
				if (flags[i] == isBelowHalf) {
					indices[j] = i;
					j++;
					if (j == realTimes)
						break;
				}
			}
		}
		return indices;
	}
}
