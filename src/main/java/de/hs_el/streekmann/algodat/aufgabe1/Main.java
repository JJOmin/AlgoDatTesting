package de.hs_el.streekmann.algodat.aufgabe1;
import java.util.Iterator;

public class Main {
	//public Variablen
	public static int currentCountAll = 0; //Var die die Anzahl der Listenaufrufe zählt
	public static int iteratorCountAll = 0; //Var die die Anzahl der Listenaufrufe zählt

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


		List<Integer> arrayList = new ArrayList<>();
		fillList(arrayList, numberOfElements);
		System.out.println("--- ArrayList printed in for loop  ---");
		printListInForLoop(arrayList);

		System.out.println("--- ArrayList printed in for loop with iterator ---");
		printListInForLoopWithIterator(arrayList);

		System.out.println("--- ArrayList printed in foreach loop ---");
		printListInForeachLoop(arrayList);

		System.out.println(
				"Welche Konsequenzen ziehen Sie aus den Messungen für die Verwendung von Iteratoren?"+"\n"+
						"Antwort: Der Iterator ist bei einer LinkedList deutlich Effizienter als ohne,"+
						"aber bei der ArrayList ist es egal ob mit oder ohne Iterator."
		);
		System.out.println("\n");
		System.out.println("\n");
	}

	private static <E> void printListInForLoopWithIterator(List<E> list) {
		iteratorCountAll = 0;
		for (Iterator<E> iterator = list.iterator(); iterator.hasNext();) {
			System.out.print(iterator.next() + "  ");
			iteratorCountAll = iteratorCountAll + list.getIteratorCount();

			System.out.println(" -> Aufrufe bis zum Element: "+list.getIteratorCount()+
					", kumulierte Zugriffe: "+ iteratorCountAll);
		}
		System.out.println("Insgesamte Aufrufe/Sprünge: "+iteratorCountAll);
		System.out.println("\n"); //Absatz
	}

	private static <E> void printListInForeachLoop(List<E> list) {
		for (E element : list) {
			System.out.print(element + "  ");
		}
		System.out.println("\n");
	}

	private static <E> void printListInForLoop(List<E> list) { //Übergabe von linkedList mit Elementen
		currentCountAll = 0;
		for (int i = 0; i < list.size(); i++) { //von 0 bis index des letzten Elementes der list
			System.out.print(list.get(i) + "  "); //printed jedes Element der Liste einzeln
			currentCountAll = list.getCurrentCount(i) + currentCountAll; //addiert alle aufrufe zusammen
			System.out.println(" -> Aufrufe bis zum Element: "+ list.getCurrentCount(i)+
					", kumulierte Zugriffe: "+ currentCountAll); //gibt die Anzahl der Sprünge bis zum Zielelement aus

		}
		System.out.println(" Insgesamte Aufrufe/Sprünge: "+ currentCountAll);
		System.out.println("\n"); //Macht einen Absatz
	}

	private static void fillList(List<Integer> list, int numberOfElements) { //methode, die eine Liste und Anzahl der Elemente
		for (int i = 1; i <= numberOfElements; i++) { //i mit +1 addiert, i*i z.b.(3*3) zur list hinzugefügt
			list.add(i * i);
		}
	}
}