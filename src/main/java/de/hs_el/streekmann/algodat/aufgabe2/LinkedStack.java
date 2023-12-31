package de.hs_el.streekmann.algodat.aufgabe2;


import java.util.EmptyStackException;


public class LinkedStack<E> implements Stack<E> {
	private class Node {
		E element;
		Node successor;

		Node(E element) {
			this.element = element;
			this.successor = null;
		}
	}

	private Node topItem;
	@Override
	public boolean empty() {
		//return wenn stack empty ist
		return topItem == null;
	}

	@Override
	public E peek() {
		if (empty()) {
			throw new EmptyStackException();
		} else {
			return topItem.element;
		}

	}

	@Override
	public E push(E item) {
		//pusht neues Element in den Stack
		Node newNode = new Node(item);
		newNode.successor = topItem;
		topItem = newNode;
		return item;
	}

	@Override
	public E pop() {
		//Fügt das topItem der Liste hinzu und setzt das topItem auf den Nachfolger
		if (empty()) {
			throw new EmptyStackException();
		} else {
			E item = topItem.element;
			topItem = topItem.successor;
			return item;
		}
	}
}