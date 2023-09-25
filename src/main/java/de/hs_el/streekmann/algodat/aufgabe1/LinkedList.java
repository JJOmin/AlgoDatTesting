package de.hs_el.streekmann.algodat.aufgabe1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
	private class Node {
		E element;
		Node successor;
		Node(E element) {
			this.element = element;
			this.successor = null;
		}
	}

	Node firstNode;
	Node lastNode;
	Node emptyNode;
	int numberOfElements;

	public LinkedList() {
		emptyNode = new Node (null);
		firstNode = emptyNode;
		lastNode = emptyNode;
		numberOfElements = 0; // das sollte eigentlich 0 sein :D
	}

	@Override
	public boolean add(E element) {
		Node addedNode = new Node(element);
		lastNode.successor = addedNode;
		lastNode = addedNode;
		numberOfElements++;
		return true;
	}

	@Override
	public E get(int index) {

		if (index < 0 || index >= numberOfElements) {
			throw new IndexOutOfBoundsException();
		}
		Node nodeAtCurrentIndex = firstNode.successor;

		for (int currentIndex = 0; currentIndex < index; currentIndex++) {
			nodeAtCurrentIndex = nodeAtCurrentIndex.successor;
			currentCount++;
		}
		//System.out.println("\n" + nodeAtCurrentIndex.successor); //test zum verstehen
		return nodeAtCurrentIndex.element;

	}

	public int currentCount = 0;
	@Override
	public int getCurrentCount(int index){
		return currentCount;
	}

	public int iteratorCount = 0;
	public int getIteratorCount(){
		return iteratorCount;
	}

	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= numberOfElements) {
			throw new IndexOutOfBoundsException();
		}
		// Allgemeiner Fall: Element in der Mitte oder am Ende entfernen
		Node previousNode = firstNode;
		Node currentNode = previousNode.successor;
		for (int currentIndex = 0; currentIndex < index; currentIndex++){
			previousNode = currentNode;
			currentNode = currentNode.successor;
		}
		E removedElement = currentNode.element;
		previousNode.successor = currentNode.successor;
		numberOfElements--;
		return removedElement;
	}
	private Node getNodeAtIndex(int index) {
		Node nodeAtCurrentIndex = firstNode;

		for (int currentIndex = 0; currentIndex < index; currentIndex++) {
			nodeAtCurrentIndex = nodeAtCurrentIndex.successor;
		}
		return nodeAtCurrentIndex;
	}
	@Override
	public boolean remove(Object o) {
		Node previousNode = firstNode;
		Node currentNode = firstNode.successor;
		while (currentNode != null) {
			if (o == null ? currentNode.element == null : o.equals(currentNode.element)) {
				if (previousNode != null) {
					// Spezialfall: Das erste Element wird entfernt
					previousNode.successor = currentNode.successor;
					numberOfElements--;
					return true;
				}
			}
			previousNode = currentNode;
			currentNode = currentNode.successor;
		}

		// Das gesuchte Element wurde nicht gefunden
		return false;
	}
	@Override
	public int indexOf(Object o) {
		int index = 0;
		Node currentNode = firstNode;

		while (currentNode != null) {
			if (o == null ? currentNode.element == null : o.equals(currentNode.element)) {
				// Das gesuchte Element wurde gefunden
				return index -1;
			}
			currentNode = currentNode.successor;
			index++;
		}
		return -1;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<>() {
			Node nextNode = firstNode;

			@Override

			public boolean hasNext() {
				return nextNode != null && nextNode.successor != null;
			}
			@Override
			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				iteratorCount++;
				E element = nextNode.successor.element;
				nextNode = nextNode.successor;
				iteratorCount++;
				return element;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}