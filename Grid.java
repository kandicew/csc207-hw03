package csc207.wuzhaoqi.layout;

public class Grid implements TextBlock {

  // fields
  int width;
  int height;
  char ch;

  // constructor
  /**
   * Create a new grid of the specified width, height and char
   */
  public Grid(int width, int height, char ch) {
    this.width = width;
    this.height = height;
    this.ch = ch;
  }// Grid(int,int,char)

  /**
   * Get the ith row of the block.
   * 
   * @throws Exception
   */
  public String row(int i) throws Exception {
    int h = this.height;
    // fill in with ch
    if ((i >= 0) && (i < h)) {
      char[] content = new char[this.width];
      for (int j = 0; j < this.width; j++) {
        content[j] = this.ch;
      } // for
      String contents = new String(content);
      return contents;
    } else {
      throw new Exception("Invalid row " + i);
    } // else
  } // row(int)

  /**
   * return the height of the grid
   */
  public int height() {
    return this.height;
  }// height()

  /**
   * return the width of the grid
   */
  public int width() {
    return this.width;
  }// width()
}// class
