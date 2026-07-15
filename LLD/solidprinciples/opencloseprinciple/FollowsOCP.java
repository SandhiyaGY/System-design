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

// GOOD: Following OCP using interfaces and polymorphism
interface InvoiceDao {
    void save();
}

// Concrete implementation for Database InvoiceDao
class DatabaseInvoiceDao implements InvoiceDao {

    private Invoice invoice;

    public DatabaseInvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public void save() {
        // Save into the database
        System.out.println("Saving to DB...");
    }
}

// Concrete implementation for File InvoiceDao
// NEW File Save Operation: Extension without modifying existing code
class FileInvoiceDao implements InvoiceDao {

    private Invoice invoice;

    public FileInvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public void save() {
        // Save into the file
        System.out.println("Saving to File...");
    }
}

// Usage demonstrating OCP compliance
public class FollowsOCP {

    public static void main(String[] args) {

        Invoice invoice = new Invoice(
                new Marker("Camlin", "Blue", 10, 2020),
                10
        );

        invoice.calculateTotal();

        InvoiceDao databaseInvoiceDao = new DatabaseInvoiceDao(invoice);
        databaseInvoiceDao.save();   // Save to DB

        InvoiceDao fileInvoiceDao = new FileInvoiceDao(invoice);
        fileInvoiceDao.save();       // Save to File

        // The system is:
        // OPEN for extension (new save methods can be added)
        // CLOSED for modification (existing code remains unchanged)
    }
}