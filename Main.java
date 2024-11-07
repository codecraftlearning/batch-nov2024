import models.Mobile;
import models.Society;
import models.Tower;

import java.math.BigInteger;

class Main {

    Main() {
        super();
    }

    public static void main(String[] args) {

        Society s1 = new Society();
        s1.setId(1L);
        s1.setName("s1", "a");
        Society s2 = new Society();
        s1.setId(2L);
        s2.setName("s2", "b");

        Tower t1 = new Tower();
        t1.setName("a");
        t1.setType("duplex");
        t1.setSocietyId(s1.getId());

        Tower t2 = new Tower();
        t2.setName("a");
        t2.setType("flat-build");
        t2.setSocietyId(s2.getId());

        Tower t3 = new Tower();
        t3.setName("a");
        t3.setType("duplex");
        t3.setSocietyId(s1.getId());

        Tower t4 = new Tower();
        t4.setName("a");
        t4.setType("flat-build");
        t4.setSocietyId(s2.getId());


        Mobile m1 = new Mobile("samsung", "s1", 40000.00);
        System.out.println(m1);
    }
}



//JDK -> JRE -> it searches for main method

/*
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