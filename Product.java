public class Product {
    private String item;
    private double price;
    private int quantity;

    public Product(String i, double p, int q) {
        // code to initialize private data
        this.item = i;
        this.price = p;
        this.quantity = q;
    }

    public Product()
    {

    }

    public void setItem(String Name)
    {
        this.item = Name;
    }
    public void setPrice(double thePrice)
    {
        this.price = thePrice;
    }
    public void setQuantity(int theQuantity)
    {
        this.quantity = theQuantity;
    }


    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // public String toString() {
    //     // returns string to display private data
    // }
}