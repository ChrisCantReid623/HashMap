public class Testing2 {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("California", 30);
        map.put("Texas", 20);
        map.put("Florida", 40);
        map.put("Arizona", 10);
        map.put("Washington", 20);
        map.put("Massachusetts", 20);
        map.put("Nevada", 10);
        map.put("Oregon", 20);
        map.put("Hawaii", 2);
        map.put("Tennessee", 5);
        map.printTable();
    }
}
