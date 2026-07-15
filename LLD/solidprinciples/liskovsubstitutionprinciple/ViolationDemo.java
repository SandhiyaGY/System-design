// BAD: This example violates the Liskov Substitution Principle (LSP)

interface Bike {

    void turnOnEngine();

    void turnOffEngine();

    void accelerate();

    void applyBrakes();
}

// Motorcycle implements all Bike behaviors
class MotorCycle implements Bike {

    private String company;
    private boolean isEngineOn;
    private int speed;

    public MotorCycle(String company, int speed) {
        this.company = company;
        this.speed = speed;
        this.isEngineOn = false;
    }

    @Override
    public void turnOnEngine() {
        isEngineOn = true;
        System.out.println("Engine is ON");
    }

    @Override
    public void turnOffEngine() {
        isEngineOn = false;
        System.out.println("Engine is OFF");
    }

    @Override
    public void accelerate() {
        speed += 10;
        System.out.println("MotorCycle Speed: " + speed);
    }

    @Override
    public void applyBrakes() {
        speed -= 10;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println("MotorCycle Speed: " + speed);
    }
}

// BAD: Bicycle is forced to implement engine-related methods
class Bicycle implements Bike {

    private String brand;
    private int speed;

    public Bicycle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    @Override
    public void turnOnEngine() {
        throw new AssertionError("Detail Message: Bicycle has no engine!");
    }

    @Override
    public void turnOffEngine() {
        throw new AssertionError("Detail Message: Bicycle has no engine!");
    }

    @Override
    public void accelerate() {
        speed += 5;
        System.out.println("Bicycle Speed: " + speed);
    }

    @Override
    public void applyBrakes() {
        speed -= 5;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println("Bicycle Speed: " + speed);
    }
}

// Demonstrates the LSP violation
public class ViolationDemo {

    public static void main(String[] args) {

        MotorCycle motorCycle = new MotorCycle("Honda", 40);
        Bicycle bicycle = new Bicycle("Hero", 10);

        // Works correctly
        motorCycle.turnOnEngine();
        motorCycle.accelerate();
        motorCycle.turnOffEngine();

        // Works correctly
        bicycle.accelerate();
        bicycle.applyBrakes();

        // LSP violation: Bicycle cannot behave like every Bike
        bicycle.turnOnEngine();   // Throws AssertionError
        bicycle.turnOffEngine();  // Throws AssertionError
    }
}