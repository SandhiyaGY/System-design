// GOOD: This example follows the Interface Segregation Principle (ISP)

// Focused interface for Chef responsibilities
interface ChefTasks {
    void prepareFood();
    void decideMenu();
}

// Focused interface for Waiter responsibilities
interface WaiterTasks {
    void serveFoodAndDrinks();
    void takeOrder();
}

// Focused interface for Maintenance responsibilities
interface MaintenanceTasks {
    void cleanTheKitchen();
    void restockGroceries();
}

// GOOD: Chef only implements the tasks related to a chef
class Chef implements ChefTasks {

    @Override
    public void prepareFood() {
        System.out.println("Preparing food...");
    }

    @Override
    public void decideMenu() {
        System.out.println("Deciding menu...");
    }
}

// GOOD: Waiter only implements the tasks related to a waiter
class Waiter implements WaiterTasks {

    @Override
    public void serveFoodAndDrinks() {
        System.out.println("Serving food and drinks...");
    }

    @Override
    public void takeOrder() {
        System.out.println("Taking order...");
    }
}

// Usage example following ISP
public class SolutionDemo {

    public static void main(String[] args) {

        // Create the objects
        Chef chef = new Chef();
        Waiter waiter = new Waiter();

        // Chef performs only chef-related tasks
        chef.decideMenu();
        chef.prepareFood();

        // Waiter performs only waiter-related tasks
        waiter.takeOrder();
        waiter.serveFoodAndDrinks();
    }
}
