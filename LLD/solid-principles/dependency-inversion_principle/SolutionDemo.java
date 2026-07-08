// GOOD: This example follows the Dependency Inversion Principle (DIP)

// Abstractions
interface Keyboard {
    void getSpecifications();
}

interface Mouse {
    void getSpecifications();
}

// Low-level module - Wired Keyboard
class WiredKeyboard implements Keyboard {

    private final String connectionType;
    private final String company;
    private final String modelVersion;
    private final String color;

    public WiredKeyboard(String connectionType, String company,
                         String modelVersion, String color) {
        this.connectionType = connectionType;
        this.company = company;
        this.modelVersion = modelVersion;
        this.color = color;
    }

    @Override
    public void getSpecifications() {
        System.out.println("===> Wired Keyboard");
        System.out.println("Connection Type: " + connectionType);
        System.out.println("Company: " + company);
        System.out.println("Model Version: " + modelVersion);
        System.out.println("Color: " + color);
    }
}

// Low-level module - Bluetooth Keyboard
class BluetoothKeyboard implements Keyboard {

    private final String connectionType;
    private final String company;
    private final String modelVersion;
    private final String color;

    public BluetoothKeyboard(String connectionType, String company,
                             String modelVersion, String color) {
        this.connectionType = connectionType;
        this.company = company;
        this.modelVersion = modelVersion;
        this.color = color;
    }

    @Override
    public void getSpecifications() {
        System.out.println("===> Bluetooth Keyboard");
        System.out.println("Connection Type: " + connectionType);
        System.out.println("Company: " + company);
        System.out.println("Model Version: " + modelVersion);
        System.out.println("Color: " + color);
    }
}

// Low-level module - Wired Mouse
class WiredMouse implements Mouse {

    private final String connectionType;
    private final String company;
    private final String modelVersion;
    private final String color;

    public WiredMouse(String connectionType, String company,
                      String modelVersion, String color) {
        this.connectionType = connectionType;
        this.company = company;
        this.modelVersion = modelVersion;
        this.color = color;
    }

    @Override
    public void getSpecifications() {
        System.out.println("===> Wired Mouse");
        System.out.println("Connection Type: " + connectionType);
        System.out.println("Company: " + company);
        System.out.println("Model Version: " + modelVersion);
        System.out.println("Color: " + color);
    }
}

// Low-level module - Bluetooth Mouse
class BluetoothMouse implements Mouse {

    private final String connectionType;
    private final String company;
    private final String modelVersion;
    private final String color;

    public BluetoothMouse(String connectionType, String company,
                          String modelVersion, String color) {
        this.connectionType = connectionType;
        this.company = company;
        this.modelVersion = modelVersion;
        this.color = color;
    }

    @Override
    public void getSpecifications() {
        System.out.println("===> Bluetooth Mouse");
        System.out.println("Connection Type: " + connectionType);
        System.out.println("Company: " + company);
        System.out.println("Model Version: " + modelVersion);
        System.out.println("Color: " + color);
    }
}

// GOOD: High-level module depends on abstractions
class MacBook {

    private final Keyboard keyboard;
    private final Mouse mouse;

    // Dependency Injection through constructor
    public MacBook(Mouse mouse, Keyboard keyboard) {
        this.mouse = mouse;
        this.keyboard = keyboard;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }
}

// Demo showing DIP
public class SolutionDemo {

    public static void main(String[] args) {

        // Create keyboard and mouse objects
        WiredKeyboard wiredKeyboard =
                new WiredKeyboard("USB", "Dell", "F602", "Grey");

        WiredMouse wiredMouse =
                new WiredMouse("USB", "Dell", "F602", "Grey");

        BluetoothKeyboard bluetoothKeyboard =
                new BluetoothKeyboard("Bluetooth", "Logitech", "G102", "Black");

        BluetoothMouse bluetoothMouse =
                new BluetoothMouse("Bluetooth", "Logitech", "G102", "Black");

        // Create MacBook with wired keyboard and mouse
        MacBook macBookWithWiredParts =
                new MacBook(wiredMouse, wiredKeyboard);

        macBookWithWiredParts.getKeyboard().getSpecifications();
        macBookWithWiredParts.getMouse().getSpecifications();

        System.out.println();

        // Create MacBook with Bluetooth keyboard and mouse
        MacBook macBookWithBluetoothParts =
                new MacBook(bluetoothMouse, bluetoothKeyboard);

        macBookWithBluetoothParts.getKeyboard().getSpecifications();
        macBookWithBluetoothParts.getMouse().getSpecifications();
    }
}