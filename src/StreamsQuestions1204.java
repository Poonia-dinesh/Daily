import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsQuestions1204 {

    public static void main(String[] args)
    {
        // Intersection of two arrays
        Integer[] a1 = {1, 2, 3,4,5};
        Integer[] a2 = {1,2,7,8,4,9};
        List<Integer> l1 = Arrays.asList(a1);
        List<Integer> l2 = Arrays.asList(a2);
        List<Integer> ans = Arrays.stream(a1).filter(l2::contains).distinct().toList();
        System.out.println("Intersection of arrays :" + ans);

        //Generate the fibonacci series
        List<Integer> s = Stream.iterate(new int[]{0,1}, arr -> new int[]{arr[1], arr[0]+arr[1]}).limit(5).map(arr -> arr[0]).toList();
        System.out.println("Fibonacci Series" + s);

        Supplier<Integer> supplier = new Supplier<>() {
            int a = 0;
            int b = 1;
            @Override
            public Integer get() {
                int val = a;
                int temp = a+b;
                a = b;
                b = temp;
                return  val;
            }
        };
        System.out.println("Supplier, Fibonacci Series:");
        Stream.generate(supplier).limit(5).forEach(System.out:: println);
        System.out.println("Supplier, Fibonacci Series:");
        Stream.generate(supplier).limit(5).forEach(System.out:: println);

        // Java 9+
        Stream.iterate(1, n -> n<20, n -> n*2).forEach(System.out:: println);
        Stream.iterate(LocalDate.now(), LocalDate -> LocalDate.plusDays(5))
                .limit(5).forEach(System.out:: println);

        // find the first repeating element from an array
        int[] ar1 = {1,1,2,2,9,4,4,5,5};
        Set<Integer> seet  = new HashSet<>();
        System.out.println("First repeating element in Array : "+Arrays.stream(ar1).filter(a -> !seet.add(a)).findFirst().getAsInt());

        // Non-repeating element
        System.out.println("Non-repeating element : " + Arrays.stream(ar1).boxed().
                collect(Collectors.groupingBy(i -> i,HashMap::new, Collectors.counting())).entrySet().stream().filter(k -> k.getValue() < 2).map(Map.Entry::getKey).findFirst());

        // First non-repeating element
        System.out.println("Non-repeating element : " + Arrays.stream(ar1).boxed().
                collect(Collectors.groupingBy(i -> i,LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(k -> k.getValue() < 2).map(Map.Entry::getKey).findFirst());

        // ----
        Arrays.stream(ar1).boxed().collect(Collectors.groupingBy(i -> i)).entrySet().forEach(System.out::println);

        String str = "Java Streams Java Java Java Questions";
       // Count word frequency
        System.out.println(Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        // Use of partitioningBY)
        System.out.println(Arrays.stream(str.split(" ")).collect(Collectors.partitioningBy(x -> x.length() > 5)));
        // Sort by length
        List<String> names = List.of("John", "Alex", "Chris", "Bob");
        System.out.println(names.stream().sorted(Comparator.comparingInt(String :: length)).toList());

        // Find max
        List<Integer> nums = List.of(10, 20, 40, 5, 7);
        System.out.println(nums.stream().max(Comparator.naturalOrder()));
        System.out.println(nums.stream().reduce((a,b) -> a>b?a:b));

        // Starts with A
        System.out.println(names.stream().anyMatch(name -> name.startsWith("J")));
        System.out.println(names.stream().filter(name -> name.startsWith("C")).findFirst());

        //Convert a List<String> to a single comma-separated string
        String singleStr = names.stream().reduce( (a,b) -> a + "," + b).get();
        System.out.println(singleStr);
        System.out.println(names.stream().collect(Collectors.joining(",")));

        // Flatten a list of lists using flatMap
        List<List<String>> listOfLists = List.of(
                List.of("a", "b"),
                List.of("c", "d")
        );

        System.out.println(listOfLists.stream().flatMap(Collection:: stream)
                .toList());

        // Remove duplicates and sort elements
        List<Integer> numss = List.of(5, 1, 2, 5, 3, 2);
        System.out.println(numss.stream().distinct().sorted(Comparator.reverseOrder()).toList());

        // Fibonacci
        Stream.iterate(new int []{0,1}, arr -> new int[] {arr[1], arr[0]+arr[1]}).limit(5).map(arr -> arr[0]).forEach(System.out:: println);

        // Second highest
        Integer[] arr = {5, 7, 1, 4, 8, 8};
        System.out.println(Arrays.stream(arr).distinct().sorted(Comparator.reverseOrder()).limit(2).reduce((a,b) -> a>b?b:a));
        System.out.println(Arrays.stream(arr).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst());

        // Find the Longest string with highest frequency
        List<String> words = List.of("banana", "banana","apple","apple","apple","apple", "cherry", "banana", "banana");

        System.out.println(words.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream().sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed().thenComparing(e -> e.getKey().length(), Comparator.reverseOrder())).map(Map.Entry::getKey).findFirst().get());
//        System.out.println(words.stream().collect(Collectors.groupingBy(x -> x, TreeMap::new, Collectors.counting())).entrySet().stream().reduce((a, b) -> a.getKey().length() > b.getKey().length() ? a : b));
//        System.out.println(words.stream().collect(Collectors.groupingBy(x -> x, TreeMap::new, Collectors.counting())).entrySet().stream().collect(Collectors.maxBy())

        //Group employees by department and list top salary per department

        Employee e1 = new Employee("it", 100, "raj");
        Employee e2 = new Employee("it", 200, "aaj");
        Employee e3 = new Employee("hr", 70, "zurel");
        Employee e4 = new Employee("hr", 80, "aman");
        Employee e5 = new Employee("it", 70, "naj");

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5);
      Map<String, Optional<Employee>> anss =  employees.stream().collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.maxBy(Comparator.comparingInt(emp -> emp.getSalary()))));
        System.out.println(anss);

        // Element with most freq
        List<Integer> list = List.of(1, 2, 3, 2, 4, 2, 5, 3,3,3,3);
        System.out.println(list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get());

        // Partition a list of integers into even and odd
        List<Integer> nus = List.of(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> parEvenOdd =  nus.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(parEvenOdd);

        // Get frequency map of characters from a string
        String strrr = "streaminginterview";
        System.out.println(strrr.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting())));

        System.out.println(words.stream().collect(Collectors.toMap(k -> k, v -> 1, Integer::sum)));

        System.out.println("Employees with hr department ");
        List<Employee> allhrunshorted   =employees.stream().filter(emp -> emp.department.equalsIgnoreCase("hr")).collect(Collectors.toList());
        System.out.println(allhrunshorted);
    List<Employee> allhrsorted =     employees.stream().filter(emp -> emp.department.equalsIgnoreCase("hr")).sorted((empl, empl2) -> empl.name.compareTo(empl2.name)).collect(Collectors.toList());
        System.out.println(allhrsorted);

    }

}

class Employee{
    String department;
    Integer Salary;
    String name;


    public String getDepartment() {
        return department;
    }

    public Integer getSalary() {
        return Salary;
    }

    public String getName() {
        return name;
    }

    public Employee(String department, Integer salary, String name) {
        this.department = department;
        Salary = salary;
        this.name = name;
    }
    public String toString(){
        return "department : " + department + "\n name : " + name + "\nsalary : " + this.Salary;
    }

}
