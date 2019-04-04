import LinkedList.SLLNode;
import LinkedList.SLList;
import junit.framework.TestCase;

public class SLLTest extends TestCase {
    SLList<String> shortList;
    SLList<Integer> emptyList;
    SLList<Integer> oneList;
    SLList<Integer> list1;
    SLList<Integer> longList;

    public void setUp() throws Exception {

        String[] shortListData = {"A", "B"};
        Integer[] oneListData = {8};
        Integer[] listData = {65, 21, 42};
        Integer[] longListData = {8, 5, 4, 8, 5, 3, 8, 5};

        emptyList = new SLList<Integer>();
        shortList = new SLList<String>(shortListData);
        oneList = new SLList<Integer>(oneListData);
        list1 = new SLList<Integer>(listData);
        longList = new SLList<Integer>(longListData);
    }

    public void testGetNode() {
        try {
            emptyList.getNode(1);
            fail("GetNode: IndexOutOfBoundsException in emptyList (1)");
        }
        catch (IndexOutOfBoundsException e){}

        try {
            shortList.getNode(-1);
            fail("GetNode: IndexOutOfBoundsException in shortList (-1)");
        }
        catch (IndexOutOfBoundsException e){}

        SLLNode<Integer> l = list1.getNode(0);
        assertEquals("GetNode: Check get element in list1", "65", l.toString());

        SLLNode<String> sh = shortList.getNode(1);
        assertEquals("GetNode: Check get element in shortList", "B", sh.toString());
    }

    public void testGetData() {
        try {
            emptyList.getData(1);
            fail("GetData: IndexOutOfBoundsException in emptyList (1)");
        }
        catch (IndexOutOfBoundsException e){}

        try {
            shortList.getData(-1);
            fail("GetData: IndexOutOfBoundsException in shortList (-1)");
        }
        catch (IndexOutOfBoundsException e){}

        Integer l = list1.getData(0);
        assertEquals("GetData: Check get element in list1", (Integer) 65, l);

        String sh = shortList.getData(1);
        assertEquals("GetData: Check get element in shortList", (String) "B", sh);
    }

    public void testAddData() {
        emptyList.add(12);
        assertEquals("AddData: Check size in emptyList",1, emptyList.getSize());

        shortList.add("D");
        assertEquals("AddData: Check add element in shortList", "D", shortList.getData(2));
        assertEquals("AddData: Check size in shortList",3, shortList.getSize());
    }

    public void testAddDataByIndex() {
        try {
            emptyList.add(12, 1);
            fail("AddDataByIndex: IndexOutOfBoundsException in emptyList (1)");
        }
        catch (IndexOutOfBoundsException e){}

        try {
            shortList.add("X", -1);
            fail("AddDataByIndex: IndexOutOfBoundsException in shortList (-1)");
        }
        catch (IndexOutOfBoundsException e){}

        emptyList.add(15, 0);
        assertEquals("AddDataByIndex: Check size in emptyList",1, emptyList.getSize());

        list1.add(45, 1);
        assertEquals("AddDataByIndex: Check add element in 1 position in list1", (Integer)45, list1.getData(1));
        assertEquals("AddDataByIndex: Check add element in 2 position in list1", (Integer)21, list1.getData(2));
        assertEquals("AddDataByIndex: Check size in list1",4, list1.getSize());
    }

    public void testSet() {
        try {
            emptyList.set(12, 1);
            fail("Set: IndexOutOfBoundsException in emptyList (1)");
        }
        catch (IndexOutOfBoundsException e){}

        try {
            shortList.set("X", -1);
            fail("Set: IndexOutOfBoundsException in shortList (-1)");
        }
        catch (IndexOutOfBoundsException e){}

        list1.set(15, 0);
        assertEquals("Set: Check add element in 0 position in list1", (Integer)15, list1.getData(0));

        list1.set(45, 1);
        assertEquals("Set: Check add element in 1 position in list1", (Integer)45, list1.getData(1));
        assertEquals("Set: Check add element in 2 position in list1", (Integer)42, list1.getData(2));
        assertEquals("Set: Check size in list1",3, list1.getSize());
    }

    public void testRemoveByIndex() {
        try {
            emptyList.removeByIndex(1);
            fail("RemoveByIndex: IndexOutOfBoundsException in emptyList (1)");
        }
        catch (IndexOutOfBoundsException e){}

        try {
            shortList.removeByIndex(-1);
            fail("RemoveByIndex: IndexOutOfBoundsException in shortList (-1)");
        }
        catch (IndexOutOfBoundsException e){}

        oneList.removeByIndex(0);
        assertEquals("RemoveByIndex: Check size in oneList",0, oneList.getSize());

        list1.removeByIndex(1);
        assertEquals("RemoveByIndex: Check 1 element in list1", (Integer) 42, list1.getData(1));
        assertEquals("RemoveByIndex: Check size in list1",2, list1.getSize());

        shortList.removeByIndex(1);
        assertEquals("RemoveByIndex: Check element in 0 position in shortList", "A", shortList.getData(0));
        assertEquals("RemoveByIndex: Check size in list1",1, shortList.getSize());
    }

    public void testRemoveFirstElementByData() {
        emptyList.removeFirstElementByData(2);

        longList.removeFirstElementByData(5);
        assertEquals("RemoveFirstElementByData: check index 1 in longList", (Integer) 4, longList.getData(1));
        assertEquals("RemoveFirstElementByData: check index 2 in longList", (Integer) 8, longList.getData(2));
        assertEquals("RemoveFirstElementByData: check size in longList", 7, longList.getSize());
    }

    public void testRemoveAllElementsByData() {
        emptyList.removeAllElementsByData(2);

        longList.removeAllElementsByData(5);
        assertEquals("RemoveAllElementsByData: check index 1 in longList", (Integer) 4, longList.getData(1));
        assertEquals("RemoveAllElementsByData: check index 1 in longList", (Integer) 8, longList.getData(4));
        assertEquals("RemoveAllElementsByData: check size in longList", 5, longList.getSize());
    }
}
