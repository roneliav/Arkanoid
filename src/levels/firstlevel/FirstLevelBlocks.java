//ID: 208461228

package levels.firstlevel;

import differentsprites.Block;
import geometryprimitives.Point;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A class of the first level blocks.
 */
public class FirstLevelBlocks {
    private List<Block> blocks;

    /**
     * A constructor.
     */
    public FirstLevelBlocks() {
        //initialize block
        this.blocks = new ArrayList<Block>();
        Block block = new Block(new Point(390, 130), 20, 20);
        block.setColor(Color.RED);
        this.blocks.add(block);
    }

    /**
     *
     * @return the list of the block
     */
    public List<Block> getBlocksList() {
        return  this.blocks;
    }

}
