package de.hs_el.streekmann.algodat.aufgabe4;

public class BubbleSort<E extends Comparable<E>> implements Sort<E> {

	@Override
	public void sort(DataStructureOperator<E> dataStructureOperator) {
		for (int i = 0; i < dataStructureOperator.numberOfElements(); i++) {
			for (int j = dataStructureOperator.numberOfElements()-1; j > i; j--) {
				if (dataStructureOperator.greaterThan(j-1, j)) {
					dataStructureOperator.exchange(j-1, j);
				}
			}
		}
	}

	@Override
	public void sort(E[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = array.length-1; j > i; j--) {
				if (array[j-1].compareTo(array[j]) > 0) {
					E temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	}
}
