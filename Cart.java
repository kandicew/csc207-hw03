package com.mcfarevee.shopping;

import java.io.PrintWriter;
import java.util.ArrayList;
import com.mcfarevee.groceries.Item;
import com.mcfarevee.groceries.ManyPackage;
import com.mcfarevee.groceries.Unit;
import com.mcfarevee.groceries.Package;

public class Cart {
  // field
  ArrayList<Item> cart;

  // constructor
  public Cart() {
    this.cart = new ArrayList<Item>();
  }


  // add an item to the cart
  public void addItem(Item someitem) {
    this.cart.add(someitem);
  }// addItem(Item)

  // get the number of things in the cart
  public int numThings() {
    int num = 0;
    for (int i = 0; i < this.cart.size(); i++) {
      if (this.cart.get(i) instanceof ManyPackage) {
        ManyPackage temp = (ManyPackage) this.cart.get(i);
        num += temp.getCount();
      } else {
        num += 1;
      }
    }
    return num;
  }// numThings()

  // get the number of entries
  public int numEntries() {
    return this.cart.size();
  }// numEntries

  // print the contents
  public void printContents(PrintWriter pen) {
    for (int i = 0; i < this.cart.size(); i++) {
      pen.println(this.cart.get(i).toString());
    }
  }// printContents(PrintWriter)

  // compute the total price
  public int getPrice() {
    int price = 0;
    for (int i = 0; i < this.cart.size(); i++) {
      price += this.cart.get(i).getPrice();
    }
    return price;
  }// getPrice

  public int[] getWeight() {
    int[] weights = new int[] {0, 0, 0, 0};
    for (int i = 0; i < this.cart.size(); i++) {
      if (this.cart.get(i).getWeight().getUnit().abbrev().equals("gm.")
          || this.cart.get(i).getWeight().getUnit().plural().equals("grams")
          || this.cart.get(i).getWeight().getUnit().tString().equals("gram")) {
        weights[0]++;
      } else if (this.cart.get(i).getWeight().getUnit().tString().equals("kilogram")
          || this.cart.get(i).getWeight().getUnit().abbrev().equals("kg.")
          || this.cart.get(i).getWeight().getUnit().plural().equals("kilograms")) {
        weights[1]++;
      } else if (this.cart.get(i).getWeight().getUnit().tString().equals("ounce")
          || this.cart.get(i).getWeight().getUnit().abbrev().equals("oz.")
          || this.cart.get(i).getWeight().getUnit().plural().equals("ounces")) {
        weights[2]++;
      } else {
        weights[3]++;
      }
    }
    return weights;
  }// getWeight();

  // remove all the product named the string
  public void remove(String name) {
    for (int i = 0; i < this.cart.size(); i++) {
      if (this.cart.get(i).toString().contains(name)) {
        this.cart.remove(i);
        i--;
      }
    }
  }// remove(String)

  // merge identical items
  public void merge() {
    for (int i = 0; i < this.cart.size(); i++) {
      if ((this.cart.get(i) instanceof ManyPackage)) {
        for (int j = 0; j < i; j++) {
          ManyPackage type = (ManyPackage) this.cart.get(i);
          if (type.getType().equals(this.cart.get(j))) {
            int newcount = type.getCount() + 1;
            this.cart.remove(j);
            i--;
            j--;
            this.cart.add(new ManyPackage(type.getType(), newcount));
          }
        }
      } else if ((this.cart.get(i) instanceof Package)) {
        Package temp = (Package) this.cart.get(i);
        for (int k = i + 1; k < this.cart.size(); k++) {
          if (temp.equals(this.cart.get(k))) {
            ManyPackage newpackage = new ManyPackage(temp, 2);
            this.cart.remove(i);
            this.cart.remove(k);
            this.cart.add(newpackage);
            i--;
            k--;
          }
        }
      }
    }
  }// merge()
}// class
