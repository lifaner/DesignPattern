package BuilderPattern;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 5.0f;
    }
}

class Pepsi extends ColdDrink {
    @Override
    public float price() {
        return 5.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}