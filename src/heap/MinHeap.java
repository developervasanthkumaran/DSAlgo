package heap;

import java.util.Arrays;

public class MinHeap extends Heap {
    MinHeap(int dSize){
        super(dSize);
    }

    void add(int data){
        checkForResizing();
        items[heapSize] = data;
        heapSize++;
        heapifyUp();
    }

    private void checkForResizing(){
        if(heapSize >= dSize){
            items = Arrays.copyOf(items,dSize*2);
            dSize*=2;
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
            if(hasRightChild(index) && rightChild(index) < items[min]){
                min = getRightChildIndex(index);
            }
            if(items[min] > items[index])break;
            else swap(index,min);

            index = min;
        }
    }

    void swap(int i1,int i2){
        items[i1]^=items[i2];
        items[i2]^=items[i1];
        items[i1]^=items[i2];
    }

}
