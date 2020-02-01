package 泛型;

public class ArrayClass<T> {
    //定义泛型类数组
    private T array[];
    public void setArray(T array[]) {
        this.array = array;
    }
    //获取成员数组
    public T[] getArray() {
        return array;
    }
    public static void main(String args[]) {
        ArrayClass<String> t = new ArrayClass<>();
        String[] array = {"成员1", "成员2", "成员3"};
        t.setArray(array);
        for (int i = 0; i < t.getArray().length; i++) {
            System.out.println(t.getArray()[i]);
        }
    }
}
