package ProxyPattern.Cglib;

public class CglibTest {

    public static void main(String[] args) {

        CglibProxy cp = new CglibProxy();
        Train train = (Train) cp.getProxy(Train.class);
        train.move();
    }
}
