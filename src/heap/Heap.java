package heap;

class Heap {
     int heapSize, defaultSize;
     int[] items;

    private Heap(){ }

    public Heap(int defaultSize){
        heapSize = 0;
        this.defaultSize = defaultSize;
        items = new int[defaultSize];
    }

    int rightChild(int index){
        return items[getRightChildIndex(index)];
    }
    int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }
    int parent(int index){
        return items[getParentIndex(index)];
    }
    int getLeftChildIndex(int index){
        return (2*index)+1;
    }
    int getRightChildIndex(int index){
        return (2*index)+2;
    }
    int getParentIndex(int index){
        return (index-1)/2;
    }
    boolean hasParent(int index){
        int in = getParentIndex(index);
         return in >= 0 && in < heapSize;
    }
    boolean hasLeftChild(int index){
        int in = getLeftChildIndex(index);
        return in > 0  && in < heapSize;
    }
    boolean hasRightChild(int index){
        int in = getRightChildIndex(index);
        return in > 0 && in < heapSize;
    }

    void showHeapItems(){
        for (int item : items) {
            System.out.print(item+" ");
        }
        System.out.println();
    }

    void swap(int i1,int i2){
        items[i1]^=items[i2];
        items[i2]^=items[i1];
        items[i1]^=items[i2];
    }

}
