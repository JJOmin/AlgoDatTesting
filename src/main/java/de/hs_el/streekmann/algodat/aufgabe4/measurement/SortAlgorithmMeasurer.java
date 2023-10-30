package de.hs_el.streekmann.algodat.aufgabe4.measurement;

import de.hs_el.streekmann.algodat.aufgabe4.ArrayOperator;
import de.hs_el.streekmann.algodat.aufgabe4.Sort;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.stream.IntStream;

public class SortAlgorithmMeasurer {

	public enum Order {
		RANDOM,
		ASCENDING,
		DESCENDING
	}

	private static final Random RANDOM = new Random();

	public class MeasurementResult {
		private long elapsedTime;
		private long numberOfComparisons;
		private long numberOfExchanges;

		public MeasurementResult(long elapsedTime, long numberOfComparisons, long numberOfExchanges) {
			this.elapsedTime = elapsedTime;
			this.numberOfComparisons = numberOfComparisons;
			this.numberOfExchanges = numberOfExchanges;
		}

		public String toString() {
			return "Elapsed time "+elapsedTime+"ms, "+numberOfComparisons+" comparisons, "+numberOfExchanges+" exchanges";
		}
	}

	public void simpleMeasurement(Sort<Integer> sortAlgorithm, Integer[] values, String name){
		MeasurementResult measurementResult = measure(sortAlgorithm, values);
		System.out.println(name + " \n"+sortAlgorithm.getClass().getSimpleName()+" sorted "+values.length+" values: "+measurementResult);
		//System.out.println("Sorted values:");
		//for (Integer value : values) {
			//System.out.print(value + " ");
		//}
	}

	private static final int NUMBER_OF_ITERATIONS = 10;

	public void doublingMeasurement(Sort<Integer> sortAlgorithm) {
		int numberOfElements = 250;
		for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
			MeasurementResult measurementResult = measure(sortAlgorithm, createRandomIntegerArray(numberOfElements));
			System.out.println(sortAlgorithm.getClass().getSimpleName()+" "+numberOfElements+" -> "+measurementResult);
			numberOfElements+=numberOfElements;
		}
	}

	public void pairwiseComparison(Sort<Integer> sortAlgorithm1, Sort<Integer> sortAlgorithm2, int numberOfElements, Order order) {
		double result1 = measure(sortAlgorithm1, createValues(numberOfElements, order)).elapsedTime;
		double result2 = measure(sortAlgorithm2, createValues(numberOfElements, order)).elapsedTime;
		System.out.print("For "+numberOfElements+" "+order+" elements ");
		Sort<Integer> faster, slower;
		double ratio;
		if (result1 <= result2) {
			faster = sortAlgorithm1;
			slower = sortAlgorithm2;
			ratio = result2/result1;
		}
		else {
			faster = sortAlgorithm2;
			slower = sortAlgorithm1;
			ratio = result1/result2;
		}
		System.out.println(faster.getClass().getSimpleName()+" is "+new DecimalFormat("0.00").format(ratio)+" times faster than "+slower.getClass().getSimpleName());
	}

	private MeasurementResult measure(Sort<Integer> sortAlgorithm, Integer[] values) {
		ArrayOperator<Integer> arrayOperator = new ArrayOperator<>(values);
		long elapsed = measure(() -> sortAlgorithm.sort(arrayOperator));
		return new MeasurementResult(elapsed, arrayOperator.getComparisons(), arrayOperator.getExchanges());
	}

	private static long measure(Runnable function) {
		Instant start = Instant.now();
		function.run();
		Instant stop = Instant.now();
		return Duration.between(start, stop).toMillis();
	}

	public static Integer[] createValues(int numberOfElements, Order order){
		Integer[] values = null;
		switch (order) {
			case RANDOM: values = createRandomIntegerArray(numberOfElements); break;
			case ASCENDING: values = createSortedIntegerArray(numberOfElements); break;
			case DESCENDING: values = createReverseIntegerArray(numberOfElements); break;
		}
		return values;
	}

	private static Integer[] createRandomIntegerArray(int numberOfElements) {
		return RANDOM.ints(numberOfElements, 1, numberOfElements).boxed().toArray( Integer[]::new );
	}

	private static Integer[] createSortedIntegerArray(int numberOfElements) {
		return IntStream.range(1, numberOfElements).boxed().toArray( Integer[]::new );
	}

	private static Integer[] createReverseIntegerArray(int numberOfElements) {
		int from = 1;
		int to = numberOfElements+1;
		return IntStream.range(from, to).map(i -> to - i + from - 1).boxed().toArray( Integer[]::new );
	}
}

