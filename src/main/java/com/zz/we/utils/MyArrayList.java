package com.zz.we.utils;

import java.util.Arrays;

/**
 * 数组扩容
 * 数组 元素
 * @param <e>
 */
public class MyArrayList<e> {

    //默认容器存放数量
    private static final int DEFAULT_CAPACITY=10;

    //实际存放对象的容器
    private Object[] array;

    //默认初始数组
    private static final Object[] DEFAULT_ELEMENT={};

    //数组实际长度
    private int size=0;

    //数组操作次数
    private int modcount;

    //无参构造
    public MyArrayList(){
        this.array =DEFAULT_ELEMENT;
    }

    //有参构造
    public MyArrayList(int initcapacity){
        if(initcapacity>0){
            this.array=new Object[initcapacity];
        }else if(initcapacity==0){
            this.array =DEFAULT_ELEMENT;
        }else{
            throw new RuntimeException("有错误!");
        }
    }

    public e get(int Index){
     checkIndex(Index);
     return getIndex(Index);
    }

    private e getIndex(int index) {
        return (e)array[index];
    }

    public boolean add(e e){
        //判断是否需要扩容
        ensureCapacityInternal(size+1);
        array[size++]=e;
        return true;
    }

    private void ensureCapacityInternal(int initcapacity) {
        int oldsize=array.length;
        if(initcapacity>oldsize){
            int newsize=oldsize+oldsize>>1;
            if(newsize<DEFAULT_CAPACITY){
                newsize=DEFAULT_CAPACITY;
            }
           array = Arrays.copyOf(array,newsize);
        }
    }

    private void checkIndex(int index) {
        if(index >= size){
            throw new RuntimeException("Illeger number："+index);
        }
    }

    public void remove(int i){
        checkIndex(i);
        System.arraycopy(array,i+1,array,i,size-i-1);
    }

    public int size(){
        return size;
    }
}
