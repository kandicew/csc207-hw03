package csc207.wuzhaoqi.layout;

public class CenteredBlock implements TextBlock {
  // fields
  TextBlock contents;
  int width;

  /**
   * Create a new block of the specified width.
   */
  public CenteredBlock(TextBlock _content, int width) {
    this.contents = _content;
    this.width = width;
  } // CenteredBlock(TextBlock, int)

  /**
   * Get the ith row of the block.
   * 
   * @throws Exception
   */
  public String row(int i) throws Exception {
    if (this.width >= this.contents.width()) {
      int h = this.contents.height();
      // center the string
      if ((i >= 0) && (i < h)) {
        // the starting position for contents to palce
        int start = (this.width - this.contents.row(i).length()) / 2;
        char[] charray = this.contents.row(i).toCharArray();
        char[] newcharray = new char[this.width];
        // loop through each of the index in the array
        for (int j = 0; j < this.width; j++) {
          // if not the centered contents part
          if ((j < start) || (j >= (this.width - start))) {
            newcharray[j] = ' ';
          } else {
            newcharray[j] = charray[j - start];
          } // else
        }
        String centeredstr = new String(newcharray);
        return centeredstr;
      } else {
        throw new Exception("Invalid row " + i);
      } // else
    } else {
      throw new Exception("Invalid width" + this.width);
    } // else
  }// row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return this.contents.height();
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.width;
  } // width()
}// class
