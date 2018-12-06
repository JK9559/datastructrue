package com.wkang.ds;


/**
 * @author kangwei
 * @date 2018/12/6
 * 最小堆
 */
public class Heap {

    private int maxLen = 16;
    private int lastIndex = 0;
    private int[] heapArray = new int[maxLen];

    Heap() {
        for (int i = 0; i < heapArray.length; i++) {
            heapArray[i] = Integer.MIN_VALUE;
        }
    }

    public void shiftUp(int key) {
        // min top heap
        if (lastIndex + 1 >= maxLen) {
            int[] tmpArray = new int[maxLen * 2];
            for (int i = 0; i < tmpArray.length; i++) {
                tmpArray[i] = Integer.MIN_VALUE;
            }
            System.arraycopy(heapArray, 0, tmpArray, 0, lastIndex + 1);
            heapArray = tmpArray;
            maxLen *= 2;
        }
        heapArray[++lastIndex] = key;
        int curIndex = lastIndex;
        int parent = curIndex / 2;
        while (heapArray[parent] > heapArray[curIndex]) {
            int tmp = heapArray[parent];
            heapArray[parent] = heapArray[curIndex];
            heapArray[curIndex] = tmp;
            curIndex = parent;
            parent = curIndex / 2;
        }
    }

    public void shiftDown() {
        int startIndex = 1;
        int leftIndex = startIndex * 2;
        int rightIndex = startIndex * 2 + 1;
        while (leftIndex <= lastIndex && (heapArray[startIndex] > heapArray[leftIndex] || heapArray[startIndex] > heapArray[rightIndex])) {
            int tmpIndex = heapArray[leftIndex] < heapArray[rightIndex] ? leftIndex : rightIndex;
            int tmp = heapArray[tmpIndex];
            heapArray[tmpIndex] = heapArray[startIndex];
            heapArray[startIndex] = tmp;
            startIndex = tmpIndex;
            leftIndex = startIndex * 2;
            rightIndex = startIndex * 2 + 1;
        }
    }

    public int popTop() {
        int top = heapArray[1];
        heapArray[1] = heapArray[lastIndex--];
        shiftDown();
        return top;
    }

    public static void main(String[] args) {
        Heap hp = new Heap();
        int[] hpData = {-9, 8, 7, 5, 1, 1, 3, -1, 1, 1, 2};
        for (int i : hpData) {
            hp.shiftUp(i);
        }

        for (int i = 0; i < hpData.length; i++) {
            System.out.println("minNum: " + hp.popTop());
            System.out.println("=================");
        }
    }

}
