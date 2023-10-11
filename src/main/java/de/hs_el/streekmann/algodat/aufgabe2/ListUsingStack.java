package de.hs_el.streekmann.algodat.aufgabe2;

import java.util.EmptyStackException;

import de.hs_el.streekmann.algodat.aufgabe1.LinkedList;
import de.hs_el.streekmann.algodat.aufgabe1.List;

public class ListUsingStack<E> implements Stack<E> {

	private final List<E> list = new LinkedList<>();
	private E topItem;

	@Override
	public boolean empty() {
		if (list.size() == 0 || topItem == null) { //wenn die Liste leer ist
			return true; //gibt true zurück
		}else {
			return false;
		}
	}

	@Override
	public E peek() {
		if (list.size() == 0) {
			throw new EmptyStackException();
		}
		return topItem;
	}

	@Override
	public E push(E item) { 
		//Hinzugügen zu liste und setzen des topItems
		list.add(item);
		topItem = item;
		return topItem;
	}

	@Override
	public E pop() {
		if (list.size() == 0) { //wenn die Liste größer als 1 ist
			throw new EmptyStackException(); //wirft eine Exception
		} 
		E item = list.remove(list.size()-1); //löscht das letzte Element der Listete
			
		if (list.size() < 1) { //wenn die Liste genau 1 Element hat
			topItem = null; //setzt das topItem auf null
		} else {
			topItem = list.get(list.size() -1); //setzt das topItem auf das letzte Element der Liste
		}
		return item;
	}
}
