// GOOD: This example follows the Liskov Substitution Principle (LSP)

// Base class for all bikes
abstract class Bike {

    // Every bike can accelerate and apply brakes
    public abstract void accelerate();

    public abstract void applyBrakes();
}

// Interface for vehicles that have an engine
interface Engine {

    void turnOnEngine();

    void turnOffEngine();
}

// GOOD: MotorCycle extends Bike and implements Engine
class MotorCycle extends Bike implements Engine {

    private String company;
    private boolean isEngineOn;
    private int speed;

    public MotorCycle(String company, int speed) {
        this.company = company;
        this.speed = speed;
    }

    @Override
    public void turnOnEngine() {
        isEngineOn = true;
        System.out.println("Engine is ON!");
    }

    @Override
    public void turnOffEngine() {
        isEngineOn = false;
        System.out.println("Engine is OFF!");
    }

    @Override
    public void accelerate() {
        speed += 10;
        System.out.println("MotorCycle Speed: " + speed);
    }

    @Override
    public void applyBrakes() {
        speed -= 5;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println("MotorCycle Speed: " + speed);
    }
}

// GOOD: Bicycle extends Bike only
// Since bicycles have no engine, they do not implement Engine
class Bicycle extends Bike {

    private String brand;
    private boolean hasGears;
    private int speed;

    public Bicycle(String brand, boolean hasGears, int speed) {
        this.brand = brand;
        this.hasGears = hasGears;
        this.speed = speed;
    }

    @Override
    public void accelerate() {
        speed += 10;
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

// Usage of LSP-compliant design
public class SolutionDemo {

    public static void main(String[] args) {

        // Create the objects
        MotorCycle motorCycle = new MotorCycle("Hero Honda", 10);
        Bicycle bicycle = new Bicycle("Hercules", true, 18);

        // Works fine with MotorCycle
        motorCycle.turnOnEngine();
        motorCycle.accelerate();
        motorCycle.applyBrakes();
        motorCycle.turnOffEngine();

        System.out.println();

        // Works fine with Bicycle
        bicycle.accelerate();
        bicycle.applyBrakes();
    }
}