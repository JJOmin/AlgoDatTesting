package de.hs_el.streekmann.algodat.aufgabe4.measurement;

import de.hs_el.streekmann.algodat.aufgabe4.InsertionSort;
import de.hs_el.streekmann.algodat.aufgabe4.SelectionSort;

public class SortStarter {

	private enum Task {
		SIMPLE_SORT,
		PAIRWISE_COMPARISON,
		DOUBLING_MEASUREMENT
	}

	private static SortAlgorithmMeasurer measurer = new SortAlgorithmMeasurer();
	private static SortAlgorithmsFactory<Integer> algorithmFactory = new SortAlgorithmsFactory<>();

	private static final int NUMBER_OF_ELEMENTS = 10000;
	private static final SortAlgorithmMeasurer.Order ORDER = SortAlgorithmMeasurer.Order.RANDOM;
	private static final Integer[] MY_ARRAY = {12, 7, 8, 13, 6, 4, 1, 14, 2, 9, 10, 11, 3, 5};
	private static SortAlgorithmsFactory.SortAlgorithm[] ALGORITHMS = {SortAlgorithmsFactory.SortAlgorithm.SELECTION_SORT,SortAlgorithmsFactory.SortAlgorithm.INSERTION_SORT};//, SortAlgorithmsFactory.SortAlgorithm.SHELL_SORT
	private static Task TASK = Task.SIMPLE_SORT;

	public static void main(String[] args) {
			Integer[] zufällig = SortAlgorithmMeasurer.createValues(NUMBER_OF_ELEMENTS, SortAlgorithmMeasurer.Order.RANDOM);
        Integer[] sortetiert = SortAlgorithmMeasurer.createValues(NUMBER_OF_ELEMENTS, SortAlgorithmMeasurer.Order.ASCENDING);
        Integer[] rückwärtsSortiert = SortAlgorithmMeasurer.createValues(NUMBER_OF_ELEMENTS, SortAlgorithmMeasurer.Order.DESCENDING);
		
		switch (TASK) {
			case SIMPLE_SORT: simpleSort(ALGORITHMS, measurer, algorithmFactory,MY_ARRAY,"MY_ARRAY"); break;
			case PAIRWISE_COMPARISON: pairwiseComparison(ALGORITHMS, measurer, algorithmFactory); break;
			case DOUBLING_MEASUREMENT: doublingMeasurement(ALGORITHMS, measurer, algorithmFactory); break;
		}
	//System.out.println("zufällig:");
		simpleSort(ALGORITHMS, measurer, algorithmFactory, zufällig,"zufällig:");
		//System.out.println("sortiert:");
		simpleSort(ALGORITHMS, measurer, algorithmFactory, sortetiert,"sortiert:");
		//System.out.println("rückwärts sortiert:");
		simpleSort(ALGORITHMS, measurer, algorithmFactory, rückwärtsSortiert,"rückwärts sortiert:");
	}

    
	private static void simpleSort(SortAlgorithmsFactory.SortAlgorithm[] algorithms, SortAlgorithmMeasurer measurer,
								   SortAlgorithmsFactory<Integer> algorithmFactory, Integer[] MY_ARRAY, String name) {
									
			for (SortAlgorithmsFactory.SortAlgorithm algorithm : algorithms) {
				
			final Integer[] values = MY_ARRAY != null ? MY_ARRAY.clone() : SortAlgorithmMeasurer.createValues(NUMBER_OF_ELEMENTS, ORDER);
			new Thread(() -> measurer.simpleMeasurement(algorithmFactory.createSortAlgorithm(algorithm), values,name)).start();
			//for (Integer value : values) {
			//	System.out.println(value + " ");
			//}
			
		}
		
	}

	private static void doublingMeasurement(SortAlgorithmsFactory.SortAlgorithm[] algorithms, SortAlgorithmMeasurer measurer,
											SortAlgorithmsFactory<Integer> algorithmFactory) {
		for (SortAlgorithmsFactory.SortAlgorithm algorithm : algorithms) {
			new Thread(() -> measurer.doublingMeasurement(algorithmFactory.createSortAlgorithm(algorithm))).start();
		}
	}

	private static void pairwiseComparison(SortAlgorithmsFactory.SortAlgorithm[] algorithms, SortAlgorithmMeasurer measurer,
										   SortAlgorithmsFactory<Integer> algorithmFactory) {
		for (int i = 0; i < algorithms.length; i++) {
			for(int j=i+1; j < algorithms.length; j++) {
				measurer.pairwiseComparison(algorithmFactory.createSortAlgorithm(algorithms[i]), algorithmFactory.createSortAlgorithm(algorithms[j]), NUMBER_OF_ELEMENTS, ORDER);
			}
		}
	}
}

