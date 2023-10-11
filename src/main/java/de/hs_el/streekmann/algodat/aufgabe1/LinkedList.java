package de.hs_el.streekmann.algodat.aufgabe1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
	//Variablen
	public int currentCount = 0; //Var die die Anzahl der Listenaufrufe zählt
	public int iteratorCount = 0; //Var die die Anzahl der Iterator List aufrufe Zählt

	private class Node {
		E element;
		Node successor;
		Node(E element) {
			this.element = element;
			this.successor = null; //erstellt nulltes Element (leeres Element)
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
		numberOfElements = 0; //setzt die Anzahl der Elemente auf 0
	}

	//Methoden für die LinkedList
	@Override
	public boolean add(E element) {
		Node addedNode = new Node(element); //Erstellt neue Node für die Var addedNode
		lastNode.successor = addedNode; //Setzt die Node an die letzte Stelle
		lastNode = addedNode; //setzt die Var lastNode auf die neu eingefügte Node
		numberOfElements++; //addiert die Anzahl der Elemente um 1
		return true;
	}

	@Override
	public E get(int index) {

		if (index < 0 || index >= numberOfElements) { //prüft ob der Index im Array liegt
			throw new IndexOutOfBoundsException();
		}
		Node nodeAtCurrentIndex = firstNode.successor; //setzt die Var nodeAtCurrentIndex auf das erste Element das nicht das leere Element ist
		currentCount = 0; //Var die die Anzahl der Listenaufrufe zählt
		for (int currentIndex = 0; currentIndex < index; currentIndex++) { //geht durch die Liste bis zum gewünschten Index
			nodeAtCurrentIndex = nodeAtCurrentIndex.successor; //setzt die Var nodeAtCurrentIndex auf das nächste Element
			currentCount++; //zählt die Anzahl der Schleifendurchläufe (Aufgabe 3.1)
		}
		return nodeAtCurrentIndex.element;
	}

	//Aufgabe 3
	@Override
	public int getCurrentCount(int index){ //retunt die anzahl der Listenaufrufe
		return currentCount;
	}

	@Override
	public int getIteratorCount(){ //retunt die anzahl der Listenaufrufe im Iterator
		return iteratorCount;
	}



	@Override
	public int size() { //gibt die "länge" der Liste (Anzahl der Elemente zurück)
		return numberOfElements;
	}

	@Override
	public E remove(int index) { //entfernt ein Element an der Stelle index
		if (index < 0 || index >= numberOfElements) { //prüft ob der Index im Array liegt
			throw new IndexOutOfBoundsException();
		}
		// Allgemeiner Fall: Element in der Mitte oder am Ende entfernen
		Node previousNode = firstNode; //setzt die Var previousNode auf das erste Element das nicht das leere Element ist
		Node currentNode = previousNode.successor; //setzt die Var currentNode auf das zweite Element das nicht das leere Element ist
		for (int currentIndex = 0; currentIndex < index; currentIndex++){ //geht durch die Liste bis zum gewünschten Index
			previousNode = currentNode; //setzt die Var previousNode auf das Element das currentNode ist
			currentNode = currentNode.successor; //setzt die Var currentNode auf den nachfolger der currentNode
		
		}
		if(index == numberOfElements -1) { //wenn der nachfolger des zu entfernenden Elements null ist...
			lastNode = previousNode; //setzt die Var lastNode auf das vorherige Element
		}
		
		E removedElement = currentNode.element;
		previousNode.successor = currentNode.successor; //setzt den nachfolger des vorherigen Elements auf den nachfolger des zu entfernenden Elements
		numberOfElements--; //subtrahiert die Anzahl der Elemente um 1
		return removedElement;
	}

	//notwendig?
	private Node getNodeAtIndex(int index) { //gibt das Element an der Stelle index zurück
		Node nodeAtCurrentIndex = firstNode;

		for (int currentIndex = 0; currentIndex < index; currentIndex++) {
			nodeAtCurrentIndex = nodeAtCurrentIndex.successor;
		}
		return nodeAtCurrentIndex;
	}


	@Override
	public boolean remove(Object o) { //entfernt ein Element
		Node previousNode = firstNode; //setzt die Var previousNode auf das erste Element das nicht das leere Element ist
		Node currentNode = firstNode.successor; //setzt die Var currentNode auf das zweite Element das nicht das leere Element ist
		while (currentNode != null) { //solange currentNode nicht null ist...
			if (o == null ? currentNode.element == null : o.equals(currentNode.element)) { //prüft ob das Element null ist

				// Spezialfall: Das erste Element(das nicht Empty/Null ist :D) der Liste wird entfernt!!!
				if (previousNode != null) { //wenn previousNode nicht null ist...

					previousNode.successor = currentNode.successor; //setzt den nachfolger des vorherigen Elements auf den nachfolger des zu entfernenden Elements
					if(currentNode == lastNode) { //wenn der nachfolger des zu entfernenden Elements null ist...
						lastNode = previousNode; //setzt die Var lastNode auf das vorherige Element
					}
					numberOfElements--;
					return true; //Element gefunden und entfernt
				}
			}
			previousNode = currentNode; //setzt previousNode auf das Element der currentNode
			currentNode = currentNode.successor; //setzt currentNode auf den nachfolger der currentNode
		}
		return false; //Das gesuchte Element nicht gefunden und nicht entfernt
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
		return new Iterator<E>() {
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
				E element = nextNode.successor.element;
				nextNode = nextNode.successor;
				iteratorCount = 0;
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