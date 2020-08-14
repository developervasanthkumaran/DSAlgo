package heap;

public class MaxHeap extends MinHeap {
    MaxHeap(int dSize){
        super(dSize);
    }

    @Override
    int pop(){
        int val = Integer.MAX_VALUE;
        if(heapSize>0) {
            val = items[0];
            items[0] = items[heapSize - 1];
            heapSize--;
            heapifyDown();
        }
        return val;
    }

    @Override
    void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index) && items[index] < leftChild(index)){
            int min = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) > items[min]){
                min = getRightChildIndex(index);
            }
            if(items[index] < items[min] )break;
            else swap(index,min);

            index = min;
        }
    }

    @Override
    void heapifyUp() {
        int index = heapSize-1;
        while (hasParent(index) && items[index] > parent(index)){
            int lIndex = getParentIndex(index);
            swap(index,lIndex);
            index  = lIndex;
        }

    }
}
