package com.zjf.code.linkedlist.singlelinkedlist;
import org.junit.Test;

/**
 * <p>
 * 测试单链表
 * </p>
 *
 * @author zhouJianFel
 * @since 2022/11/20
 */
public class TestLinkedList {


    /**
     *  顺序插入 0 1 2 3 在头部插入 4  在2的节点前插入5 在3节点后面 插入6  在 0前面插入9 在 4后面插入15 0后面插入16 4前面插入17
     *  并移除1
     *  应打印出 17 4 15 9 0 16 5 2 3 6
     *
     */
    @Test
    public void testSingleLinkedList(){
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

    /**
     *  正向链表 4 0 1 2 3 反转后  3 2 1 0 4
     */
    @Test
    public void testSingleLinkedListReversal(){
        SingLeLinkedList linkedList = new SingLeLinkedList();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.addFirst(4);
        System.out.println("反转前:");
        linkedList.print();
        Node reversal = linkedList.reversal();
        System.out.println("反转后:");
        System.out.println(reversal);
    }


    /**
     *  链表环检测  1->2->3->4->5->3
     */
    @Test
    public void testSingleLinkedListHasCircle(){
        SingLeLinkedList linkedList = new SingLeLinkedList();
        Node node1 = new Node(1,null);
        linkedList.add(node1);
        Node node2 = new Node(2,null);
        linkedList.add(node2);
        Node node3 = new Node(3,null);
        linkedList.add(node3);
        Node node4 = new Node(4,null);
        linkedList.add(node4);
        Node node5 = new Node(5,node3);
        linkedList.add(node5);
        boolean b = linkedList.hasCircle();
        if(!b){
            linkedList.print();
        }
        System.out.println(b);
    }
}
