package de.hs_el.streekmann.algodat.aufgabe1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
	public int currentCount = 0; //Var die die Anzahl der Listenaufrufe zählt
	public int iteratorCount = 0;

	static final int MAX_SIZE = 32;
	int size;
	E[] elementArray;

	@SuppressWarnings("unchecked")
	public ArrayList() {
		size = 0;
		elementArray = (E[]) new Object[MAX_SIZE];
	}

	@Override
	public boolean add(E element) {
		if (size < MAX_SIZE) {
			elementArray[size] = element;
			size++;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		currentCount++;

		return elementArray[index];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E remove(int index) {
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int nextIndex = 0;
			int currentIndex;

			@Override
			public boolean hasNext() {
				return nextIndex < size;
			}

			@Override
			public E next() {
				if (nextIndex == size) {
					throw new NoSuchElementException();
				}
				currentIndex = nextIndex;
				if (nextIndex < size) {
					nextIndex++;
				}
				iteratorCount++;
				return elementArray[currentIndex];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	@Override
	public int getCurrentCount(int index){
		return currentCount;
	}

	public int getIteratorCount(){
		return iteratorCount;
	}

}
