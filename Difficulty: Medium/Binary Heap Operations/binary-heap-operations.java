class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;

    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }

    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return 2 * i + 1; }
    int right(int i) { return 2 * i + 2; }

    // Extract min value and fix heap
    int extractMin() {
        if (heap_size <= 0) return -1;
        if (heap_size == 1) return harr[--heap_size];

        int minVal = harr[0];
        harr[0] = harr[heap_size - 1];
        heap_size--;
        MinHeapify(0);
        return minVal;
    }

    // Insert new key into heap
    void insertKey(int k) {
        if (heap_size == capacity) {
            System.out.println("Overflow: Couldn't insert key!");
            return;
        }

        harr[heap_size] = k;
        int i = heap_size;
        heap_size++;

        while (i != 0 && harr[parent(i)] > harr[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    // Delete key at index i
    void deleteKey(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    // Decrease value at index i
    void decreaseKey(int i, int new_val) {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Heapify from index i
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if (l < heap_size && harr[l] < harr[smallest]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;

        if (smallest != i) {
            swap(i, smallest);
            MinHeapify(smallest);
        }
    }

    // Swap helper
    void swap(int a, int b) {
        int temp = harr[a];
        harr[a] = harr[b];
        harr[b] = temp;
    }
}
