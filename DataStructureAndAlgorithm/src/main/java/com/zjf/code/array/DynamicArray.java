package com.zjf.code.array;

/**
 * <p>
 * 手动实现动态数组
 * </p>
 *
 * @author zhouJianFel
 * @since 2022/8/11
 */
public class DynamicArray<T> {

    /**
     * 用于存放数据的数组
     */
    private transient Object[] elementData;


    /**
     * 数组的最小长度
     */
    private final int DEFAULT_CAPACITY = 5;


    /**
     * 动态数组元素数量
     */
    private int size;


    /**
     * 数组默认初始化
     */
    private static final Object[] EMPTY = {};


    /**
     * <p>
     * 默认初始化时,指定数组最小长度
     * </p>
     *
     * @author zhouJianFel
     */
    public DynamicArray() {
        elementData = EMPTY;
    }


    /**
     * <p>
     * 指定数组大小初始化
     * </p>
     *
     * @param initCapacity 初始化容量
     * @throws IllegalArgumentException 错误传参异常
     * @author zhouJianFel
     */
    public DynamicArray(int initCapacity) {
        if (initCapacity <= 0)
            throw new IllegalArgumentException("initCapacity is Must be greater than zero");
        elementData = new Object[initCapacity];
    }


    /**
     * <p>
     * 根据 index 得到数组里面的一个元素
     * </p>
     *
     * @param index 访问的偏移量
     * @return T 当前偏移量下的元素
     * @author zhouJianFel
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        //检查下标是否合法
        checkIndex(index);
        return (T) elementData[index];
    }


    /**
     * <p>
     * 添加一个元素
     * </p>
     *
     * @param element 待添加的元素
     * @author zhouJianFel
     */
    public void add(T element) {
        //先确保长度是否已经满了 如果满了则扩容
        ensureExpandCapacity(size + 1);
        elementData[size++] = element;
    }


    /**
     * <p>
     *  从动态数组中移除一个元素
     * </p>
     * @param  index 要移除元素的偏移量
     * @author zhouJianFel
     */
    public void remove(int index){
        //检查当前偏移量
        checkIndex(index);
        //计算当前位置后面有多少个元素
        int offset = size-index -1;
        //把index后面的元素迁移到index位置上
        System.arraycopy(elementData,index+1,elementData,index,offset);
        //通知GC回收最后一位空位置
        elementData[--size] = null;
    }


    /**
     * <p>
     * 检查当前index是否合法
     * </p>
     *
     * @param index 是否合法的index
     * @author zhouJianFel
     */
    private void checkIndex(int index) {
        if (index >= size)
            throw new IllegalArgumentException("index >= ArrayLength");
    }


    /**
     * <p>
     * 确认长度并扩容
     * </p>
     *
     * @param minCapacity 数组需要最小的长度
     * @author zhouJianFel
     */
    public void ensureExpandCapacity(int minCapacity) {
        //如果当前数组长度为0则给赋予最小长度5
        if(elementData.length == 0)
            elementData = new Object[DEFAULT_CAPACITY];
        //如果当前需要的最小长度已经大于数组长度 则进行扩容
        if (minCapacity > elementData.length)
            expandCapacity(minCapacity);
    }


    /**
     * <p>
     * 执行扩容操作
     * </p>
     * <p>
     * 当当前数组已经不足以继续添加元素执行扩容操作,扩容到之前的1.5倍
     * </p>
     *
     * @param minCapacity 需要的数组最小长度
     * @author zhouJianFel
     */
    public void expandCapacity(int minCapacity) {
        //原数组长度
        int originLength = elementData.length;
        //扩容后的长度
        int newLength = originLength + (originLength >> 1);
        //新数组
        Object[] newElementData = new Object[newLength];
        //数组拷贝
        System.arraycopy(elementData, 0, newElementData, 0, originLength);
        //重新指定elementData
        elementData = newElementData;
    }


    /**
     * 重写ToString
     */
    @Override
    public String toString() {
        StringBuilder dyArray =new StringBuilder();
        dyArray.append("[");
        for (int i = 0;i<size;i++){
            if(i != size-1){
                dyArray.append(elementData[i]);
                dyArray.append(",");
            }else{
                dyArray.append(elementData[i]);
            }
        }
        dyArray.append("]");
        return dyArray.toString();
    }

    public static void main(String[] args) {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("zjf");
        dynamicArray.add("lyr");
        dynamicArray.add("mmm");
        dynamicArray.add("ccc");
        dynamicArray.add("kkk");
        dynamicArray.add("ppp");
        dynamicArray.remove(3);
        System.out.println(dynamicArray);
    }


}
