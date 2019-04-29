import java.util.Arrays;

import net.adaptivebox.global.RandomGenerator;

public class Main {
	public static void main(String[] args) {
		final long NUMBER_OF_EXPERIMENTS = 5_000_000L;

		for (int h = 0; h < 5; h++) {
			int a = (int) (10 + Math.random() * 10);
			int b = (int) (2 + Math.random() * 10);
			System.out.println(Arrays.toString(RandomGenerator.randomSelection(a, b)));
			System.out.println(Arrays.toString(RandomGenerator.randomSelection2(a, b)));
			System.out.println(Arrays.toString(RandomGenerator.randomSelection3(a, b)));
			System.out.println(Arrays.toString(RandomGenerator.randomSelection4(a, b)));
			System.out.println(Arrays.toString(RandomGenerator.randomSelection5(a, b)));

			/* First algorithm. */ {
				long start = System.currentTimeMillis();
				for (long g = 0; g < NUMBER_OF_EXPERIMENTS; g++) {
					RandomGenerator.randomSelection(a, b);
				}
				long stop = System.currentTimeMillis();
				System.out.println(stop - start);
			}

			/* Second algorithm. */ {
				long start = System.currentTimeMillis();
				for (long g = 0; g < NUMBER_OF_EXPERIMENTS; g++) {
					RandomGenerator.randomSelection2(a, b);
				}
				long stop = System.currentTimeMillis();
				System.out.println(stop - start);
			}

			/* Third algorithm. */ {
				long start = System.currentTimeMillis();
				for (long g = 0; g < NUMBER_OF_EXPERIMENTS; g++) {
					RandomGenerator.randomSelection3(a, b);
				}
				long stop = System.currentTimeMillis();
				System.out.println(stop - start);
			}

			/* Fourth algorithm. */ {
				long start = System.currentTimeMillis();
				for (long g = 0; g < NUMBER_OF_EXPERIMENTS; g++) {
					RandomGenerator.randomSelection4(a, b);
				}
				long stop = System.currentTimeMillis();
				System.out.println(stop - start);
			}

			/* Fifth algorithm. */ {
				long start = System.currentTimeMillis();
				for (long g = 0; g < NUMBER_OF_EXPERIMENTS; g++) {
					RandomGenerator.randomSelection5(a, b);
				}
				long stop = System.currentTimeMillis();
				System.out.println(stop - start);
			}
			
			System.out.println();
		}
	}
}
