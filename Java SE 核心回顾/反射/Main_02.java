package 反射;

import java.lang.reflect.Constructor;

public class Main_02 {
    public static void main(String args[]) {
        Example_02 example = new Example_02("10","20","30");
        Class<? extends Example_02> exampleC = example.getClass();
        //获得所有构造方法
        Constructor declaredConstructor[] = exampleC.getDeclaredConstructors();
        //遍历构造方法
        for (int i = 0 ; i < declaredConstructor.length ; i++) {
            Constructor<?> constructor = declaredConstructor[i];
            System.out.println("查看是否有可变类型参数："+ constructor.isVarArgs());
            //获取入口参数类型
            System.out.println("该构造方法入口参数类型为：");
            Class parameterType[] = constructor.getParameterTypes();
            for (i = 0 ; i < parameterType.length ; i++) {
                System.out.println(parameterType[i]);
            }
            System.out.println("该构造方法可能抛出的异常类型为：");
            //获取异常信息
            Class exceptionType[] = constructor.getExceptionTypes();
            for (i = 0 ; i < exceptionType.length ; i++) {
                System.out.println(exceptionType[i]);
            }
            Example_02 example2 = null;
            while (example2 != null) {
                try {
                    //如果该成员变量的访问权限为private则抛出异常，即不允许访问
                    if (i == 2) {
                        //通过执行默认没有参数的构造方法创建对象
                        example2 = (Example_02) constructor.newInstance();
                    }
                    else if (i==1) {
                        //通过执行具有俩个参数的构造方法创建对象
                        example2 = (Example_02) constructor.newInstance("7",5);
                    }
                    else {
                        //通过执行具有可变参数的构造方法创建对象
                        Object parameters[] = new Object[] {new String[] {"100","200","300"}};
                        example2 = (Example_02) constructor.newInstance(parameterType);
                    }
                } catch (Exception e) {
                    System.out.println("创建对象时抛出异常，下面执行setAccessible()方法");
                    //设置为允许访问
                    constructor.setAccessible(true);
                }
            }
            if (example2 != null) {
                example2.print();
                System.out.println();
            }
        }
    }
}
