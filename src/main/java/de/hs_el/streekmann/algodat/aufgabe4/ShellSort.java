package de.hs_el.streekmann.algodat.aufgabe4;

public class ShellSort<E extends Comparable<E>> implements Sort<E> {

	public void sort(DataStructureOperator<E> dataStructureOperator) {
		int n = dataStructureOperator.numberOfElements();

		// 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
		int stepWidth = 1;
		while (stepWidth < n/3) stepWidth = 3*stepWidth + 1;

		while (stepWidth >= 1) {
			for (int i = stepWidth; i < n; i++) {
				for (int j = i; j >= stepWidth && dataStructureOperator.lessThan(j, j-stepWidth) ; j=j-stepWidth) {
					dataStructureOperator.exchange(j, j-stepWidth);
				}
			}
			stepWidth /= 3;
		}
	}

	@Override
	public void sort(E[] array) {

		// 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
		int stepWidth = 1;
		while (stepWidth < array.length/3) stepWidth = 3*stepWidth + 1;

		while (stepWidth >= 1) {
			for (int i = stepWidth; i < array.length; i++) {
				for (int j = i; j >= stepWidth && array[j].compareTo(array[j-stepWidth]) < 0; j=j-stepWidth) {
					E temp = array[j];
					array[j] = array[j-stepWidth];
					array[j-stepWidth] = temp;
				}
			}
			stepWidth /= 3;
		}
	}
}
