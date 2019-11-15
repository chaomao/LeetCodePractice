import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JewelsAndStoneTest {
    private JewelsAndStone stone = new JewelsAndStone();

    @Test
    void should_include_some() {
        assertEquals(3, stone.numJewelsInStones("aA", "aAAbbbb"));
    }

    @Test
    void should_include_none() {
        assertEquals(0, stone.numJewelsInStones("z", "ZZ"));
    }

    @Test
    void should_include_all() {
        assertEquals(5, stone.numJewelsInStones("aA", "aAAAa"));
    }

    @Test
    void should_include_more() {
        assertEquals(3, stone.numJewelsInStones("aABB", "aAAbbbb"));
    }
}