package de.hs_el.streekmann.algodat.aufgabe4;

public class SelectionSort<E extends Comparable<E>> implements Sort<E> {

	public void sort(DataStructureOperator<E> dataStructureOperator) {
		int n = dataStructureOperator.numberOfElements();

		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i+1; j < n; j++) {
				if (dataStructureOperator.lessThan(j, min)) {
					min = j;
				}
			}
			
			dataStructureOperator.exchange(i, min);
			//System.out.println("min: " + min);
			//System.out.println("i: " + i);
		}
	}

	public void sort(E[] array) {
		int n = array.length;
		for (int i = 0; i<n; i++){
	
			int minIndex = i;
			for (int j = i+1; j<n; j++){
				if (array[j].compareTo(array[minIndex]) < 0){
					minIndex = j;
				}
			}
			E temp = array[i];
			//System.out.println("temp: " + temp);
			array[i] = array[minIndex];
			//System.out.println("array[i]: " + array[i]);
			array[minIndex] = temp;
		}
	
	}
}