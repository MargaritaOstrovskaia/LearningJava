import LinkedList.*;

import junit.framework.*;

import java.util.ArrayList;

public class DLLTest extends TestCase {
    DLList<String> shortList;
    DLList<Integer> emptyList;
    DLList<Integer> oneList;
    DLList<Integer> list1;
    DLList<Integer> longList;

    public void setUp() throws Exception {

        String[] shortListData = {"A", "B"};
        Integer[] oneListData = {8};
        Integer[] listData = {65, 21, 42};
        Integer[] longListData = {8, 5, 4, 8, 5, 3, 8, 5};

        emptyList = new DLList<Integer>();
        shortList = new DLList<String>(shortListData);
        oneList = new DLList<Integer>(oneListData);
        list1 = new DLList<Integer>(listData);
        longList = new DLList<Integer>(longListData);
    }

    public void testGetFirstIndexByData() {
        int index1 = emptyList.getFirstIndexByData(2);
        assertEquals("GetFirstIndexByData: Check index in emptyList", -1, index1);

        int index2 = list1.getFirstIndexByData(42);
        assertEquals("GetFirstIndexByData: Check index in list1", 2, index2);

        int index3 = longList.getFirstIndexByData(5);
        assertEquals("GetFirstIndexByData: Check index in longList", 1, index3);
    }

    public void testGetIndexesByData() {
        ArrayList<Integer> indexes1 = emptyList.getAllIndexesByData(2);
        assertEquals("GetIndexesByData: Check index in emptyList", 0, indexes1.size());

        ArrayList<Integer> indexes2 = longList.getAllIndexesByData(5);
        assertEquals("GetIndexesByData: Check size in longList", 3, indexes2.size());
        assertEquals("GetIndexesByData: Check index in longList", (Integer) 1, indexes2.get(0));
        assertEquals("GetIndexesByData: Check index in longList", (Integer) 4, indexes2.get(1));
        assertEquals("GetIndexesByData: Check index in longList", (Integer) 7, indexes2.get(2));
    }

    public void testGetNodeByData() {
        DLLNode<Integer> index1 = emptyList.getNodeByData(2);
        assertEquals("GetNodeByData: Check index in emptyList", null, index1);

        DLLNode<Integer> index2 = longList.getNodeByData(5);
        assertEquals("GetNodeByData: Check index in longList", "5", index2.toString());
    }

    public void testGetAllNodesByData() {
        ArrayList<DLLNode<Integer>> indexes1 = (ArrayList) emptyList.getAllNodesByData(2);
        assertEquals("GetAllNodesByData: Check index in emptyList", null, indexes1);

        ArrayList<DLLNode<Integer>> indexes2 = (ArrayList) longList.getAllNodesByData(5);
        assertEquals("GetAllNodesByData: Check index in longList", 3, indexes2.size());
        assertEquals("GetAllNodesByData: Check index in longList", "5", indexes2.get(0).toString());
        assertEquals("GetAllNodesByData: Check index in longList", "5", indexes2.get(1).toString());
        assertEquals("GetAllNodesByData: Check index in longList", "5", indexes2.get(2).toString());
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

        DLLNode<Integer> l = list1.getNode(0);
        assertEquals("GetNode: Check get element in list1", "65", l.toString());

        DLLNode<String> sh = shortList.getNode(1);
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
        DLLNode<Integer> em = emptyList.add(12);
        assertEquals("AddData: Check add element in emptyList", "12", em.toString());
        assertEquals("AddData: Check add element in emptyList", (Integer)12, emptyList.getData(0));
        assertEquals("AddData: Check size in emptyList",1, emptyList.getSize());

        DLLNode<String> sh = shortList.add("D");
        assertEquals("AddData: Check add element in shortList", "D", sh.toString());
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

        DLLNode<Integer> em = emptyList.add(15, 0);
        assertEquals("AddDataByIndex: Check add element in emptyList", "15", em.toString());
        assertEquals("AddDataByIndex: Check add element in 0 position in emptyList", (Integer)15, emptyList.getData(0));
        assertEquals("AddDataByIndex: Check size in emptyList",1, emptyList.getSize());

        DLLNode<Integer> ld = list1.add(45, 1);
        assertEquals("AddDataByIndex: Check add element in list1", "45", ld.toString());
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

        DLLNode<Integer> l1 = list1.set(15, 0);
        assertEquals("Set: Check add element in list1", "15", l1.toString());
        assertEquals("Set: Check add element in 0 position in list1", (Integer)15, list1.getData(0));

        DLLNode<Integer> l2 = list1.set(45, 1);
        assertEquals("Set: Check add element in list1", "45", l2.toString());
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

        DLLNode<Integer> r1 = oneList.removeByIndex(0);
        assertEquals("RemoveByIndex: Check remove element in oneList", "8", r1.toString());
        assertEquals("RemoveByIndex: Check size in oneList",0, oneList.getSize());

        DLLNode<Integer> r2 = list1.removeByIndex(1);
        assertEquals("RemoveByIndex: Check remove element in list1", "21", r2.toString());
        assertEquals("RemoveByIndex: Check size in list1",2, list1.getSize());

        DLLNode<String> r3 = shortList.removeByIndex(1);
        assertEquals("RemoveByIndex: Check remove element in shortList", "B", r3.toString());
        assertEquals("RemoveByIndex: Check element in 0 position in shortList", "A", shortList.getData(0));
        assertEquals("RemoveByIndex: Check size in list1",1, shortList.getSize());
    }

    public void testRemoveFirstElementByData() {
        DLLNode<Integer> r1 = emptyList.removeFirstElementByData(2);
        assertEquals("RemoveFirstElementByData: remove in emptyList", null, r1);

        DLLNode<Integer> r2 = longList.removeFirstElementByData(5);
        assertEquals("RemoveFirstElementByData: check remove element in longList", "5", r2.toString());
        assertEquals("RemoveFirstElementByData: check index 1 in longList", (Integer) 4, longList.getData(1));
        assertEquals("RemoveFirstElementByData: check index 2 in longList", (Integer) 8, longList.getData(2));
        assertEquals("RemoveFirstElementByData: check size in longList", 7, longList.getSize());
    }

    public void testRemoveAllElementsByData() {
        ArrayList<DLLNode<Integer>> r1 = (ArrayList) emptyList.removeAllElementsByData(2);
        assertEquals("RemoveAllElementsByData: remove in emptyList", null, r1);

        ArrayList<DLLNode<Integer>> r2 = (ArrayList) longList.removeAllElementsByData(5);
        assertEquals("RemoveAllElementsByData: check remove element in longList", 3, r2.size());
        assertEquals("RemoveAllElementsByData: check index 1 in longList", (Integer) 4, longList.getData(1));
        assertEquals("RemoveAllElementsByData: check size in longList", 5, longList.getSize());
        for(DLLNode<Integer> ob : r2)
            assertEquals("RemoveAllElementsByData: check remove element in longList", "5", ob.toString());

    }
}
