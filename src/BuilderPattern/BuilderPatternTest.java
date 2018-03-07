package BuilderPattern;

public class BuilderPatternTest {
        public static void main(String[] args) {
            MealBuilder mealBuilder = new MealBuilder();

            Meal vegMeal = mealBuilder.prepareVegMeal();
            System.out.println("Veg Meal");
            vegMeal.showItem();
            System.out.println("Total Cost: " +vegMeal.getCost());

            Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
            System.out.println("\n\nNon-Veg Meal");
            nonVegMeal.showItem();
            System.out.println("Total Cost: " +nonVegMeal.getCost());
        }
}
