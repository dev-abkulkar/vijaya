package org.algolib.utils;

public class CountBits {

	static int[] bitLookup;
	static {
		countBitsForLookup();
	}

	private static void countBitsForLookup() {
		bitLookup = new int[256];
		for (int i = 0; i < 256; i++)
			bitLookup[i] = (1 & i) + bitLookup[i / 2];

	}

	public static int countBits(int x) {
		int bitGroup1 = x & 0xff;
		int bitGroup2 = (x >> 8) & 0xff;
		int bitGroup3 = (x >> 16) & 0xff;
		int bitGroup4 = (x >> 24) & 0xff;

		return bitLookup[bitGroup1] + bitLookup[bitGroup2]
				+ bitLookup[bitGroup3] + bitLookup[bitGroup4];

	}
}
