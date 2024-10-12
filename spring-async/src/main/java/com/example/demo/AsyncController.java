package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AsyncController {

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("/register")
    public void register() throws InterruptedException {
        long t1 = System.currentTimeMillis();
        // Simulate the time required for user registration.
        Thread.sleep(20);
        // Registration is successful. Send an email.
        asyncTask.sendEmail();
        long t2 = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+" Registering a user took " + (t2-t1) + " ms");
    }
}