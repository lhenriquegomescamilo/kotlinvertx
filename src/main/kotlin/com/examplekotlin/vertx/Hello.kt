package com.examplekotlin.vertx

import io.vertx.core.Vertx
import io.vertx.ext.web.Router

fun main(args: Array<String>) {
    println("Hello, World")

    val vertx = Vertx.vertx()
    val httpServer = vertx.createHttpServer()
    val router = Router.router(vertx)

    router.route().handler { routingContext ->
        routingContext
                .response().putHeader("content-type", "text/plain")
                .setChunked(true)
                .write("I'm worktin with kotlin")
                .end()
    }

    httpServer
            .requestHandler(router::accept)
            .listen(8080)
}

