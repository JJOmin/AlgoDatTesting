package de.hs_el.streekmann.algodat.aufgabe4.measurement;

import de.hs_el.streekmann.algodat.aufgabe4.BubbleSort;
import de.hs_el.streekmann.algodat.aufgabe4.InsertionSort;
import de.hs_el.streekmann.algodat.aufgabe4.SelectionSort;
import de.hs_el.streekmann.algodat.aufgabe4.ShellSort;
import de.hs_el.streekmann.algodat.aufgabe4.Sort;

import java.util.Map;

public class SortAlgorithmsFactory<E extends Comparable<E>> {

	public enum SortAlgorithm {
		BUBBLE_SORT,
		INSERTION_SORT,
		SELECTION_SORT,
		SHELL_SORT
	}

	private final Map<SortAlgorithm, Sort<E>> knownSortAlgorithms = Map.ofEntries(
			Map.entry(SortAlgorithm.BUBBLE_SORT, new BubbleSort<>()),
			Map.entry(SortAlgorithm.INSERTION_SORT, new InsertionSort<>()),
			//Map.entry(SortAlgorithm.SELECTION_SORT, new SelectionSort<>()),
			Map.entry(SortAlgorithm.SHELL_SORT, new ShellSort<>())
	);

	public Sort<E> createSortAlgorithm(SortAlgorithm algorithm) {
		return knownSortAlgorithms.get(algorithm);
	}
}
