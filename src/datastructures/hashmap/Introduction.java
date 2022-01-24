package datastructures.hashmap;

public class Introduction {

    public static void main(String[] args) {
        StringMap map = new StringMap(5);
        map.insert("a", "1");
        map.insert("b", "2");
        map.insert("c", "3");
        map.insert("d", "4");
        map.insert("e", "5");
        map.insert("f", "6");
        map.insert("g", "7");
        map.insert("h", "8");
        map.insert("f", "9");
        map.delete("f");
        map.delete("f");
        map.delete("a");
        map.print();
        System.out.println("Search 'f' in StringMap -> " + map.search("f"));
        System.out.println("Search 'z' in StringMap -> " + map.search("z"));
    }
}
