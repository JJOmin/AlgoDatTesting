package de.hs_el.streekmann.algodat.aufgabe2;

import de.hs_el.streekmann.algodat.aufgabe1.LinkedList;
import de.hs_el.streekmann.algodat.aufgabe1.List;

public class ListUsingQueue<E> implements Queue<E> {

	private final List<E> list = new LinkedList<>();

	@Override
	public boolean empty() {
		if (list.size() == 0) { //wenn die Liste leer ist
			return true; //gibt true zurück
		}else {
			return false;
		}
	}

	@Override
	public E first() {
		if (empty()) { //wenn die Liste leer ist
			throw new EmptyQueueException();
		} 
		return list.get(0); //gibt das erste Element der Liste zurück
	}

	@Override
	public E enqueue(E element) {
		list.add(element); //fügt das Element am Ende der Liste hinzu
		return element;
	}

	@Override
	public E dequeue() {
		if (empty()){
			throw new EmptyQueueException();
		}

		if (list.size() > 0){
			return list.remove(0);
		} else {
			return null;
		}
		
	}
}
