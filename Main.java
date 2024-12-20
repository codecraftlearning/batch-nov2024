import Exceptions.AgeLimitException;
import enums.Complexion;
import enums.Gender;
import interfaces.IPerson;
import models.*;
import services.FileOperations;

import java.io.File;
import java.io.Serializable;
import java.util.*;
//


public class Main {
    public static void main(String[] args) {

        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(1, "asdasd");
//        {
//
//            //only key ; not value
//            int n = 16; => 12
//            int hashCode = 12;
//            int index = hashCode & (n-1); //=> 12   > 10
//            n = n * 2;
//            index = hashCode & (n-1); // 12
//            System.out.println(index);
//        }

        studentMap.put(2, "uiiu");
        studentMap.put(3, "qweeqw"); // hashcode = 3; => index = 3
        studentMap.put(3, "qwerty"); // hashcode = 3; => index = 3
        studentMap.put(18, "lamp");



        /*
            HashMap<Type of Key, Type of value> -
                ArrayList<LinkedList>
                    -  LinkedList<Map.Entry>
                        - Map.Entry<Type of Key, Type of value>
        */


        //new entry => < 3, qwerty>
       //exising entries =>  <3,qweeqw> -> Integer(3).equals(Integer(3)) -> true // replace the value

        //new entry <18, lamp>
        //existing entries <2, uiiu> => Integer(2).equals(Integer(18) -> false // append the value
//
//        System.out.println(Integer.valueOf("1").hashCode());   // for a Integer "hashCode -> value" "equals -> value1 == value2"
        // hashCode -> 1  // equals (1 == 1) => true


        /*
                x(1)(a) -> (unique id) (hashcode) = 1 => noOfBuckets % hashcode = 1
                y(2)(b) -> (unique id) (hashcode) = 2 => noOfBuckets % hashcode = 2
                z(1)(c) -> (unique id) (hashcode) = 1 => noOfBuckets % hashcode = 1
                i(17)(d) -> (unique id) (hashcode) = 17 => noOfBuckets % hashcode = 1

                       i
                       z
                       x  y
                    -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
                    0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15


         */


//        System.out.println(studentMap);
    }
}



//public class Main {
//
//    public static Integer findSecondLargest(int[] arr) {
//
//        if (arr == null || arr.length == 1) {
//            return -1;
//        }
//
//        if (arr.length == 2) {
//            if (arr[0] == arr[1]) {
//                return -1;
//            }
//
//            return Math.min(arr[0], arr[1]);
//        }
//
//        Integer first = -1; // -1, 5, 9
//        Integer second = -1; // -1, 3, 5
//
//        for (int num : arr) { // 3, 5, 2, 9, 7
//            if (first == -1 || num > first) {
//                second = first;
//                first = num;
//            } else  if ((second == -1 || num > second) && num != first) {
//                second = num;
//            }
//        }
//
//        return second;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {3,5,2,9,7};
////        int[] arr = {3,5,2,9,7};
////        int[] arr = {10, 10, 5};
//        Integer secondLargest = findSecondLargest(arr);
//        System.out.println(secondLargest);
//    }
//}


//public class Main {
//    public static void main(String[] args){
//
//        Employee e1 = new Employee();
//        e1.setName("asdas");
//        e1.setAge(32);
//        e1.setGender(Gender.Male);
//        e1.setId(123L);
//
//        Employee e2 = new Employee();
//        e2.setName("asdas");
//        e2.setAge(33);
//        e2.setGender(Gender.Male);
//        e2.setId(123L);
//
//        System.out.println(e1.equals(e2));
//        System.out.println(e1.hashCode());
//        System.out.println(e2.hashCode());
//
//        Map<Employee, String> employeeStringMap = new HashMap<>();
//        employeeStringMap.put(e1, e1.getName());
//        employeeStringMap.put(e2, e2.getName());
//
//        System.out.println(employeeStringMap);
//    }
//}



















/*

                                                                            Exception

                        Checked Exception                               Unchecked Exception                                 Error
                        (compile-time exception)                        (Run-time exception)                                (Error)
                                                              Null Pointer Exception                               Out of memory error
                                                                                               IOException                                    Arithemetic Exception                                SyntaxError
                            SQLException                                   Stack overflow error



                        Throwable class ->  Exception, Error
 */

/*

    Q: Could you explain try, catch and finally in java
    Ans:  Try block provide a safe environment to execute a vulnerable code fragment which could throw an exception at any point of time.
          If any exception occurred, then Catch blocks help us to implement a fallback mechanism which will land the program safely.
          on the other hand Finally give us the liberty to close the necessary connection or destroy the references anyhow.


 */
//
//public class Main {
//    public static void main(String[] args) {
//
//
//        try {
//            System.out.println(clubEntry(19));
//        } catch (AgeLimitException e) {
//            System.out.println(e);
//        }
//
////        System.out.println(divide1(1,1));
//
////        try {
////            System.out.println(divide2(1, 0));
////        } catch (Exception e) {
////            System.out.println("wrong data sent to divide 2");
////        }finally {
////            System.out.println("all connections closed");
////        }
//    }
//
//
//
//    public static Integer divide1(Integer a, Integer b) {
//        Integer value = 0;
//        try {
//            value = a / b;
//        } catch (ArithmeticException e) {
//            System.out.println("we encountered and exception");
//        }
//
//        return value;
//    }
//
//    public static Integer divide2(Integer a, Integer b) throws ArithmeticException {
//        Integer value = 0;
//        value = a / b;
//        return value;
//    }
//
//
//    public static String clubEntry(Integer age) throws AgeLimitException {
//        if (age < 18) {
//            throw AgeLimitException.lessThan18NotAllowed();
//        }
//
//        return "Entry Accepted";
//    }
//}













//public class Main {
//    public static void main(String[] args) {
//
//        Person p = new Person();
//
////        p.setGender(Gender.Male);
//        p.setGender(Gender.Male);
//        p.setComplexion(Complexion.Fair);
//
//        System.out.println(p.getGender());
//
//    }
//}













//#00001  -> #99999
//#00001 (1) -> #00005 (2) ->   #00009 (3) ....
//  (head address) + (index * size in bytes);

//  #00001->_______________________________1______________________________1_______________________________11______________________________100_____________________________101

//public class Main {
//    public static void main(String[] args) {
//
//        Integer[] rolls = {1,2,3,4,5}; //static implementation of an array.
//
//        System.out.println(rolls[0]); // #00001 + (0 * 4) => #00001
//        System.out.println(rolls[1]); // #00001 + (1 * 4) => #00005
//        System.out.println(rolls[2]); // #00001 + (2 * 4) => #00009
//    }
//}

















//public class Main {
//    public static void main(String[] args) {
//
//        Person person = new Person();  /// qw23424wef234
//        person.setName("asdasd");
//        person.setAge(21);
//        person.setComplexion("fair");
//        person.setHeight(5.2);
//        person.setHeight(45.0);
//
//        FileOperations.writeObject(person, "person.txt");
//
////        Person p1 = (Person) FileOperations.readObject("person.txt"); //type cast
////        System.out.println(p1);
//    }
//}
















//public class Main {
//    public static void main(String[] args) {
//        File file = FileOperations.getFile("./resourses/blobs/script", "txt");
////        FileOperations.createFile(file);
////        FileOperations.writeIntoFile(file, "This is my thirds file operations\n");
//        String content = FileOperations.readFromFile(FileOperations.getFile("./resourses/script", "txt"));
//        System.out.println(content);
////
////        FileOperations.deleteFile(FileOperations.getFile("./resourses/blobs/script", "txt"));
//    }
//}




//public class Main {
//    public static void main(String[] args) {
//
//        String str = "new string 1"; //immutable //this is not thread safe ->  not synchronised // faster
//        System.out.println(str);
//
//        StringBuilder stringBuilder = new StringBuilder("new string 2"); // are mutable // not synchronised //faster
//        System.out.println(stringBuilder);
//
//        StringBuffer stringBuffer = new StringBuffer("new String 3"); // are mutable // synchronised // slower
//        System.out.println(stringBuffer);
//
//    }
//}


//public class Main {
//    public static void main (String[] args) {
//        Student s = new Student();
//        s.setName("Asd");
//        s.setAddress("dfe");
//        s.setAge(12);
//        s.setGender("Male");
//        s.setClassName("10th");
//        s.setPhoneNumber(123123123L);
//        s.setHeight(5.2D);
//        s.setWeight(50.5D);
//        s.setRollNumber(1);
//
//        System.out.println(s);
//
//        Student sx1 = new Student().rollNumber(1).age(12);
//        Student sx2 = new Student().rollNumber(1).age(12);
//
//
//        Student.Builder studentBuilder = new Student.Builder()
//                .age(12).gender("Male")
//                .address("ryrt").weight(35.3)
//                .height(4.5).name("erte")
//                .phoneNumber(12312312L).className("7th")
//                .rolNumber(1);
//
//        Student s1 = studentBuilder.build();
//        Student s2 = studentBuilder.build();
//        s2.setWeight(12.4);
//        Student s3 = studentBuilder.build();
//        Student s4 = studentBuilder.build();
//
//    }
//}






//public class Main {
//    public static void main(String[] args) {
////        System.out.println("Actors 50");
////        System.out.println("Engineers 50");
////
////        String format = "%-9s %5d\n";
////        System.out.printf(format, "Actors", 50);
////        System.out.printf(format, "Engineers", 7000);
//
//
//
//        Scanner sc = new Scanner(System.in);
//        System.out.print("please enter your password: ");
//        String password = sc.next();
//
//        System.out.println("Thankyou your password is: " + password);
//
//    }
//}
//




















//public class Main {
//    public static void main(String[] args) {
//
//        Student s1 = new Student("Himanshu", "Male", 5.80, 75.00);
//        s1.setRoll(1);
//        s1.setRank(5);
//        s1.setClassNumber(10);
//        System.out.println(s1.getName());
//        System.out.println(s1.calculateBMI());
//        System.out.println(s1.getPetName());
//    }
//}
//
//




























//class Main {
//
//    Main() {
//        super();
//    }
//
//    public static void main(String[] args) {
//
//        Society s1 = new Society();
//        s1.setId(1L);
//        s1.setName("s1", "a");
//        Society s2 = new Society();
//        s1.setId(2L);
//        s2.setName("s2", "b");
//
//        Tower t1 = new Tower();
//        t1.setName("a");
//        t1.setType("duplex");
//        t1.setSocietyId(s1.getId());
//
//        Tower t2 = new Tower();
//        t2.setName("a");
//        t2.setType("flat-build");
//        t2.setSocietyId(s2.getId());
//
//        Tower t3 = new Tower();
//        t3.setName("a");
//        t3.setType("duplex");
//        t3.setSocietyId(s1.getId());
//
//        Tower t4 = new Tower();
//        t4.setName("a");
//        t4.setType("flat-build");
//        t4.setSocietyId(s2.getId());
//
//
//        Mobile m1 = new Mobile("samsung", "s1", 40000.00);
////        System.out.println(m1);
//        Laptop l1 = new Laptop("Apple", "mac", 250000.00);
//
//        ElectronicDevice e1 = new Mobile("Apple", "14+", 120000.00);
//        ElectronicDevice e2 = new Laptop("Apple", "mac", 250000.00);
//
//
////        System.out.println(e1);
////        System.out.println(m1);
////        System.out.println(l1);
//
//
//        int sum = Calculator.sum(1,2,3,4,5,6,7,8,9,0,123,123,12312,443,543654,67457,657,34);
////        System.out.println(sum);
//
//        String a = "ankit"; //string pool
//        String b = "ankit";
//
//        b+="xxx";
//
//        System.out.println(a);
//        System.out.println(b);
//    }
//}



//JDK -> JRE -> it searches for main method

/*

int a  = new Integer(10);  -> b123rr4
a = new Integer(20); -> 8hgs245

    class <Name of the class> {
        public static void main (String[] args) {
            //your code ges here
        }
    }
*/


/*

    pascal case -> JavaIsAProgrammingLanguage
    camel case -> javaIsAProgrammingLanguage
    kebab case -> java-is-a-programming-language
    snake case -> java_is_a_programming_language

 */

/*
    int, float, double, char, boolean, long, short,

    Integer, Float, Double, Character, Boolean, Long, Short, BigInteger, String, BigDecimal
 */