package example;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class PointToPoint {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();

    EventBus bus = vertx.eventBus();

    bus.consumer("address", message -> {
       System.out.println("Message received " + message.body() + " (" + Thread.currentThread().getName() + ")");
    });

    vertx.setPeriodic(1000, l -> {
       bus.send("address", "hello");
    });

  }

}
