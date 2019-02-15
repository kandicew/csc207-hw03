package com.mcfarevee.groceries;

public class BulkFood {
  // fields
  String name;
  Unit unit;
  int pricePerUnit;
  int supply;

  // constructors
  public BulkFood(String _name, Unit _unit, int _pricePerUnit, int _supply) {
    this.name = _name;
    this.unit = _unit;
    this.pricePerUnit = _pricePerUnit;
    this.supply = _supply;
  }// BulkFood(String, Unit, int, int)
}// class
