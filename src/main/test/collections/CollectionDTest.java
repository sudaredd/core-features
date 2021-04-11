package collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionDTest {

    CollectionD collectionD = new CollectionD();

    @Test
    void testGetOldList() {
        List<String> l = Arrays.asList("1","2","3");
        assertTrue(collectionD.getList().size() == 3);
        assertTrue(l.get(0).equals("1"));
        assertThrows(UnsupportedOperationException.class, () -> l.add("4"));
        assertThrows(UnsupportedOperationException.class, () -> l.remove("3"));
        l.remove("6");
        assertThrows(UnsupportedOperationException.class, () -> l.remove(0));
        assertTrue(collectionD.getList().size() == 3);
        l.set(0, "10");
        System.out.println(l.get(0));

    }

    @Test
    void testGetList() {
        assertTrue(collectionD.getList().size() == 3);
        assertTrue(collectionD.getList().get(0).equals("1"));
        assertThrows(UnsupportedOperationException.class, () -> collectionD.getList().add("4"));
        assertThrows(UnsupportedOperationException.class, () -> collectionD.getList().remove("4"));
        assertThrows(UnsupportedOperationException.class, () -> collectionD.getList().remove("0"));
        assertThrows(UnsupportedOperationException.class, () -> collectionD.getList().set(0,"11"));
    }

    @Test
    void testGetSet() {
        assertTrue(collectionD.getSet().size() == 3);
        assertTrue(collectionD.getSet().contains("2"));
        assertThrows(UnsupportedOperationException.class, () -> collectionD.getSet().add("5"));
    }

    @Test
    void testGetMap() {
        assertTrue(collectionD.getMap().size() == 3);
        assertTrue(collectionD.getMap().containsKey("2"));
        assertThrows(UnsupportedOperationException.class, () -> collectionD.getMap().put("5", 5));

    }

    @Test
    void testGetEntryMap() {
        assertTrue(collectionD.getMapEntries().size() == 4);
        assertTrue(collectionD.getMapEntries().containsKey("2"));
        assertThrows(UnsupportedOperationException.class, () -> collectionD.getMapEntries().put("5", 5));
        assertThrows(UnsupportedOperationException.class, () -> collectionD.getMapEntries().remove("100"));

    }
}