package 泛型;

public class Test {
    //此类中使用向上转型为Object类型
    //定义Object雷姓成员变量
    private Object b;
    //设置相应的getXXX()方法
    public Object getB() {
        return b;
    }
    public void setB(Object b) {
        this.b = b;
    }
    public static void main(String args[]) {
        Test t = new Test();
        //向上转型操作
        t.setB(new Boolean(true));
        System.out.println(t.getB());
        t.setB(new Float(12.3));
        //向下转型操作
        Float f = (float) (t.getB());
        System.out.println(f);
    }
}
