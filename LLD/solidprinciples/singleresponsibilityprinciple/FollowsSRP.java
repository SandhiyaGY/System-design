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

// Responsibility 1: Managing Invoice data only
class Invoice {
    private Marker marker;
    private int quantity;
    private int total;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    // Business logic
    public void calculateTotal() {
        System.out.println("Calculating total...");
        this.total = this.marker.price * this.quantity;
    }

    public int getTotal() {
        return total;
    }
}

// Responsibility 2: Managing Database Operations only
class InvoiceDao {
    private Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDB() {
        // Save the invoice into the database
        System.out.println("Saving to DB...");
    }
}

// Responsibility 3: Printing the Invoice only
class InvoicePrinter {
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void print() {
        // Print the invoice
        System.out.println("Printing Invoice...");
        System.out.println("Total = " + invoice.getTotal());
    }
}

// Usage example showing how all classes work together
public class FollowsSRP {
    public static void main(String[] args) {

        Invoice invoice = new Invoice(
                new Marker("Camlin", "Blue", 10, 2020),
                10
        );

        InvoiceDao invoiceDao = new InvoiceDao(invoice);
        InvoicePrinter invoicePrinter = new InvoicePrinter(invoice);

        invoice.calculateTotal();
        invoiceDao.saveToDB();
        invoicePrinter.print();
    }
}