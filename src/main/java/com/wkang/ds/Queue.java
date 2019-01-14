package com.wkang.ds;

import java.util.LinkedList;

/**
 * @author wkang
 * @date 2019/1/14
 */
public class Queue {

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] array = {1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }
        System.out.println(queue.peek());

        System.out.println(queue.poll());

        System.out.println(queue.peek());
    }

}
