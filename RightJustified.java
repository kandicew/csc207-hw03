package csc207.wuzhaoqi.layout;

public class RightJustified implements TextBlock {

  // fields
  TextBlock contents;
  int width;

  /**
   * Create a new block of the specified width.
   */
  public RightJustified(TextBlock _content, int width) {
    this.contents = _content;
    this.width = width;
  } // RightJustified(TextBlock, int)

  /**
   * Get the ith row of the block.
   * 
   * @throws Exception
   */
  public String row(int i) throws Exception {
    if (this.width >= this.contents.width()) {
      String space = "  ";
      int h = this.contents.height();
      // check row valid
      if ((i >= 0) && (i < h)) {
        int lengthOfSpace = this.width - this.contents.width();
        // create more space
        while (space.length() < lengthOfSpace) {
          space = space.concat(space);
        } // while
        // adjust to the correct number of space
        space = space.substring(0, lengthOfSpace);
        return space.concat(this.contents.row(i));
      } else {
        throw new Exception("Invalid row " + i);
      }
    } else {
      throw new Exception("Invalid width" + this.width);
    } // else
  }// row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.contents.height();
  }// height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.width;
  }// width()
}// class
