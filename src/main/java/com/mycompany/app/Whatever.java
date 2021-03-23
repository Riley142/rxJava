package com.mycompany.app;
import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;

public class Whatever {

    public Observable<String> gamesForSale() {
        List<String> games = Arrays.asList(
                "game1",
                "game2",
                "game3"
        );
        return Observable.create(emmiter -> {
            //set index to 0;
            int i = 0;
            System.out.println("Start sending games");
            //while loop

            // ask if emitter is on disposed meaning:
            // subscriber could bue unsubscribed
            // in that case inDisposed would be true
            // then we shouldn't send data anyway

            //if the index is lower than game.size
            // to make sure we don't get index out of bound exepction
            while (!emmiter.isDisposed() && i < games.size()) {
              //  here we get our game
                String game = games.get(i);
                //onNext sends data one by one
                emmiter.onNext(game);
                //increment index with each run of the loop
                i++;
            }
            System.out.println("Done game sending");
            //tells  that no more next calls will occur, emission complete
            emmiter.onComplete();
        });
    }
}

//noticed in this program thrre is no onError