import java.util.*;

public class ComparatorComparable {
    public static void main(String[] args)
    {
        Person p1 = new Person("Smith", 10, 100);
        Person p2 = new Person("John", 10, 50);
        Person p3 = new Person("Rock", 12, 300);
        List<Person> list = Arrays.asList(p1,p2,p3);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.Age-o2.Age;
            }
        });
        System.out.println(list);
        Collections.sort(list,(o1, o2)-> o2.Age-o1.Age);
        System.out.println(list);
        Collections.sort(list, Comparator.comparing(Person ::  getIncome));
        System.out.println(list);
        Collections.sort(list, new CustomPersonComparator());
        System.out.println(list);

        int[][] arrr = {
                {7,5,4},
                {1,3,9},
                {1,3,6}
        };

     for(int []e: arrr){
         for(int i: e){
             System.out.print(i +" ");
         }
         System.out.println();
    }
        Arrays.sort(arrr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        System.out.println("Sorted Array : ");
        for(int []e: arrr){
            for(int i: e){
                System.out.print(i +" ");
            }
            System.out.println();
        }

        Arrays.sort(arrr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i =0; i<o1.length; i++){
                    if(o1[i] != o2[i]){
                        return o1[i]-o2[i];
                    }
                }
                return o1[0]-o2[0];
            }
        });

        System.out.println("Sorted Array : ");
        for(int []e: arrr){
            for(int i: e){
                System.out.print(i +" ");
            }
            System.out.println();
        }


    }
}


class CustomPersonComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.Age == o2.Age){
            return o1.Name.compareTo(o2.Name);
        }
        return o1.Age-o2.Age;
    }
}

class Person implements Comparable<Person>{
    String Name;

    @Override
    public int compareTo(Person o) {
        return Integer.compare(o.Age, this.Age);
    }

    int Age;

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public int getIncome() {
        return Income;
    }

    int Income;

    public Person(String name, int age, int income){
        Name = name;
        Age = age;
        Income  = income;
    }

    @Override
    public String toString(){
        return "Person : " + Name +" Age : " + Age + " Income :" +Income +"\n" ;
    }

}
