class Marker {
    String name;
    String color;
    int price;
    int year;

    public Marker(String name, String color, int price, int year) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.year = year;
    }
}

// BAD: This class violates SRP by having multiple responsibilities
class Invoice {
    private Marker marker;
    private int quantity;
    private int total;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    // Responsibility 1: Calculate the total (business logic)
    public void calculateTotal() {
        System.out.println("Calculating total...");
        this.total = this.marker.price * this.quantity;
        System.out.println("Total = " + total);
    }

    // Responsibility 2: Database Operations
    public void saveToDB() {
        System.out.println("Saving to DB...");
    }

    // Responsibility 3: Print the Invoice
    public void printInvoice() {
        System.out.println("Printing Invoice...");
    }
}

// Usage example
public class VioalatesSRP {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(
                new Marker("Camlin", "Blue", 10, 2020),
                10
        );

        invoice.calculateTotal();
        invoice.saveToDB();
        invoice.printInvoice();
    }
}