package com.zjf.code.linkedlist.singlelinkedlist;

/**
 * <p>
 * 表示一个 单链表   提供单链表的增加一个节点、删除一个节点、插入一个节点、查找一个节点操作
 * </p>
 * <p>
 * 单链表 的插入 移除 查找 都要注意头节点的处理 ！！！
 * </p>
 *
 * @author zhouJianFel
 * @since 2022/11/20
 */
public class SingLeLinkedList {
    /**
     * 头节点
     */
    private Node head = null;

    /**
     * 插入一个节点 如果没指定那么就在尾节点插入
     */
    public void add(int e) {
        linkLast(e);
    }

    /**
     * 插入一个节点 尾插
     */
    public void add(Node e) {
        linkLast(e);
    }

    /**
     * 插入一个节点 在头部插入
     */
    public void addFirst(int e) {
        linkFirst(e);
    }

    /**
     * 在指定节点后面插入
     */
    public void linkAfter(int e, Node p) {
        if (p == null) return;
        if (head == null) return;
        if (p != head) {
            //判断p是否在链表中
            Node q = head;
            while (q.next != null && q.next != p) {
                q = q.next;
            }
            //如果q.next == null 证明已经到了尾节点 也未查到p
            if (q.next == null) return;
        }
        p.next = new Node(e, p.next);
    }

    /**
     * 在指定节点前面插入
     */
    public void linkBefore(int e, Node p) {
        if (p == null) return;
        //如果p是头节点
        if (p == head) {
            head = new Node(e, head);
        } else {
            //如果p不是头节点 且头节点为不为null
            Node q = head;
            //如果头节点指向为null 证明空链表 也不存在p节点
            if (q == null) return;
            //查找p前面的节点  如果出现q.next = null 说明到了尾节点也没找p
            while (q.next != null && q.next != p) {
                q = q.next;
            }
            //如果结束了循环 q.next = null
            if (q.next == null) return;
            //剩下就一种情况 即 q.next != null 且 q.next == p
            q.next = new Node(e, q.next);
        }
    }

    /**
     * 头部插入一个节点
     */
    public void linkFirst(int e) {
        //如果头节点为空 直接创建一个后继指针为null的新节点
        if (head == null) {
            head = new Node(e, null);
        } else {
            //如果头节点不为空 先把新节点指向头节点  在私有变量 头节点 指向新节点
            head = new Node(e, head);
        }
    }

    /**
     * 顺序插入 即 尾部插入
     */
    public void linkLast(int e) {
        //先创建一个节点
        Node eLast = new Node(e, null);
        //如果头节点为空 让头节点指向新节点
        if (head == null) {
            head = eLast;
        } else {
            //如果头节点不为空，遍历链表 直到某个节点的后继指针为null。
            Node h = head;
            while (h.next != null) {
                h = h.next;
            }
            //将尾几点指向 新节点
            h.next = eLast;
        }
    }

    /**
     * 顺序插入 即 尾部插入
     */
    public void linkLast(Node e) {
        if (e == null) return;
        //如果头节点为空 让头节点指向新节点
        if (head == null) {
            head = e;
        } else {
            //如果头节点不为空，遍历链表 直到某个节点的后继指针为null。
            Node h = head;
            while (h.next != null) {
                h = h.next;
            }
            //将尾几点指向 新节点
            h.next = e;
        }
    }


    /**
     * 移除一个节点
     */
    public void remove(int e) {
        //头节点为空 空链表 直接返回
        if (head == null) return;
        //如果是头节点等于 e
        if (head.data == e) {
            head = head.next;
        } else {
            //不是头节点且不为空 遍历链表
            Node q = head;
            while (q.next != null && q.next.data != e) {
                q = q.next;
            }
            if (q.next == null) return;
            //将指向q的指向 e 后面的节点
            q.next = q.next.next;
        }
    }

    /**
     * 移除一个节点
     */
    public void remove(Node e) {
        //头节点为空 空链表 直接返回
        if (head == null) return;
        //如果e是头节点
        if (head == e) {
            head = head.next;
        } else {
            //查找后继指针 指向e的节点
            Node q = head;
            while (q.next != null && q.next != e) {
                q = q.next;
            }
            if (q.next == null) return;
            //将指向q的指向 e 后面的节点
            q.next = q.next.next;
        }
    }

    /**
     * 通过第几个节点
     */
    public Node get(int index) {
        //头节点为空 空链表 直接返回
        if (head == null) return null;
        if (index < 0) return null;
        //遍历节点
        Node q = head;
        int offset = 0;
        while (q.next != null && offset != index) {
            q = q.next;
            ++offset;
        }
        if (q.next == null) return null;
        return q.next;
    }

    /**
     * 根据int值查找node
     */
    public Node getByValue(int value) {
        //头节点为空 空链表 直接返回
        if (head == null) return null;
        if (head.data == value) {
            return head;
        }
        //不是头节点 且链表不为空 遍历所有节点
        Node q = head;
        while (q.next != null && q.next.data != value) {
            q = q.next;
        }
        if (q.next == null) return null;
        return q.next;
    }

    /**
     * 链表反转
     * 循环遍历所有节点 新建一个链表 然后头插法
     */
    public Node reversal() {
        if (head == null) return null;
        return doReversal(head);
    }

    public Node reversal(Node tar) {
        if (tar == null) return null;
        return doReversal(tar);
    }

    private Node doReversal(Node tar) {
        //头节点
        Node q = tar;
        //反转头节点
        Node rHead = null;
        //循环
        while (q.next != null) {
            //第一个节点
            if (rHead == null) {
                rHead = new Node(q.data, null);
            } else {
                //头插法指向头节点
                rHead = new Node(q.data, rHead);
            }
            q = q.next;
        }
        //最后一个节点
        rHead = new Node(q.data, rHead);
        return rHead;
    }


    /**
     * 检测怀检测
     * 通过快慢指针法
     */
    public boolean hasCircle() {
        if (head == null) return false;
        //快指针
        Node fast = head;
        //慢指针
        Node slow = head;
        //循环检测
        while (fast != null && fast.next != null) {
            //先走快指针
            fast = fast.next.next;
            //走慢指针
            slow = slow.next;
            //判断是否有追上
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将列表有序合并到当前列表
     * 实现思路:
     * 1.将俩个列表都按同一个顺序排序 例如全是正序排 或者 倒序排
     * 2.比较链表的头部 如果第一链表比第二个链表头部小 开始循环第一个链表直到比第二链表大为止 然后循环往复 每一个最小值都插入到新链表中
     * 3.注意插入新链表的时候 需要有一个引用来动态往下走 防止链表到头
     */
    public Node sequentialMerge(Node tar) {
        if (head == null || tar == null) {
            return head != null ? head : tar;
        }
        //判断递增顺序 全部改为从小到递增
        Node on = head;
        Node tw = tar;
        if (on.next != null && on.data > on.next.data) {
            on = reversal(on);
        }
        if (tw.next != null && tw.data > tw.next.data) {
            tw = reversal(tw);
        }
        Node res = new Node(0, null);
        Node cur = res;
        //比较头节点
        while (on != null && tw != null) {
            if (on.data < tw.data) {
                while (on != null && on.data < tw.data) {
                    cur.next = new Node(on.data, null);
                    cur = cur.next;
                    on = on.next;
                }
            } else {
                while (tw != null && on.data > tw.data) {
                    cur.next = new Node(tw.data, null);
                    cur = cur.next;
                    tw = tw.next;
                }
            }
        }
        if(on != null){
            cur.next = on;
        }
        if(tw != null){
            cur.next = tw;
        }
        return res.next;
    }


    /**
     * 打印所有节点
     */
    public void print() {
        Node q = head;
        if (head != null) {
            while (q.next != null) {
                System.out.println(q.data);
                q = q.next;
            }
            //打印最后一个节点
            System.out.println(q.data);
        }

    }


}
