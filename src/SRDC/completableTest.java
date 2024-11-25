package SRDC;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: liuting
 * @Date: 2024/8/9 14:22
 * @Description:
 */
public class completableTest {
    public static void main(String[] args) throws Exception {

        String time = "1730374990000";
        System.out.println(System.currentTimeMillis());
        System.out.println(Math.abs(Long.parseLong(time) - System.currentTimeMillis()) / 1000);
        boolean a = Math.abs(Long.parseLong(time) - System.currentTimeMillis()) / 1000 > 60;
        System.out.println(a);
        testFuture2();


        System.out.println("主线程操作其他----");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("主线程执行完成");
    }


    //简单案例
    public static void testFuture2() throws ExecutionException, InterruptedException {

        //有返回值,默认使用ForkJoinPool.commonPool() 作为它的线程池执行异步代码
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) { }
            System.out.println(Thread.currentThread()+"执行，返回 二当家小D");
            return "二当家小D,";
        });
        System.out.println("future1返回值:" + future1.get()); //输出 二当家小D
    }



    //任务编排案例，有返回值
    public static void testFuture3() throws ExecutionException, InterruptedException, TimeoutException {

        //有返回值,默认使用ForkJoinPool.commonPool() 作为它的线程池执行异步代码
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->{
            System.out.println("执行任务一");
            return "冰冰一,";
        });

        //有返回值,当前任务正常完成以后执行，当前任务的执行的结果会作为下一任务的输入参数
        CompletableFuture<String> future2 = future1.thenApply((element) -> {
            System.out.println("入参："+element);
            System.out.println("执行任务二");
            return "冰冰二";
        });

        System.out.println("future2返回值:" + future2.get(1, TimeUnit.SECONDS));

    }



    //任务编排案例，无返回值
    public static void testFuture4() throws ExecutionException, InterruptedException, TimeoutException {

        //有返回值,默认使用ForkJoinPool.commonPool() 作为它的线程池执行异步代码
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() ->{
            System.out.println("执行任务一");
            return "冰冰一,";
        });

        //无返回值,当前任务正常完成以后执行,当前任务的执行结果可以作为下一任务的输入参数
        CompletableFuture<Void> future2 = future1.thenAccept((element) -> {
            System.out.println("入参："+element);
            System.out.println("执行任务二");

        });

        //System.out.println("future2返回值:" + future2.get(1, TimeUnit.SECONDS));
        System.out.println("future2返回值:" + future2.get());

    }
}
