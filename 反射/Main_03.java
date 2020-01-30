package 反射;

import java.lang.reflect.Field;

public class Main_03 {
    public static void main(String args[]) {
        Example_03 example =  new Example_03();
        Class exampleC = example.getClass();
        //获取所有的成员变量
        Field declaredFields[] = exampleC.getDeclaredFields();
        //遍历成员变量
        for (int i = 0; i < declaredFields.length; i++) {
            Field field1 = declaredFields[i];
            //获取成员变量名称
            System.out.println("成员变量名为："+field1.getName());
            //获取成员变量类型
            Class field1Type = field1.getType();
            System.out.println("成员变量类型为："+field1Type);
            boolean isTrue = true;
            while (isTrue) {
                //如果该成员变量访问权限为private，则抛出异常，即不允许访问
                try {
                    isTrue = false;
                    //获取成员变量值
                    System.out.println("修改前的成员变量值为：" + field1.get(example));
                    //判断成员变量类值类型是否为int类型
                    if (field1Type.equals(int.class)) {
                        System.out.println("利用方法setInt()修改成员变量值");
                        field1.setInt(example,168);
                        //判断成员变量值是否为float类型
                    } else if (field1Type.equals(float.class)) {
                        System.out.println("利用setFloat()方法修改成员变量值");
                        field1.setFloat(example,189.88f);
                        //判断成员变量类型是否为boolean类型
                    } else if (field1Type.equals(boolean.class)) {
                        System.out.println("利用setBoolean()方法修改成员变量的值");
                        field1.setBoolean(example,true);
                    } else {
                        System.out.println("利用set()方法修改成员变量的值");
                        //利用set()方法修改，可以为各种类型
                        field1.set(example,"WZL");
                    }
                    System.out.println("修改后的成员变量值为：" + field1.get(example));
                } catch (Exception e) {
                    System.out.println("在设置成员变量值时抛出异常。"+
                            "下面执行setAccessible()方法");
                    //设置访问允许
                    field1.setAccessible(true);
                    isTrue = true;
                }
            }
            //System.out.println();
        }
    }

}
