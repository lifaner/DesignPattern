package BuilderPattern;

public class VegBurger extends Burger {

    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public float price() {
        return 6.0f;
    }
}

class ChickenBurger extends Burger{
    @Override
    public float price() {
        return 12.5f;
    }

    @Override
    public String name() {
        return "ChickenBurger";
    }
}
