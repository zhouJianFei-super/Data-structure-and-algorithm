package com.zjf.code.linkedlist.singlelinkedlist;

/**
 * <p>
 *  表示链表中的一个节点 包含数据和后继指针俩部分
 * </p>
 *
 * @author zhouJianFel
 * @since 2022/11/20
 */
public class Node {
    /**
     *  数据
     */
    public int data;

    /**
     * 后继指针
     */
    public Node next;

    /**
     *  构造函数
     */
    public Node(int data,Node next){
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
