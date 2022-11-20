package com.zjf.code.linkedlist.singlelinkedlist;

/**
 * <p>
 * 测试单链表
 * </p>
 *
 * @author zhouJianFel
 * @since 2022/11/20
 */
public class Test {
    public static void main(String[] args) {
        /**
         *  顺序插入 0 1 2 3 在头部插入 4  在2的节点前插入5 在3节点后面 插入6  在 0前面插入9 在 4后面插入15 0后面插入16 4前面插入17
         *  并移除1
         *  应打印出 17 4 15 9 0 16 5 2 3 6
         *
         */
        SingLeLinkedList linkedList = new SingLeLinkedList();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.addFirst(4);
        Node node2 = linkedList.getByValue(2);
        linkedList.linkBefore(5, node2);
        Node node3 = linkedList.getByValue(3);
        linkedList.linkAfter(6, node3);
        Node node0 = linkedList.getByValue(0);
        linkedList.linkBefore(9,node0);
        Node node4 = linkedList.getByValue(4);
        linkedList.linkAfter(15,node4);
        linkedList.linkAfter(16,node0);
        linkedList.linkBefore(17,node4);
        linkedList.remove(1);
        linkedList.print();
    }
}
