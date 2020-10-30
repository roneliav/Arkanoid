//ID:208461228

package makegame;

/**
 * A counter class.
 *
 */
public class Counter {
    private int count;

    /**
     * A constructor.
     *
     * initialized to 0
     *
     */
    public Counter() {
        this.count = 0;
    }


    /**
     * add number to current count.
     *
     * @param number a number
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * subtract number from current count.
     * @param number a number
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * get current count.
     *
     * @return this count
     */
    public int getValue() {
        return this.count;
    }
}
