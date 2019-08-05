package com.zz.we.utils;

public class MyLinkedList<E> {

    private int size;

    //第一个元素
    private Node<E> first;

    //最后一个元素
    private Node<E> last;

    //双向链表
    private static class Node<E>{
        private E e;

        private Node<E> pre;

        private Node<E> next;

        public Node(E e, Node<E> pre, Node<E> next) {
            this.e = e;
            this.pre = pre;
            this.next = next;
        }
    }

    //获取元素个数
    public int size(){
        return size;
    }

    public boolean add(E e){
        size++;
        //先判断是否有元素
        if(first==null){
            first=new Node<E>(e,null,null);
            return true;
        }

        if(last==null){
            last=new Node<E>(e,first,null);
            first.next=last;
            return true;
        }

        Node node =new Node(e,last,null);
        last.next=node;
        last=node;
        return true;
    }

    public E getFirst(){
        return first.e;
    }

    public E getLast(){
        return last.e;
    }

    public E get(int index){
        if(index>=size)
            throw new RuntimeException("你妹的越界了!");
        Node<E> node =first;
        for (int i=0;i<size;i++){
            if(i==index)
                break;
            node=node.next;
        }
        return node.e;
    }

    public boolean remove(E e){
        //第一种情况符合删除条件
        Node<E> var1 = first;
        if(var1.e.equals(e)){
            first= var1.next;
            first.pre=null;
            return true;
        }

        //第二种情况符合删除条件
        Node<E> var3 = last;
        if(var3.e.equals(e)){
            last=var3.pre;
            last.next=null;
            return true;
        }

        //第三种情况符合删除条件
        Node<E> var2;
        for(int i=0;i<size;i++) {
            var2 = var1.next;
            var2.e.equals(e);

        }

        return false;
    }
}
