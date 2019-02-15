package com.mcfarevee.groceries;

public class Weight {
  // fields
  Unit unit;
  int amount;

  // methods
  public Weight(Unit _unit, int _amount) {
    this.unit = _unit;
    this.amount = _amount;
  }// Weight(Unit, int)
  
  public Unit getUnit() {
    return this.unit;
  }
}// class
