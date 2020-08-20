package com.atguigu.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;

    //临界值
    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }


    //计算方法
    @Override
    protected Long compute() {
        if (end - start > temp) {
            Long mid = (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, mid);
            task1.fork();  //拆分任务，把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(mid + 1, end);
            task2.fork();  //拆分任务，把任务压入线程队列
            return task1.join() + task2.join();
        } else {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
