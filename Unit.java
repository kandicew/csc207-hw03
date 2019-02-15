package com.mcfarevee.groceries;

/**
 * A Unit of measurement.  The primary units available at 
 * Unit.GRAM, Unit.KILOGRAM, Unit.OUNCE, and Unit.POUND.
 */
public class Unit {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The name of the unit.
   */
  String name;

  /**
   * The abbreviation of the unit.
   */
  String abbrev;

  /**
   * The plural name of the unit.
   */
  String plural;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new unit with a given name.
   */
  private Unit(String name, String abbrev, String plural) {
    this.name = name;
    this.abbrev = abbrev;
    this.plural = plural;
  } // Unit(String, String, String)

  // +-----------+---------------------------------------------------
  // | Accessors |
  // +-----------+

  /**
   * Get the unit name.
   */
  public String tString() {
    return this.name;
  } // toString()

  /**
   * Get the abbreviation of the unit name.
   */
  public String abbrev() {
    return this.abbrev;
  } // abbrev()

  /**
   * Get the plural of the unit name.  (One does not always form a plural
   * by just adding "s", so we provide this additional method.)
   */
  public String plural() {
    return this.plural;
  } // plural

  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * Standard unit: Pounds
   */
  public static final Unit POUND = new Unit("pound", "lb.", "pounds");
  
  /** 
   * Standard unit: Ounces
   */
  public static final Unit OUNCE = new Unit("ounce", "oz.", "ounces");

  /**
   * Standard unit: Kilograms
   */
  public static final Unit KILOGRAM = new Unit("kilogram", "kg.", "kilograms");

  /**
   * Standard unit: Grams
   */
  public static final Unit GRAM = new Unit("gram", "gm.", "grams");

} // class Unit
