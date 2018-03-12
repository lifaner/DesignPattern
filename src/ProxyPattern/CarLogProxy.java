package ProxyPattern;

public class CarLogProxy implements Moveable {

    private Moveable m ;

    public CarLogProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("开始记录日志...");
        m.move();
        System.out.println("结束记录日志...");
    }
}
