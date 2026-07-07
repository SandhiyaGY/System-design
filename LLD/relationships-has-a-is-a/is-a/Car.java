// Parent Class (Superclass)
class Vehicle {
    int speed = 60;

    void move() {
        System.out.println("The vehicle is moving.");
    }
}

// Child Class (Subclass) - Car "IS A" Vehicle
class Car extends Vehicle {
    int numberOfDoors = 4;

    void honk() {
        System.out.println("Beep beep!");
    }
}