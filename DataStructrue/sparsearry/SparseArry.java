package sparsearry;

import java.io.*;

public class SparseArry {
    public static void main (String args[]) {
        //创建File类对象
        File file = new File("word2.txt");
        //创建二维数组
        int[][] chessArry = new int[11][11];
        //存放非0数据
        chessArry[1][2] = 1;
        chessArry[2][3] = 2;
        //数组原始的二维数组，并记录有效数据个数
        int sum = 0;
        for (int[] row : chessArry) {
            for (int data : row) {
                System.out.printf("%4d", data);
                if (data != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        //根据数据创建稀疏数组
        int [][] sparseArry = new int [sum+1][3];
        //将二维数组值赋值到稀疏数组
        sparseArry[0][0] = 11;
        sparseArry[0][1] = 11;
        sparseArry[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArry[i][j] != 0) {
                    count++;
                    sparseArry[count][0] = i;
                    sparseArry[count][1] = j;
                    sparseArry[count][2] = chessArry[i][j];
                }
            }
        }
        //将稀疏数组写文文件中
        try {
            //文件不存在建议文件
            if (!file.exists()) {
                file.createNewFile();
            }
            //创建FileWriter类对象
            FileWriter fileWriter = new FileWriter(file);
            //创建BufferedWriter类对象
            BufferedWriter bufw = new BufferedWriter(fileWriter);
            //将数组中的数据写入文件中
            for (int [] row : sparseArry) {
                for (int data : row) {
                    //将每个元素转化为字符串形式
                    //bufw.write(String.valueOf(data));
                    bufw.write(data + "\t");
                }
                //换行
                //bufw.newLine();
                bufw.write("\r\n");
            }
            //关闭流
            fileWriter.close();
            bufw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建数组来存放文件中的数据
        int[][] arr2 = new int[3][3];
        //将文件中的数据读取出来
        try {
            //创建FileReader类对象
            FileReader fileReader = new FileReader(file);
            //创建BufferedReader类对象
            BufferedReader bufr = new BufferedReader(fileReader);
            //创建字符串变量
            String s = null;
            int row = 0;
            //若·文本行数不为null则进去循环
            while ((s = bufr.readLine()) != null) {
                //System.out.println(s);
                String[] temp = s.split("\t");
                for (int i = 0; i < temp.length; i++) {
                    arr2[row][i] = Integer.parseInt(temp[i]);
                }
                row++;
            }
            //关闭流
            fileReader.close();
            bufr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int[] row : arr2) {
            for (int data : row) {
                System.out.printf("%4d",data);
            }
            System.out.println();
        }


        //输出稀疏数组中的值
        for (int i = 0 ; i < sparseArry.length; i++) {
            System.out.printf("%4d%4d%4d\n",sparseArry[i][0],sparseArry[i][1],sparseArry[i][2]);
        }
        //将稀疏数组存入到二维数组
        int[][] chessArry2 = new int[sparseArry[0][0]][sparseArry[0][1]];
        //遍历稀疏数组
        for (int i = 1; i < sparseArry.length; i++) {
            chessArry2[sparseArry[i][0]][sparseArry[i][1]] = sparseArry[i][2];
        }
        //输出二维数组
        for (int [] row : chessArry2) {
            for (int data : row) {
                System.out.printf("%4d",data);
            }
            System.out.println();
        }


    }
}
