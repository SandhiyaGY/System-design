// Responsibility: Managing DB Operations only
// public class InvoiceDaoOld {

//     private Invoice invoice;

//     public InvoiceDaoOld(Invoice invoice) {
//         this.invoice = invoice;
//     }

//     public void saveToDB() {
//         // Save the invoice into the database
//         System.out.println("Saving to DB...");
//     }
// }


// After modification of InvoiceDao
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

class Invoice {
    private Marker marker;
    private int quantity;
    private int total;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public void calculateTotal() {
        System.out.println("Calculating total...");
        this.total = marker.price * quantity;
    }
}

// BAD: This class violates the Open-Closed Principle (OCP)
// Every new save method requires modifying this class.
class InvoiceDao {

    private Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    // Save into the database
    public void saveToDB() {
        System.out.println("Saving to DB...");
    }

    // Save into a file
    public void saveToFile() {
        System.out.println("Saving to File...");
    }

    // If we later need this method, we must modify this class
    /*
    public void saveToMongoDB() {
        System.out.println("Saving to MongoDB...");
    }
    */
}

// Usage example showing the problem
public class ViolatesOCP {

    public static void main(String[] args) {

        Invoice invoice = new Invoice(
                new Marker("Camlin", "Blue", 10, 2020),
                10
        );

        invoice.calculateTotal();

        InvoiceDao databaseFileSave = new InvoiceDao(invoice);

        // Save to Database
        databaseFileSave.saveToDB();

        // Save to File
        databaseFileSave.saveToFile();

        // Problem:
        // If we want to add saveToMongoDB(), saveToCloud(), etc.,
        // we need to modify InvoiceDao every time.
        // This violates the "Closed for Modification" principle of OCP.
    }
}