package com.thoughthealer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

public class App extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.route().handler(StaticHandler.create("webroot"));

        vertx.createHttpServer()
             .requestHandler(router)
             .listen(8080, http -> {
                 if (http.succeeded()) {
                     System.out.println("Thought Healer Website running at http://localhost:8080");
                 } else {
                     System.out.println("Server failed: " + http.cause());
                 }
             });
    }

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new App());
    }
}
