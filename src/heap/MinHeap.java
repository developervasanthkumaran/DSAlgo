package heap;

import java.util.Arrays;

public class MinHeap extends Heap {
    MinHeap(int Size){
        super(Size);
    }

    void add(int data){
        checkForResizing();
        items[heapSize] = data;
        heapSize++;
        heapifyUp();
    }

    private void checkForResizing(){
        if(heapSize >= defaultSize){
            items = Arrays.copyOf(items, defaultSize *2);
            defaultSize *=2;
        }
    }

    int pop(){
        int val = Integer.MIN_VALUE;
        if(heapSize>0) {
             val = items[0];
            items[0] = items[heapSize - 1];
            heapSize--;
            heapifyDown();
        }
        return val;
    }
    void heapifyUp(){
        int index = heapSize-1;
        while (hasParent(index) && items[index] < parent(index)){
            int lIndex = getParentIndex(index);
            swap(index,lIndex);
            index  = lIndex;
        }
    }

    void heapifyDown(){
        int index = 0;
        while (hasLeftChild(index) && items[index] > leftChild(index)){
            int min = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                min = getRightChildIndex(index);
            }
            if(items[min] > items[index])break;
            else swap(index,min);

            index = min;
        }
    }



}
