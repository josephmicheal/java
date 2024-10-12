package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {

	@Async("myAsyncPoolTaskExecutor")
    public void sendEmail() throws InterruptedException {
        long t1 = System.currentTimeMillis();
        Thread.sleep(2000);
        long t2 = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+" Sending an email took " + (t2-t1) + " ms");
    }
}