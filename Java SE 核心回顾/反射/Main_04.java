package 反射;

import java.lang.reflect.Method;

public class Main_04 {
    public static void main(String args[]) {
        Example_04 example = new Example_04();
        Class exampleC = example.getClass();
        //获取所有方法
        Method declaredMethods[] = exampleC.getDeclaredMethods();
        //遍历方法
        for (int i = 0; i < declaredMethods.length ; i++) {
            Method method = declaredMethods[i];
            System.out.println("该方法的名称为：" + method.getName());
            System.out.println("是否允许带有可变数量的参数：" + method.isVarArgs());
            System.out.println("入口参数类型为：");
            //获取所有参数类型
            Class parameterTypes[] = method.getParameterTypes();
            for (int j = 0; j < parameterTypes.length ; j++) {
                System.out.println(parameterTypes[j]);
            }
            //获取方法的返回值类型
            System.out.println("该方法的返回值类型为：" + method.getReturnType());
            System.out.println("可能抛出的异常类型与：");
            Class exceptionTypes[] = method.getExceptionTypes();
            for (int k = 0 ; k < exceptionTypes.length; k ++) {
                System.out.println(exceptionTypes[k]);
            }
            boolean isTrue = true;
            while (isTrue) {
                //如果该方法的访问全线为private，则抛出异常，即不允许访问
                try {
                    isTrue = false;
                    if ("staticMethod".equals(method.getName())) {
                        //执行没有参数入口的方法
                        method.invoke(example);
                    }
                    else if ("publicMethod".equals(method.getName())) {
                        System.out.println("返回值为：" + method.invoke(example,168));
                    }
                    else if ("protectedMethod".equals(method.getName())) {
                        System.out.println("返回值为：" + method.invoke(example,"7",5));
                    }
                    else if ("private".equals(method.getName())) {
                        Object parameters[] = new Object[]{new String[]{"W","Z","L"}};
                        System.out.println("返回值为：" + method.invoke(example,parameters));
                    }

                } catch (Exception e) {
                    System.out.println("在执行方法中抛出异常。"
                    + "下面执行setAccessible()方法");
                    //设置为允许访问
                    method.setAccessible(true);
                    isTrue = true;
                }
            }
        }
    }
}
