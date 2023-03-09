
//Name: Enzo La
//Date: 3-7-23
//Project: Inventory
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

    JTextArea txaOutput = new JTextArea("Item" + "\t" + "Price" + "\t" + "Quantity" + "\n", 10, 30);
    JButton btnAdd = new JButton("Add item");
    JButton btnOutput = new JButton("Output Items");

    ArrayList<Product> products = new ArrayList<Product>();
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
    }

    public void actionPerformed(ActionEvent event) {
        String itemName;
        double itemPrice;
        int itemQuantity;

        Object objSource = event.getSource();

        if (objSource == btnAdd) {
            try {

                itemName = txtItem.getText();
                itemPrice = Double.parseDouble(txtPrice.getText());
                itemQuantity = Integer.parseInt(txtQuantity.getText());

                Product theProduct = new Product();
                theProduct.setItem(itemName);
                theProduct.setPrice(itemPrice);
                theProduct.setQuantity(itemQuantity);

                products.add(theProduct);
                itemCount++;

                // clears out the textboxes
                txtItem.setText("");
                txtPrice.setText("");
                txtQuantity.setText("");

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
                    products.get(iMax).setItem(products.get(g - 1).getItem());
                    products.get(iMax).setPrice(products.get(g - 1).getPrice());
                    products.get(iMax).setQuantity(products.get(g - 1).getQuantity());
                    products.get(g - 1).setItem(tempItem);
                    products.get(g - 1).setPrice(tempPrice);
                    products.get(g - 1).setQuantity(tempQuantity);
                    System.out.println("sort");

                }
                //outputs arraylist
                for (int j = 0; j < products.size(); j++) {
                    txaOutput.append(products.get(j).getItem() + "\t" + products.get(j).getPrice() + "\t"
                            + products.get(j).getQuantity() + "\n");
                }

                txaOutput.append("Items with less than 20 quantiy that need to be ordered" + "\n");

                //outputs items with quantity less than 20
                for(int l = 0; l < products.size(); l++)
                {
                    if(products.get(l).getQuantity() < 20)
                    {
                        txaOutput.append(products.get(l).getItem() + "\n");
                    }
                }

            } else {

            }
        }
    }
}