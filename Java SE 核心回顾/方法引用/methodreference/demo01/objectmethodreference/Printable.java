package com.methodreference.demo01.objectmethodreference;

import java.util.stream.Stream;

/**
 *   定义一个打印的函数式接口
 */
@FunctionalInterface
public interface Printable {
    void print(String s);
}
