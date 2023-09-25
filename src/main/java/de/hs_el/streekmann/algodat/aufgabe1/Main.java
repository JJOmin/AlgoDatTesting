//Hier ist ja nichts kommentiert. Sorry aber WIR haben das anders gelernt.
//und das als 1. berührungspunkt mit Java???
package de.hs_el.streekmann.algodat.aufgabe1;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) { //Muss so gemacht werden, ist wie "def main()"

		int numberOfElements = 10; //setzt Var auf 10
		//System.out.println(args.length);
		if (args.length > 0) { //Wenn die länge von args größer Null ist
			numberOfElements = Integer.parseInt(args[0]); //ka was das hier macht, komme ich später drauf zurück
		}


		List<Integer> linkedList = new LinkedList<>(); //Erstellt neue LinkedList mit Listentyp Integer

		fillList(linkedList, numberOfElements); //liste wird mit hier 10 Elementen gefüllt
		System.out.println("--- LinkedList printed in for loop  ---");
		printListInForLoop(linkedList); //gibt jedes Element der Liste aus


		System.out.println("--- LinkedList printed in for loop with iterator ---");
		printListInForLoopWithIterator(linkedList); 

		System.out.println("--- LinkedList printed in foreach loop ---");
		printListInForeachLoop(linkedList); 

		/* 
		List<Integer> arrayList = new ArrayList<>();
		fillList(arrayList, numberOfElements);
		System.out.println("--- ArrayList printed in for loop  ---");
		printListInForLoop(arrayList);

		System.out.println("--- ArrayList printed in for loop with iterator ---");
		printListInForLoopWithIterator(arrayList);

		System.out.println("--- ArrayList printed in foreach loop ---");
		printListInForeachLoop(arrayList);
		*/
	}

	private static <E> void printListInForLoopWithIterator(List<E> list) {
		for (Iterator<E> iterator = list.iterator(); iterator.hasNext();) {
			System.out.print(iterator.next() + "  ");
			System.out.println(list.getIteratorCount());
		}
		System.out.println("\n"); //Absatz
	}

	private static <E> void printListInForeachLoop(List<E> list) {
		for (E element : list) {
			System.out.print(element + "  ");
		}
		System.out.println("\n");
	}

	private static <E> void printListInForLoop(List<E> list) { //Übergabe von linkedList mit Elementen
		for (int i = 0; i < list.size(); i++) { //von 0 bis index des letzten Elementes der list
			System.out.print(list.get(i) + "  "); //printed jedes Element der Liste einzeln
			System.out.println("Anzahl der Sprünge bis zum gewünsten Element: "+ list.getCurrentCount(i)); //gibt die Anzahl der Sprünge bis zum Zielelement aus
		}
		System.out.println("\n"); //Macht einen Absatz
	}

	private static void fillList(List<Integer> list, int numberOfElements) { //methode, die eine Liste und Anzahl der Elemente
		for (int i = 1; i <= numberOfElements; i++) { //i mit +1 addiert, i*i z.b.(3*3) zur list hinzugefügt
			list.add(i * i);
		}
	}
}
