package com.mycompany;

import com.mycompany.app.Whatever;
import io.reactivex.rxjava3.core.*;

public class App {
    public static void main(String[] args) {

        Whatever whatever = new Whatever();
        Observable<String> obsv = whatever.gamesForSale();

        //subscribing to Observalbing
        obsv.subscribe(
                // we got 3 lambdas

                //data for sending
                data -> System.out.println("We got some data: " + data),
                //error handling
                error -> System.out.println("Error occured..." + error),
                //for handling completition
                () -> System.out.println("We are done... Thank You for the data...")
        );
    }
}