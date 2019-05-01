import java.util.Arrays;

import net.adaptivebox.deps.behavior.DEGTBehavior;
import net.adaptivebox.global.RandomGenerator;
import net.adaptivebox.knowledge.Library;
import net.adaptivebox.knowledge.SearchPoint;
import net.adaptivebox.problem.ProblemEncoder;

public class Main {
	public static void main(String[] args) throws Exception {
		final long NUMBER_OF_EXPERIMENTS = 5_000_000L;

		/* First algorithm. */ {
			DEGTBehavior behavior = new DEGTBehavior();

			ProblemEncoder problemEncoder = new ProblemEncoder(10, 10) {
				@Override
				protected double calcTargetAt(int index, double[] VX) {
					return Math.random();
				}

				@Override
				public String toString() {
					setDefaultXAt(0, 0, 100, 0.01);
					setDefaultXAt(1, 0, 100, 0.01);
					setDefaultXAt(2, 0, 100, 0.01);
					setDefaultXAt(3, 0, 100, 0.01);
					setDefaultXAt(4, 0, 100, 0.01);
					setDefaultXAt(5, 0, 100, 0.01);
					setDefaultXAt(6, 0, 100, 0.01);
					setDefaultXAt(7, 0, 100, 0.01);
					setDefaultXAt(8, 0, 100, 0.01);
					setDefaultXAt(9, 0, 100, 0.01);
					return "";
				}
			};

			problemEncoder.toString();
			
			SearchPoint pbest = problemEncoder.getEncodedSearchPoint();

			SearchPoint trailPoint = problemEncoder.getFreshSearchPoint();

			Library library = new Library(100, problemEncoder);

			behavior.setLibrary(library);
			behavior.setPbest(pbest);

			long start = System.currentTimeMillis();
			for (long g = 0; g < NUMBER_OF_EXPERIMENTS; g++) {
				behavior.generateBehavior(trailPoint, problemEncoder);
			}
			long stop = System.currentTimeMillis();
			System.out.println(stop - start);
		}

		for (int h = 0; h < 0; h++) {
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
