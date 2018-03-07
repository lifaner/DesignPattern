package BuilderPattern;

import java.util.ArrayList;

public class Meal {

    private ArrayList<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = (float) items.stream().mapToDouble(Item::price).sum();
        return cost;
    }

    public void showItem(){
        items.forEach(x ->{
            System.out.println("名称："+x.name()+" 包装："+x.packing().pack()+" 价格："+x.price());
        });
    }

}
