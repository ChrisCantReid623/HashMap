import java.util.*;
public class TestHashSet
{
    public static void main(String[] args)
    {
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("New York");
        set.add("Beijing");
        set.add("New York");
        System.out.println(set);
        for (String s: set)
            System.out.print(s.toUpperCase() + " ");
        System.out.println();
        set.forEach(e -> System.out.print(e.toLowerCase() + " "));
    }
}
