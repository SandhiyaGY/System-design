// BAD: This example violates the Interface Segregation Principle (ISP)

interface RestaurantEmployee {

    void prepareFood();

    void decideMenu();

    void serveFoodAndDrinks();

    void takeOrder();

    void cleanTheKitchen();
}

// BAD: Waiter is forced to implement methods it doesn't need
class Waiter implements RestaurantEmployee {

    @Override
    public void takeOrder() {
        System.out.println("Taking order...");
    }

    @Override
    public void serveFoodAndDrinks() {
        System.out.println("Serving food and drinks...");
    }

    @Override
    public void cleanTheKitchen() {
        // Forced to implement but doesn't make sense for a waiter
        throw new AssertionError("Detail Message: Waiter cannot clean the kitchen!");
    }

    @Override
    public void prepareFood() {
        // Forced to implement but doesn't make sense for a waiter
        throw new AssertionError("Detail Message: Waiter cannot prepare food!");
    }

    @Override
    public void decideMenu() {
        // Forced to implement but doesn't make sense for a waiter
        throw new AssertionError("Detail Message: Waiter cannot decide the menu!");
    }
}

public class ViolationDemo {

    public static void main(String[] args) {

        Waiter waiter = new Waiter();

        // Works fine
        waiter.serveFoodAndDrinks();
        waiter.takeOrder();

        // These will throw exceptions
        waiter.decideMenu();       // Forced implementation
        waiter.prepareFood();      // Forced implementation
        waiter.cleanTheKitchen();  // Forced implementation
    }
}