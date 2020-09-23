package domain.test_month9;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @Author LT
 * @Date 2020/9/19 21:26
 * @Version 1.0
 * @Description
 */
//多线程
public class t920 {
    static volatile int flag = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(new thread1());
        Thread t2 = new Thread(new thread2());
        t1.start();
        t2.start();
    }
    class tt extends Thread{

    }
    public static class thread1 implements Runnable{
        @Override
        public void run() {
            int[] A = {1,2,3};
            int i = 0;
            while ( i < A.length) {
                if (flag == 0){
                    System.out.println(A[i]);
                    flag = 1;
                    i++;
                }
            }


        }
    }

    public static class thread2 implements Runnable{
        @Override
        public void run() {
            int[] B = {4,5,6};
            int j = 0;
            while (j < B.length) {
                if (flag == 1) {
                    System.out.println(B[j]);
                    flag = 0;
                    j++;
                }
            }
        }
    }
}

