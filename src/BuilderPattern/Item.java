package BuilderPattern;

/**
 * 食物条目 包装 价格 接口
 */
public interface Item {

    public String name();

    public Packing packing();

    public float price();
}