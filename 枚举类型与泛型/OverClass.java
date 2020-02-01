package 泛型;

public class OverClass<T> {
    //定义泛型成员变量
    private T over;
    //设置getXXX()方法
    public T getOver() {
        return over;
    }
    public void setOver(T over) {
        this.over = over;
    }
    public static void main(String args[]) {
        //实例化一个Boolean类型对象
        OverClass<Boolean> t1 = new OverClass<>();
        //实例化一个Float类型对象
        OverClass<Float> t2 = new OverClass<>();
        //不需要进行类型转换
        t1.setOver(true);
        System.out.println(t1.getOver());
        t2.setOver(12.3f);
        System.out.println(t2.getOver());
    }
}
