package ProxyPattern2;

import java.util.Random;

public class Car implements Moveable {
    @Override
    public void move() throws InterruptedException {
        System.out.println("正在行驶...");
        Thread.sleep(new Random().nextInt(1000));
    }
}
