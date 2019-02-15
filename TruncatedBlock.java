package csc207.wuzhaoqi.layout;

public class TruncatedBlock implements TextBlock {

  // field
  TextBlock contents;
  int width;

  /**
   * Create a new truncated block of the specified width.
   */
  public TruncatedBlock(TextBlock tb, int width) {
    this.contents = tb;
    this.width = width;
  } // TruncatedBlock(TextBlock, int)

  /**
   * Get the ith row of the block.
   * 
   * @throws Exception
   */
  public String row(int i) throws Exception {
    int h = this.contents.height();
    // truncated the string
    if ((i >= 0) && (i < h)) {
      String truncatedstr = this.contents.row(i).substring(0, this.width);
      return truncatedstr;
    } else {
      throw new Exception("Invalid row " + i);
    }
  } // row(int)

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
    return this.contents.width();
  } // width()
}// class
