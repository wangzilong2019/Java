package com.file.demo01file;

import java.io.File;

public class Demo01File {
    /**
     *   路径名称不区分的大小写
     *      在windows中\代表分隔符，要以转义字符行式体现即\\
     *
     * */
    public static void main(String[] args) {
        //路径分隔符;
        String path = File.pathSeparator;
        System.out.println(path);

        //文件名称分隔符
        /**
         *  windows:  \
         *  lunix:  /
         *    注意：在文件操作时分割符不要写死了
         * */
        String seperator = File.separator;
        System.out.println(seperator);
    }
}
