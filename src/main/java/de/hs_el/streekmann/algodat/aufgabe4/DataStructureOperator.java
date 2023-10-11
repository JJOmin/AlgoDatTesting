package de.hs_el.streekmann.algodat.aufgabe4;

public interface DataStructureOperator<E>{
	boolean lessThan(int index1, int index2);
	boolean lessThan(int index, E element);
	boolean lessThan(E element, int index);
	boolean greaterThan(int index1, int index2);
	void exchange(int index1, int index2);
	void exchange(int index1, E value);

	E getValue(int index);
	int numberOfElements();

	long getComparisons();
	long getExchanges();
}
