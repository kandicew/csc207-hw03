package com.mcfarevee.shopping;

import java.io.PrintWriter;
import java.util.ArrayList;
import com.mcfarevee.groceries.BulkItem;
import com.mcfarevee.groceries.Item;
import com.mcfarevee.groceries.ManyPackage;
//import com.mcfarevee.groceries.Unit;
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
      if (this.cart.get(i) instanceof Package) {
        Package temp = (Package) this.cart.get(i);
        int j = i + 1;
        while ((j < this.cart.size()) && (!(temp.equals(this.cart.get(j))))) {
          if (temp.equals(this.cart.get(j))) {
            ManyPackage newpackage = new ManyPackage(temp, 2);
            this.cart.remove(i);
            this.cart.remove(j);
            this.cart.add(newpackage);
            i--;
            j--;
          } else if (this.cart.get(j) instanceof ManyPackage) {
            ManyPackage type = (ManyPackage) this.cart.get(j);
            if (temp.equals(type.getType())) {
              ManyPackage newotherpackage = new ManyPackage(temp, type.getCount() + 1);
              this.cart.add(newotherpackage);
              i--;
              j--;
            }
          } else {
            j++;
          } // else
        } // while
      } else if (this.cart.get(i) instanceof BulkItem) {
        BulkItem temp = (BulkItem) this.cart.get(i);
        int j = i + 1;
        while ((j < this.cart.size()) && (!(temp.equals(this.cart.get(j))))) {
          if (temp.equals(this.cart.get(j))) {
            BulkItem newItem = new BulkItem(temp.getFood(), temp.getUnit(), temp.getAmount() * 2);
            this.cart.remove(i);
            this.cart.remove(j);
            this.cart.add(newItem);
            i--;
            j--;
          } else {
            j++;
          } // else
        } // while
      } else if (this.cart.get(i) instanceof ManyPackage) {
        ManyPackage type = (ManyPackage) this.cart.get(i);
        int j = i + 1;
        while ((j < this.cart.size()) && (!(type.equals(this.cart.get(j))))) {
          if (type.equals(this.cart.get(j))) {
            ManyPackage packagej = (ManyPackage) this.cart.get(j);
            ManyPackage otherpackage =
                new ManyPackage(type.getType(), type.getCount() + packagej.getCount());
            this.cart.remove(i);
            this.cart.remove(j);
            this.cart.add(otherpackage);
            i--;
            j--;
          } else if (this.cart.get(j) instanceof Package) {
            Package temppackage = (Package) this.cart.get(j);
            if (type.getType().equals(temppackage)) {
              ManyPackage newmanypackage = new ManyPackage(type.getType(), type.getCount() + 1);
              this.cart.add(newmanypackage);
              i--;
              j--;
            } // if
          } else {
            j++;
          } // else
        } // while
      } // elseif
    } // for
  }// merge()
}// class
