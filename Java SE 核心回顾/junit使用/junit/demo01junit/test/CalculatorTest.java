package com.junit.demo01junit.test;

import com.junit.demo01junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /**
     *   初始化方法
     *     用于申请资源，所有测试方法在执行之前都会执行该方法
     */
    @Before
    public void init() {
        System.out.println("init...");
    }

    /**
     *   释放资源方法
     *     在所有测试方法执行完之后，都会自动执行该方法
     */
    @After
    public void close() {
        System.out.println("close...");
    }

    /**
     *   add测试方法
     */
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int res = calculator.add(1,3);
        //创建断言,判断预期值和具体值是否有差别
        Assert.assertEquals(10, res);
        System.out.println(res);
    }

}
