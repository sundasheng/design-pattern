package com.example.concurrent;

import org.assertj.core.util.Lists;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @ClassName FutureTest
 * @Description
 * @Author sunjing
 * @Date 2020/6/11 10:34
 * @Version 1.0
 */
public class FutureTest {

    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();

        Future<Map<String,String>> future1;
        Future<Integer> future2;
        Lists.newArrayList();
        future1 = executorService.submit(rpcService::getRpcResult);
        future2 = executorService.submit(httpService::getHttpResult);

        try {
            Map<String,String> result1 = future1.get(300,TimeUnit.MILLISECONDS);
            Integer result2 = future2.get(300,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }




    static class RpcService{
        Map<String,String> getRpcResult() throws InterruptedException {
            Thread.sleep(100);
            return new HashMap<String,String>();
        }
    }

    static class HttpService {
        Integer getHttpResult() throws InterruptedException {
            Thread.sleep(200);
            return 0;
        }
    }
}
