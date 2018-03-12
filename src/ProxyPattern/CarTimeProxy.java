package ProxyPattern;

public class CarTimeProxy implements Moveable {

    private Moveable m;

    public CarTimeProxy(Moveable m){
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("汽车开始行驶...");
        long startTime = System.currentTimeMillis();
        m.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶... 行驶时间" + (endTime - startTime) + "毫秒");
    }
}
