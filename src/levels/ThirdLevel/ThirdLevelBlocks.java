//ID: 208461228
package levels.ThirdLevel;

import differentsprites.Block;
import geometryprimitives.Point;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A class of the third level block.
 */
public class ThirdLevelBlocks {
    private List<Block> blocks;

    /**
     * A constructor.
     */
    public ThirdLevelBlocks() {
        //initialize blocks
        this.blocks = new ArrayList<Block>();
        for (int i = 0; i < 5; i++) {
            for (int j = 10; j > i; j--) {
                Block block = new Block(new Point(240 + (50 * j), 100 + (15 * i)), 15, 50);
                block.setColor(this.colorByPlace(i));
                this.blocks.add(block);
            }
        }
    }

    /**
     * choose a color by the place of the block.
     *
     * @param i int
     * @return color
     */
    public java.awt.Color colorByPlace(int i) {
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
            return Color.BLUE;
        }
        //means i=4
        return Color.WHITE;

    }

    /**
     *
     * @return a blocks list.
     */
    public List<Block> getBlocksList() {
        return  this.blocks;
    }
}
