package de.hs_el.streekmann.algodat.aufgabe2;

public interface Queue<E> {
	boolean empty();
	E first(); //gibt das erste Element zurück ohne es zu löschen
	E enqueue(E element); //einfügen eines Elementes
	E dequeue(); //löschen entnehmen eines Elementes
}
