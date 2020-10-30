//ID: 208461228
package levels.forthlevel;

import differentsprites.Block;
import geometryprimitives.Point;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A class of the forth level blocks.
 */
public class ForthLevelBlocks {
    private List<Block> blocks;

    /**
     * A constructor.
     */
    public ForthLevelBlocks() {
        //initiate list of blocks
        this.blocks = new ArrayList<Block>();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                Block block = new Block(new Point(10 + j * 52, 70 + (i * 20)), 20, 52);
                block.setColor(this.colorByRow(i));
                this.blocks.add(block);
            }
        }
    }

    /**
     * choose a color.
     *
     * @param i int of a row
     * @return a color by the row
     */
    public java.awt.Color colorByRow(int i) {
        if (i == 0) {
            return Color.GRAY;
        }
        if (i == 1) {
            return Color.RED;
        }
        if (i == 2) {
            return Color.YELLOW;
        }
        if (i == 3) {
            return Color.GREEN;
        }
        if (i == 4) {
            return Color.WHITE;
        }
        if (i == 5) {
            return Color.PINK;
        }
        //means i=6
        return Color.CYAN;
    }

    /**
     *
     * @return a block list.
     */
    public List<Block> getBlocksList() {
        return  this.blocks;
    }

}
