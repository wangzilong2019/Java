package com.file.demo01file.buffered;

/**
 *   java.io.BufferedReader extends Reader
 *        int read()
 *           读取单个字符。
 *        int read(char[] cbuf, int off, int len)
 *           将字符读入数组的某一部分。
 *        void close()
 *           关闭该流并释放与之关联的所有资源。
 *      构造方法：
 *         BufferedReader(Reader in)
 *           创建一个使用默认大小输入缓冲区的缓冲字符输入流。
 *         BufferedReader(Reader in, int sz)
 *           创建一个使用指定大小输入缓冲区的缓冲字符输入流。
 *      参数：
 *         传递FileReader，给它增加一个缓冲区，提高FileReader的读取效率
 *      特有的成员方法：
 *         String readLine()
 *           读取一个文本行。
 *         返回值：包含该行内容的字符串，不包含任何终止符，如果已到达流末尾，则返回null
 */
public class Demo04BufferedReader {
}
