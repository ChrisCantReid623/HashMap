public class Testing {
    public static void main(String[] args) {
        MyHashMap<Integer, Integer> names = new MyHashMap<>();
        System.out.println(names.isEmpty());
        names.put(21,1024);
        names.put(33,1024);
        names.put(18,1024);
        names.put(31,1024);
        names.put(26,1024);
        names.put(14,1024);
        names.put(19,1024);
        names.put(22, 555);
        names.put(39, 666);
        names.put(55, 645);
        System.out.println(names.put(71,1024));
        System.out.println(names.put(71,9999));
        System.out.println(names.isEmpty());
        System.out.println(names.containsKey(33));
        System.out.println(names.containsValue(666));
        System.out.println(names.get(22));
        System.out.println(names.size());
        System.out.println(names.keySet());
        names.remove(31);
        names.printTable();
        names.clear();
        System.out.println(names.isEmpty());
        System.out.println();

        MyHashMap<String, Integer> second = new MyHashMap<>();
        System.out.println(second.isEmpty());
        System.out.println(second.put("Chris", 1995));
        System.out.println(second.put("Marissa", 1993));
        System.out.println(second.isEmpty());
        System.out.println(second.containsKey("Chris"));
        System.out.println(second.containsValue(1995));
        System.out.println(second.get("Chris"));
        System.out.println(second.size());
        System.out.println(second.keySet());
        second.printTable();
        second.clear();
        System.out.println(second.isEmpty());
        System.out.println();

        HashTable<Integer, Integer> runs = new HashTable<>();
        System.out.println(runs.hashTable.size());
    }
}