package com.zz.we.utils;

import java.util.LinkedList;

public class test {



    public static void main(String[] args) {
//        MyArrayList<String> myArrayList =new MyArrayList<>();
//        myArrayList.add("123");
//        myArrayList.add("456");
//        myArrayList.add("789");
//        myArrayList.add("111");
//        myArrayList.add("222");
//
//        for (int i=0;i<myArrayList.size();i++){
//            System.out.println(myArrayList.get(i));
//        }


//        LinkedList linkedList=new LinkedList();
//        linkedList.add("999");
//        linkedList.getFirst();
//        System.out.println(linkedList.get(0));
//        System.out.println(linkedList.get(1));

        LinkedList<String> myLinkedList =new LinkedList<>();
        myLinkedList.add("123");
        myLinkedList.add("456");
        myLinkedList.add("789");
        System.out.println(myLinkedList.getLast());
        boolean remove = myLinkedList.remove("321");
        System.out.println(remove);
        System.out.println(myLinkedList.getFirst());
        System.out.println(myLinkedList.getLast());
        System.out.println(myLinkedList.get(1));
    }
}
