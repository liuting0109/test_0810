package SRDC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Author: liuting
 * @Date: 2024/8/9 14:45
 * @Description:
 */
public class Test2 {
    public static class Product {

        private int id;

        private String title;

        private String detail;
        //set get方法省略

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDetail() {
            return detail;
        }
    }

    public static void main(String[] args) throws Exception {
//        testEmbedFuture();
//        testComposeFuture();

        testFuture6();
    }

    public static class ProductDetailService {

        private static final Map<Integer,String> map = new HashMap<>();
        static {
            map.put(1,"架构大课-详情图内容");
            map.put(2,"海量数据项目大课-详情图内容");
            map.put(3,"高并发架构大课-详情图内容");
            map.put(4,"在线教育平台-详情图内容");
            map.put(5,"小滴课堂永久会员-详情图内容");
            map.put(6,"java入门到放弃-详情图内容");
            map.put(7,"颈椎病康复指南-详情图内容");
        }

        public String getById(int id){
            try {
                Thread.sleep(1000);
                System.out.println("DetailService # getById方法运行线程："+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return map.get(id);
        }

    }


    public static class ProductService {

        private static final Map<Integer,String> map = new HashMap<>();
        static {
            map.put(1,"架构大课");
            map.put(2,"海量数据项目大课");
            map.put(3,"高并发架构大课");
            map.put(4,"在线教育平台");
            map.put(5,"小滴课堂永久会员");
            map.put(6,"java入门到放弃");
            map.put(7,"颈椎病康复指南");
        }

        public String getById(int id){
            try {
                Thread.sleep(1000);
                System.out.println("ProductService#getById方法运行线程："+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return map.get(id);
        }

    }


    //之前的方案， 方法的返回值也是CompletableFuture，则会出现嵌套
    public static void testEmbedFuture() throws Exception {

        ProductService productService = new ProductService();
        ProductDetailService detailService = new ProductDetailService();

        int id = 1;
        CompletableFuture<CompletableFuture<Product>> future = CompletableFuture.supplyAsync(() -> {
            String title = productService.getById(id);
            Product product = new Product();
            product.setTitle(title);
            product.setId(id);
            return product;
        }).thenApply(new Function<Product, CompletableFuture<Product>>() {
            @Override
            public CompletableFuture<Product> apply(Product product) {
                return CompletableFuture.supplyAsync(() -> {
                    //用到了上个线程的返回值
                    String detail = detailService.getById(product.getId());
                    product.setDetail(detail);
                    return product;
                });
            }
        });

        System.out.println("线程：" + Thread.currentThread().getName() +
                " 结果：" + future.get().get().toString());
    }


    //现在的方案
    public static void testComposeFuture() throws Exception {

        ProductService productService = new ProductService();
        ProductDetailService detailService = new ProductDetailService();

        int id = 1;
        CompletableFuture<Product> future = CompletableFuture.supplyAsync(() -> {
            String title = productService.getById(id);
            Product product = new Product();
            product.setTitle(title);
            product.setId(id);
            return product;
        })
                .thenCompose(product -> CompletableFuture.supplyAsync(() -> {
                    String detail = detailService.getById(product.getId());
                    product.setDetail(detail);
                    return product;

                }));

        System.out.println("线程：" + Thread.currentThread().getName() +
                " 结果：" + future.get().toString());
    }

    public static void testFuture6() throws Exception {

        ProductService productService = new ProductService();
        ProductDetailService detailService = new ProductDetailService();

        int id = 1;
        //第1个任务
        CompletableFuture<Product> baseProductFuture = CompletableFuture.supplyAsync(() -> {
            String title = productService.getById(id);
            Product product = new Product();
            product.setTitle(title);
            product.setId(id);
            return product;
        });

        //第2个任务
        CompletableFuture<Product> detailProductFuture = CompletableFuture.supplyAsync(() -> {
            String detail = detailService.getById(id);
            Product product = new Product();
            product.setDetail(detail);
            product.setId(id);
            return product;
        });


        //将上面2个任务的返回结果baseProduct和detailProduct合并，返回新的包括全部的
        CompletableFuture<Product> resultFuture = baseProductFuture
                .thenCombine(detailProductFuture,
                        new BiFunction<Product, Product, Product>() {
                            @Override
                            public Product apply(Product base, Product detail) {
                                base.setDetail(detail.getDetail());
                                return base;
                            }
                        }
                );

        System.out.println("线程：" + Thread.currentThread().getName() +
                " 结果：" + resultFuture.get().toString());

    }
}
