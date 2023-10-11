package de.hs_el.streekmann.algodat.aufgabe4;

public class InsertionSort<E extends Comparable<E>> implements Sort<E> {

	public void sort(DataStructureOperator<E> dataStructureOperator) {
		for (int i = 1; i < dataStructureOperator.numberOfElements(); i++) {
			for (int j = i; j > 0 && dataStructureOperator.lessThan(j, j-1); j--) {
				dataStructureOperator.exchange(j, j-1);
			}
		}
	}

	public void sort(E[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0 && array[j].compareTo(array[j-1]) < 0; j--) {
				E temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
			}
		}
	}
}
