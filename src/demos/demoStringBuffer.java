package demos;

public class demoStringBuffer {
    public static void main(String[] args)
    {
        insert(new StringBuffer("GeeksGeeks"));
        delete(new StringBuffer("GeeksGeeks"));
        replace(new StringBuffer("GeeksGeeks"));
        reverse(new StringBuffer("GeeksGeeks"));
    }

    private static void insert(StringBuffer s) {
        s.insert(10, "X");
        System.out.println("insert(10, \"X\") " + s);

        s.insert(5, "for");
        System.out.println("insert(5, \"for\") " + s);

        s.insert(0, 5);
        System.out.println("insert(0, 5) " + s);

        s.insert(3, true);
        System.out.println("insert(3, true) " + s);
    }

    private static void delete(StringBuffer s) {
        s.delete(0, 5);
        System.out.println("delete: " + s);

        s.deleteCharAt(4);
        System.out.println("deleteCharAt: " + s);
    }

    private static void replace(StringBuffer s) {
        s.replace(5, 8, "are");
        System.out.println("replace: " + s);
    }

    private static void reverse(StringBuffer s) {
        s.reverse();
        System.out.println("reverse: " + s);
    }
}
