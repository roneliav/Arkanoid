//ID: 208461228

package levels.secondlevel;

import differentsprites.Block;
import geometryprimitives.Point;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A class of second level blocks.
 */
public class SecondLevelBlocks {
    private List<Block> blocks;

    /**
     * A constructor.
     */
    public SecondLevelBlocks() {
        //initialize blocks
        this.blocks = new ArrayList<Block>();
        for (int i = 0; i < 15; i++) {
            Block block = new Block(new Point(10 + i * 52, 250), 20, 52);
            block.setColor(this.colorByPlace(i));
            this.blocks.add(block);
        }
    }

    /**
     * choose a color by the place of the block.
     *
     * @param i int - the place of the block
     * @return a color
     */
    public java.awt.Color colorByPlace(int i) {
        if ((i == 0) || (i == 1)) {
            return Color.RED;
        }
        if ((i == 2) || (i == 3)) {
            return Color.ORANGE;
        }
        if ((i == 4) || (i == 5)) {
            return Color.YELLOW;
        }
        if ((i == 6) || (i == 7) || (i == 8)) {
            return Color.GREEN;
        }
        if ((i == 9) || (i == 10)) {
            return Color.BLUE;
        }
        if ((i == 11) || (i == 12)) {
            return Color.PINK;
        }
        //means i=13 or 14
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
