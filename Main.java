import interfaces.IPerson;
import models.ElectronicDevice;
import models.Mobile;
import models.Person;
import models.Student;
import services.FileOperations;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
//




public class Main {
    public static void main(String[] args) {

        Person person = new Person();  /// qw23424wef234
        person.setName("asdasd");
        person.setAge(21);
        person.setComplexion("fair");
        person.setHeight(5.2);
        person.setHeight(45.0);

        FileOperations.writeObject(person, "person.txt");

//        Person p1 = (Person) FileOperations.readObject("person.txt"); //type cast
//        System.out.println(p1);
    }
}
















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