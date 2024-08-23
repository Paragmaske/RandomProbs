package Streams;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Optionals {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<String> futures = CompletableFuture.supplyAsync(()->{
            try {
                System.out.println("start");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello world ");
            return "success";
        }).exceptionally(x-> x.getMessage());
        System.out.println(futures.get());


        CompletableFuture<Void> futures2 = CompletableFuture.supplyAsync(()->{
            try {
                System.out.println("start");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello world ");
            return "success";
        }).thenApply(x->x.toUpperCase())
                .thenAccept(System.out::println)
                .exceptionally(x-> {
                    System.out.println(x);
                    return null;
                });
        System.out.println(futures2.get());

    }
}
