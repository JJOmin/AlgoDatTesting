package de.hs_el.streekmann.algodat.aufgabe5;

import java.util.Arrays;

//Aufgabe 5 :DD

public class SimpleHeap<E extends Comparable<E>> {
    private static final int ROOT_NODE_INDEX = 0;
    private final E[] heapArray;
    private int firstEmptyIndex;
    private int exchanges;

    @SuppressWarnings("unchecked")
    public SimpleHeap(int size){
        heapArray = (E[]) new Comparable[size];
        firstEmptyIndex = 0;
    }

    public SimpleHeap(E[] elements) {
        heapArray = elements;
        firstEmptyIndex = elements.length;
        for (int node = highestIndexWithChildren(); node >= ROOT_NODE_INDEX; node--) {
            heapify(node);
        }
    }

    private int highestIndexWithChildren() {
        return parentIndex(firstEmptyIndex);
    }


    //hier veränderung
    private void heapify(int nodeIndex) {
        if (childExistsAndIsSmaller(nodeIndex)) {
            int smallerChildIndex = getSmallerChild(nodeIndex);
            exchange(nodeIndex, smallerChildIndex);
            heapify(smallerChildIndex);
        }
    }

    private int leftChildIndex(int parentIndex){ return 2*parentIndex+1; }

    private int rightChildIndex(int parentIndex){ return 2*parentIndex+2; }

    private int parentIndex(int nodeIndex) {
        if (nodeIndex % 2 == 0)
            return nodeIndex/2-1;
        return nodeIndex/2;
    }

    private boolean childExistsAndIsSmaller(int parentIndex) {
        return childExistsAndIsSmaller(parentIndex, leftChildIndex(parentIndex)) || childExistsAndIsSmaller(parentIndex, rightChildIndex(parentIndex));
    }

    private boolean childExistsAndIsSmaller(int parentIndex, int childIndex) {
        return childIndex < heapArray.length && heapArray[childIndex] != null && heapArray[parentIndex].compareTo(heapArray[childIndex]) > 0;
    }

    private int getSmallerChild(int parentIndex){
        int leftChildIndex = leftChildIndex(parentIndex);
        int rightChildIndex = rightChildIndex(parentIndex);
        if (heapArray.length <= rightChildIndex || heapArray[rightChildIndex] == null || heapArray[leftChildIndex].compareTo(heapArray[rightChildIndex]) < 0){
            return leftChildIndex;
        }
        return rightChildIndex(parentIndex);
    }

    private boolean hasParent(int childIndex){
        return childIndex > ROOT_NODE_INDEX;
    }

    private void exchange(int firstIndex, int secondIndex){
        E temp = heapArray[firstIndex];
        //System.out.println("Tausche "+heapArray[firstIndex]+" mit "+heapArray[secondIndex]); //Hilfe zum verständniss
        heapArray[firstIndex] = heapArray[secondIndex];
        heapArray[secondIndex] = temp;
        exchanges++;
    }

    private int indexOfLastFilledNode(){
        return firstEmptyIndex-1;
    }

    //Hier veränderung

    public void insert(E element) {
       
        heapArray[firstEmptyIndex] = element;
       
        int nodeIndex = firstEmptyIndex;
        while (hasParent(nodeIndex) && heapArray[nodeIndex].compareTo(heapArray[parentIndex(nodeIndex)]) < 0) {
            exchange(nodeIndex, parentIndex(nodeIndex));
            nodeIndex = parentIndex(nodeIndex);
        }
        firstEmptyIndex++;
    }

    public E min() {
        return heapArray[ROOT_NODE_INDEX];
    }

    public E deleteMin() {
        E result = heapArray[ROOT_NODE_INDEX];
        heapArray[ROOT_NODE_INDEX] = heapArray[indexOfLastFilledNode()];
        heapArray[indexOfLastFilledNode()] = null;
        heapify(ROOT_NODE_INDEX);
        firstEmptyIndex--;
        return result;
    }

    public boolean isEmpty() {
        return firstEmptyIndex == ROOT_NODE_INDEX;
    }

    public int size() {
        return firstEmptyIndex;
    }

    public int exchanges() { return exchanges; }
}
