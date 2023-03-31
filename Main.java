
//Name: Enzo La
//Date: 3-27-23
//Project: Inventory Upgrade
/*Create another class called qualityControl that inherits from
the product class. The product class defined the product with three attributes-
item, price and quantity.
The qualityControl class extends the the product class with two more attributes. These attributes are
customer satisfaction and product quality. Both of these properties will be integers on a scale of 1 to
10.
In order to use the quality control class, you will need to alter the existing Inventory class. The existing arraylist of type product is now inadequate 
The arraylist needs now needs to be of type qualityControl. 
Also the main interface class needs to be altered with two more textboxes so the user can enter the customer satisfaction and product quality.

Create another method in the inventory class that returns and arraylist of products that have less than a 5 on their customer satisfaction or product quality.
 */
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main extends JFrame implements ActionListener {

    // declare our components or fields
    JTextField txtItem = new JTextField(20);
    JTextField txtPrice = new JTextField(10);
    JTextField txtQuantity = new JTextField(10);
    JTextField txtCusSatisfaction = new JTextField(10);
    JTextField txtProQuality = new JTextField(10);

    JTextArea txaOutput = new JTextArea("Item" + "\t" + "Price" + "\t" + "Quantity" + "\t" + "Customer Satisfaction:  "
            + "\t" + "Product Quality: " + "\n", 10, 30);
    JButton btnAdd = new JButton("Add item");
    JButton btnOutput = new JButton("Output Items");

    ArrayList<QualityControl> products = new ArrayList<QualityControl>();
    ArrayList<QualityControl> productsLessThan5 = new ArrayList<QualityControl>();
    
    String itemString;
    int itemCount = 0;

    public static void main(String[] args) {

        // declare our frame which is a form
        Main frame = new Main();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public Main() {
        super("Inventory");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set our layout manager
        setLayout(new FlowLayout());
        // add our components to the frame
        add(new JLabel("Item:   "));
        add(txtItem);

        add(new JLabel("Price:     "));
        add(txtPrice);

        add(new JLabel("Quantity: "));
        add(txtQuantity);

        add(new JLabel("Customer Satisfaction: "));
        add(txtCusSatisfaction);

        add(new JLabel("Product Quality"));
        add(txtProQuality);
        add(btnAdd);
        add(btnOutput);
        // add the text Area
        add(txaOutput);

        // add the liseners
        btnAdd.addActionListener(this);
        btnOutput.addActionListener(this);
        txtItem.addActionListener(this);
        txtPrice.addActionListener(this);
        txtQuantity.addActionListener(this);
        txtCusSatisfaction.addActionListener(this);
        txtProQuality.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        String itemName;
        double itemPrice;
        int itemQuantity;
        int customSatisfaction;
        int produQuality;

        Object objSource = event.getSource();

        if (objSource == btnAdd) {
            try {

                itemName = txtItem.getText();
                itemPrice = Double.parseDouble(txtPrice.getText());
                itemQuantity = Integer.parseInt(txtQuantity.getText());
                customSatisfaction = Integer.parseInt(txtCusSatisfaction.getText());
                produQuality = Integer.parseInt(txtProQuality.getText());

                QualityControl theProduct = new QualityControl(itemName, itemPrice, itemQuantity, customSatisfaction, produQuality);

                products.add(theProduct);
                itemCount++;

                // clears out the textboxes
                txtItem.setText("");
                txtPrice.setText("");
                txtQuantity.setText("");
                txtCusSatisfaction.setText("");
                txtProQuality.setText("");
                // places cursor back to starting position
                txtItem.requestFocus();
            } catch (NumberFormatException err) {
                txaOutput.setText("Date Error!");
            }
        }
        if (objSource == btnOutput) {
            if (products.size() > 0) {
                // sorts arraylist
                for (int g = products.size(); g > 1; g--) {
                    int iMax = 0;
                    for (int i = 1; i < g; i++) {
                        if (products.get(i).getItem().compareTo(products.get(iMax).getItem()) > 0) {
                            iMax = i;
                        }

                    }
                    String tempItem = products.get(iMax).getItem();
                    double tempPrice = products.get(iMax).getPrice();
                    int tempQuantity = products.get(iMax).getQuantity();
                    int tempSatis = products.get(iMax).getCusSat();
                    int tempQual = products.get(iMax).getProQua();
                    products.get(iMax).setItem(products.get(g - 1).getItem());
                    products.get(iMax).setPrice(products.get(g - 1).getPrice());
                    products.get(iMax).setQuantity(products.get(g - 1).getQuantity());
                    products.get(iMax).setCusSat(products.get(g - 1).getCusSat());
                    products.get(iMax).setPQuality(products.get(g - 1).getProQua());
                    products.get(g - 1).setItem(tempItem);
                    products.get(g - 1).setPrice(tempPrice);
                    products.get(g - 1).setQuantity(tempQuantity);
                    products.get(g - 1).setCusSat(tempSatis);
                    products.get(g - 1).setPQuality(tempQual);
                    System.out.println("sort");

                }
                // outputs arraylist
                for (int j = 0; j < products.size(); j++) {
                    txaOutput.append(products.get(j).getItem() + "\t" + products.get(j).getPrice() + "\t"
                            + products.get(j).getQuantity() + "\t" + "\t"+ products.get(j).getCusSat() + "\t" + products.get(j).getProQua() + "\n");
                }

                //txaOutput.append("Items with less than 20 quantiy that need to be ordered" + "\n");

                // outputs items with quantity less than 20
                for (int l = 0; l < products.size(); l++) {
                    if (products.get(l).getQuantity() < 20) {
                        txaOutput.append(products.get(l).getItem() + "\n");
                    }
                }
                txaOutput.append("Items with customer satisfaction or product quality less than 5" + "\n");
                for(int h = 0; h < products.size();h++)
                {
                    if(products.get(h).getCusSat() < 5 || products.get(h).getProQua() < 5)
                    {
                        QualityControl badProduct = new QualityControl(products.get(h).getItem(), products.get(h).getPrice(), products.get(h).getQuantity(), products.get(h).getCusSat(), products.get(h).getProQua());
                        productsLessThan5.add(badProduct);
                        txaOutput.append(productsLessThan5.get(h).getItem() + "\t" + productsLessThan5.get(h).getPrice() + "\t"
                        + productsLessThan5.get(h).getQuantity() + "\t" + "\t" + productsLessThan5.get(h).getCusSat() + "\t" + productsLessThan5.get(h).getProQua() + "\n");
                    }
                }


            } else {

            }
        }
    }
}