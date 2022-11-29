package com.zjf.code.stack;

/**
 * <p>
 * 顺序栈的实现
 * </p>
 *
 * @author zhouJianFel
 * @since 2022/11/27
 */
public class ArrayStack {
    /**
     * 栈数组
     */
    public String[] items;

    /**
     * 栈的大小
     */
    public int size;

    /**
     * 栈的元素的个数
     */
    public int count;

    public ArrayStack(int size) {
        if (size <= 0) throw new IllegalArgumentException(" size is must >0");
        this.items = new String[size];
        this.size = size;
        this.count = 0;
    }


    /**
     * 入栈
     */
    public void push(String item) {
        if (this.count == size) throw new IllegalArgumentException("stack is full");
        this.items[this.count] = item;
        count++;
    }

    /**
     * 出栈
     */
    public String pop() {
        if (count == 0) return null;
        String res = items[count - 1];
        items[count-1] = null;
        count--;
        return res;
    }

    public void print(){
        for (String item:
             items) {
            System.out.println(item);
        }
    }


    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push("我");
        arrayStack.push("爱");
        arrayStack.push("中");
        arrayStack.push("国");
        arrayStack.print();
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}
