package csc207.wuzhaoqi.layout;

public class BlockPair implements TextBlock {

  // fields
  TextBlock contents;

  /**
   * Create a new block
   */
  public BlockPair(TextBlock _contents) {
    this.contents = _contents;
  }

  /**
   * Get the ith row of the block.
   * 
   * @throws Exception
   */
  public String row(int i) throws Exception {
    int h = this.contents.height();
    if ((i >= 0) && (i < h)) {
      String text = this.contents.row(i);
      String pair = text.concat(text);
      return pair;
    } else {
      throw new Exception("Invalid row " + i);
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
    return (this.contents.width() * 2);
  }// width
}// class
