package de.hs_el.streekmann.algodat.aufgabe5;
import de.hs_el.streekmann.algodat.aufgabe4.measurement.SortAlgorithmMeasurer;
import java.util.Iterator;

public class Main {
    
    private static SortAlgorithmMeasurer measurer = new SortAlgorithmMeasurer();
    private static int NUMBER_OF_ELEMENTS = 7;
    public static void main(String[] args) {
        Integer[] zufällig = SortAlgorithmMeasurer.createValues(NUMBER_OF_ELEMENTS, SortAlgorithmMeasurer.Order.RANDOM);
        Integer[] sortetiert = SortAlgorithmMeasurer.createValues(NUMBER_OF_ELEMENTS, SortAlgorithmMeasurer.Order.ASCENDING);
        Integer[] rückwärtsSortiert =  SortAlgorithmMeasurer.createValues(NUMBER_OF_ELEMENTS, SortAlgorithmMeasurer.Order.DESCENDING);
        
       
        heapVarianten(zufällig, "Zufällig");
        System.out.println("\n");
        //System.out.print("Sortiert ");
        heapVarianten(sortetiert, "Sortiert");
        System.out.println("\n");
        //System.out.print("Rückwärts Sortiert ");
        heapVarianten(rückwärtsSortiert, "Rückwärts Sortiert");
        System.out.println("\n");
        heapn();
    }
    private static void heapVarianten(Integer[] array, String name) {
        System.out.println("----------------------");
       
        SimpleHeap<Integer> iterativHeap = new SimpleHeap<>(array.length);
        System.out.println(name+" & Iterativ: ");
         
        for (int i = 0; i < array.length; i++) {
            iterativHeap.insert(array[i]);
	    }
        System.out.println("Exchanges: " + iterativHeap.exchanges());
        System.out.println("\n");
		System.out.println(name+" & Block:");
        SimpleHeap<Integer> blocktHeap = new SimpleHeap<>(array);
        System.out.println("Exchanges: " + blocktHeap.exchanges());
        System.out.println("----------------------");
        
        
}
private static void heapn() {
    int n = 1; //Betrachtungsraum
    int ex = 1;
    

    System.out.println("|   n    | Anzahl Vertauschungen iterativ	 | 	Anzahl Vertauschungen geblockt |\n|:------:|:-------------------------------:|:-------------------------------:|");
    for (int i = 0; i < 16; i++) {
        //gernerieren des n (oder m hier)
        ex = (int) Math.pow(2,i);
        n = (n)+(ex) ;
        int m = n-1;

        //erstellen der Arrays (damit er wieder neu anfängt)
        Integer[] Array = SortAlgorithmMeasurer.createValues(m, SortAlgorithmMeasurer.Order.DESCENDING);
        Integer[] array1 = Array;
        Integer[] array2 = Array;
        SimpleHeap<Integer> iterativHeap = new SimpleHeap<>(array1.length);
        
        //einfügen der Werte
        for (int j = 0; j < array1.length; j++) {
            iterativHeap.insert(array1[j]);
            
         }
        SimpleHeap<Integer> blocktHeap = new SimpleHeap<>(array2);
        System.out.println("|  "+m +" |" + iterativHeap.exchanges() + " |" + blocktHeap.exchanges() + " |");
        
    }
   
}
}

