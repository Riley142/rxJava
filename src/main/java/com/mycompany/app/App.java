package com.mycompany;

import io.reactivex.rxjava3.core.*;

public class App {
    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);
    }
}