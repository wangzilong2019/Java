package com.annotation.demo01annotation.TestFramework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *   简单的测试框架
 *    当主方法执行时，会检测所有加上Check注解的方法，判断是否有异常，记录到文件中
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        //创建对象
        Calculator c = new Calculator();
        //获取文件字节码对象
        Class cls = c.getClass();
        //获取所有方法
        Method[] methods = cls.getMethods();

        //创建存储异常文件
        BufferedWriter buw = new BufferedWriter(new FileWriter("bug.txt"));

        //出现异常的次数
        int num = 0;
        for (Method method : methods) {
            //判断上述方法是否有Check注解
            if (method.isAnnotationPresent(Check.class)) {
                //有，则执行
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //捕获异常
                    num++;
                    buw.write(method.getName() + "方法出异常了");
                    buw.newLine();
                    buw.write("异常名称：" + e.getCause().getClass().getSimpleName());
                    buw.newLine();
                    buw.write("异常原因：" + e.getCause().getMessage());
                    buw.newLine();
                    buw.write("--------------");
                    buw.newLine();
                }
            }
        }

        buw.write("本次测试共出现" + num + "次异常");
        buw.flush();
        buw.close();
    }
}
