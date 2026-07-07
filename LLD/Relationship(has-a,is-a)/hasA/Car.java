class Engine {
    void start() {
        System.out.println("Engine started...");
    }
}

public class Car {
    // Car "has a" Engine
    private Engine engine; 

    // The engine is brought into the car
    public Car(Engine engine) {
        this.engine = engine; 
    }

    void startCar() {
        engine.start(); // Delegating the work to the Engine class
        System.out.println("Car is ready to drive!");
    }
}
