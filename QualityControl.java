public class QualityControl extends Product {
    /*
     * Create another class called qualityControl that inherits from
     * the product class. The product class defined the product with three
     * attributes-
     * item, price and quantity.
     * The qualityControl class extends the the product class with two more
     * attributes. These attributes are
     * customer satisfaction and product quality. Both of these properties will be
     * integers on a scale of 1 to
     * 10.
     * In order to use the quality control class, you will need to alter the
     * existing Inventory class. The existing arraylist of type product is now
     * inadequate
     * The arraylist needs now needs to be of type qualityControl.
     * Also the main interface class needs to be altered with two more textboxes so
     * the user can enter the customer satisfaction and product quality.
     * 
     * Create another method in the inventory class that returns and arraylist of
     * products that have less than a 5 on their customer satisfaction or product
     * quality.
     */
    private int customerSatisfaction;
    private int productQuality;

    QualityControl(String itemQ, double priceQ, int quantityQ, int cusSatisfactionQ, int proQualityQ) {
        super(itemQ, priceQ, quantityQ);
        customerSatisfaction = cusSatisfactionQ;
        productQuality = proQualityQ;
    }
   
    public void setCusSat(int thisSat) {
        customerSatisfaction = thisSat;
    }

    public void setPQuality(int thisQuality) {
        productQuality = thisQuality;
    }
    public int getCusSat() {
        return customerSatisfaction;
    }

    
    public int getProQua() {
        return productQuality;
    }

}
