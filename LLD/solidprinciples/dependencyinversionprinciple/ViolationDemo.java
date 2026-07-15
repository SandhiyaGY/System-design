

// BAD: This example violates the Dependency Inversion Principle (DIP)

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

// BAD: High-level module directly depends on concrete classes
class MacBook {

    private final WiredKeyboard keyboard;
    private final WiredMouse mouse;

    public MacBook(WiredKeyboard wiredKeyboard, WiredMouse wiredMouse) {
        this.keyboard = wiredKeyboard;
        this.mouse = wiredMouse;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }
}

// Demo showing DIP violation
public class ViolationDemo {

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

        // Create MacBook with wired devices
        MacBook macBookWithWiredParts =
                new MacBook(wiredKeyboard, wiredMouse);

        macBookWithWiredParts.getKeyboard().getSpecifications();
        System.out.println();
        macBookWithWiredParts.getMouse().getSpecifications();

        // Cannot create MacBook with Bluetooth devices because
        // MacBook depends directly on WiredKeyboard and WiredMouse.
        // The following code will NOT compile:

        /*
        MacBook macBookWithBluetoothParts =
                new MacBook(bluetoothKeyboard, bluetoothMouse);
        */
    }
}