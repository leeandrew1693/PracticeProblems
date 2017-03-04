package datastructures.heap;

/**
 * Created by andrew on 2/19/17.
 */
public class MinHeap {
    int size;
    int[] heap;

    public MinHeap(int size) {
        heap = new int[size+1];
        size = 0;
    }

    public void insert(final int num) {
        heap[++size] = num;
        heapifyUp(size);
    }

    public int extractMin() {
        final int min = heap[1];
        heap[1] = heap[size];
        heap[size--] = 0;
        heapifyDown(1);

        return min;
    }

    public int peekMin(){
        return heap[1];
    }

    public void printHeap() {
        for(int i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void heapifyUp(final int pos) {
        if(pos == 1) {
            return;
        }

        final int parent = getParent(pos);

        if(heap[getParent(pos)] > heap[pos]) {
            int temp = heap[pos];
            heap[pos] = heap[parent];
            heap[parent] = temp;
        }
        heapifyUp(parent);
    }

    private void heapifyDown(final int pos) {
        int child = getLeftChild(pos);
        if(child > size) {
            return;
        }

        if(heap[pos] > heap[child]) {
            int temp = heap[pos];
            heap[pos] = heap[child];
            heap[child] = temp;
        }

        heapifyDown(child);
    }

    private int getParent(final int pos) {
        return pos/2;
    }

    private int getLeftChild(final int pos) {
        return pos*2;
    }
}
