package me.dennis.course.p114;

/**
 * 复现内存泄露，该类中 pop方法会产生内存泄露
 * 该方法只做了两件事：
 *      1.修改size属性，即记录栈内元素减1
 *      2.返回elementData数组索引为size-1的元素
 *  之所以会产生泄露，是因为size虽然减1了，但并未
 *  清除elementData数组最后一个元素的引用
 */
public class MemoryLeakStackTest {

    private Object[] elementData; // 存放栈内元素的数组
    private int size = 0;
    private int capacityIncrement;

    public MemoryLeakStackTest(int initialCapacity){
        elementData = new Object[initialCapacity];
    }
    public MemoryLeakStackTest(int initialCapacity , int capacityIncrement){
        this(initialCapacity);
        this.capacityIncrement = capacityIncrement;
    }
    public void push(Object object){
        ensureCapacity();
        elementData[size++] = object;
    }

    public Object pop(){
        if(size == 0){
            throw new RuntimeException("空栈异常");
        }
//      return elementData[--size];       // 会产生内存泄露的代码
        Object ele = elementData[--size];
        elementData[size] = null;
        return ele;
    }

    public int size(){
        return size;
    }

    private void ensureCapacity(){
        //增加堆栈的容量
        if(elementData.length == size){

            Object[] oldElements = elementData;
            int newLength = 0;

            if(capacityIncrement > 0){
                newLength = elementData.length + capacityIncrement;
            } else {
                newLength = (int)(elementData.length * 1.5);
            }
            elementData = new Object[newLength];
            // 将原数组的元素复制到新数组中
            System.arraycopy(oldElements,0,elementData,0,size);
        }
    }

    public static void main(String[] args){

        MemoryLeakStackTest stackTest = new MemoryLeakStackTest(10);
        for(int i=0;i<10;i++){
            stackTest.push("元素"+i);
        }
        System.out.println("入栈后length="+stackTest.elementData.length+",入栈后size="+stackTest.size);
        //依次弹出
        for(int i=0;i<10;i++){
            System.out.println(stackTest.pop());
        }
        System.out.println("出栈后length="+stackTest.elementData.length+",出栈后size="+stackTest.size);
    }
}
