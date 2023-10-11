package de.hs_el.streekmann.algodat.aufgabe4;

public class ArrayOperator<E extends Comparable<E>> implements DataStructureOperator<E> {
	private E[] array;
	private long comparisons;
	private long exchanges;

	public ArrayOperator(E[] array){
		this.array = array;
	}

	@Override
	public boolean lessThan(int index1, int index2) {
		comparisons++;
		int result = array[index1].compareTo(array[index2]);
		return result < 0;
	}

	@Override
	public boolean lessThan(int index, E element) {
		comparisons++;
		int result = array[index].compareTo(element);
		return result < 0;
	}

	@Override
	public boolean lessThan(E element, int index) {
		comparisons++;
		int result = element.compareTo(array[index]);
		return result < 0;
	}

	@Override
	public boolean greaterThan(int index1, int index2) {
		comparisons++;
		int result = array[index1].compareTo(array[index2]);
		return result > 0;
	}

	public void exchange(int index1, int index2) {
		exchanges++;
		E temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	public void exchange(int index1, E value) {
		exchanges++;
		array[index1] = value;
	}

	public long getComparisons() {
		return comparisons;
	}

	public long getExchanges() {
		return exchanges;
	}

	@Override
	public int numberOfElements() {
		return array.length;
	}

	@Override
	public E getValue(int index) {
		return array[index];
	}
}
