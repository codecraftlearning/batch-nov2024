import models.myobj.MyObj;

import java.sql.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.*;





class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/code-craft";
        String uname = "root";
        String password = "root";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, uname, password);
        System.out.println("established connection!!");

//        String query = """
//                    create table user (
//                        id int auto_increment primary key,
//                        name varchar(50) not null,
//                        email varchar(100) unique not null,
//                        created_at timestamp default current_timestamp
//                    )
//                """;

//        String query = """
//                    insert into user (name, email) value ('ankit2', 'codecraft2.com'), ('himanshu', 'himanshu@gmail.com'), ('xyz', 'xyz@gmail.com');
//                """;

//        String query = """
//                    select * from user;
//                """;
//
//        Statement statement = connection.createStatement();
////        statement.execute(query);
//        ResultSet set = statement.executeQuery(query);
//        Map<String, String> users = new HashMap<>();
//        while (set.next()) {
//            users.put(set.getString("name"), set.getString("email"));
//        }
//        System.out.println(users);



//        String query = """
//                    insert into user (name, email) values (?, ?);
//                """;
//        PreparedStatement preparedStatement = connection.prepareStatement(query);
//        preparedStatement.setString(1,"abcd");
//        preparedStatement.setString(2,"abcd@gmail.com");
//
//        preparedStatement.execute();

        String query = "SELECT * FROM user WHERE name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,"abcd");

        preparedStatement.execute(query);

        connection.close();
    }
}

// how to use insert query in jdbc using variables

















//
//class Main {
//    public static void main(String[] args) {
//        String st = "abbaredd";
//
//
//        Map<Character, Integer> carMap = new HashMap<>();
//        char[] stArr = st.toCharArray();
//        String res = "";
//        for (int i = 0; i<stArr.length; i++) {
//            if (carMap.containsKey(stArr[i])) {
//                res += stArr[i];
//            } else {
//                carMap.put(stArr[i], 0);
//            }
//        }
//        System.out.println(res);
//
//        String res2 = st.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
//        System.out.println(res2);
//
//        String res3 = st.chars().boxed().collect(Collectors.groupingBy(c -> c, HashMap::new, Collectors.counting()))
//                .entrySet().stream().filter(entry -> entry.getValue() > 1)
//                .map(entry -> String.valueOf((char) entry.getKey().intValue()))
//                .collect(Collectors.joining());
//
//        System.out.println(res3);
//    }
//}







































//deadlock problem


//class Main {
//    static final Object lock1 = new Object();
//    static final Object lock2 = new Object();
//
//    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            synchronized (lock1) {
//                System.out.println("Ankit: Holding backetball...");
//
//                try { Thread.sleep(100); } catch (InterruptedException e) {}
//
//                System.out.println("Ankit: Waiting for football...");
//                synchronized (lock2) {
//                    System.out.println("ankit: Acquired football!");
//                }
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            synchronized (lock2) {
//                System.out.println("himanshu: Holding football...");
//
//                try { Thread.sleep(100); } catch (InterruptedException e) {}
//
//                System.out.println("himanshu: Waiting for basketball...");
//                synchronized (lock1) {
//                    System.out.println("himanshu: Acquired basketball!");
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//    }
//}



//producer consumer problem
// producer -> produces and consumer -> consumes

//class Resource {
//    private Queue<String> items = new PriorityQueue<>();
//    private String ing1;
//    private String ing2;
//
//    public synchronized void createIngredient1() throws InterruptedException {
//        this.ing1 = "ing1";
//        notify();
//    }
//
//    public synchronized void createIngredient2() throws InterruptedException {
//        this.ing2 = "ing2";
//        notify();
//    }
//
//    public synchronized void addItem (String item) {
//        items.add(item);
//        notify();
//    }
//
//    public synchronized String getItem() throws InterruptedException {
//        wait();
//        return items.poll();
//    }
//
//    public void printItems() {
//        System.out.println("Resource summary: "+this.items);
//    }
//}
//
//class Producer extends Thread {
//
//    private Resource resource;
//    private String item;
//
//    public Producer (Resource resource, String item) {
//        this.resource = resource;
//        this.item = item;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i<5; i++) {
//            try {
//                Thread.sleep(1000);
//                this.resource.createIngredient1();
//                this.resource.createIngredient2();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            this.resource.addItem(this.item);
//            System.out.printf("Producer %s: item produced\n", this.item);
//        }
//    }
//}
//
//class Consumer extends Thread {
//    private Resource resource;
//
//    public Consumer (String name, Resource resource) {
//        this.resource = resource;
//        super.setName(name);
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            String item = null;
//            try {
//                item = resource.getItem();
//
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            if (item != null) {
//                System.out.printf("Consumer %s: consumed %s\n", super.getName(), item);
//            } else {
//                System.out.println("No items in resource");
//            }
//        }
//    }
//}
//
//class Main {
//    public static void main(String[] args) throws InterruptedException {
//        Resource resource = new Resource();
//        Producer producer = new Producer(resource, "milk");
//        Consumer consumer1 = new Consumer("himanshu", resource);
//        Consumer consumer2 = new Consumer("ankit", resource);
//        producer.start();
//        consumer2.start();
//        consumer1.start();
//    }
//}


































//class SharedResource {
//    ReentrantLock reentrantLock = new ReentrantLock(true);
//    private String data;
//
//    SharedResource() {
//        this.data = "";
//    }
//
//    public synchronized void concat(String st) {
//        this.data += st;
//    }
//
//    public void concat2(String st) {
//        synchronized (this) {
//            this.data += st;
//        }
//    }
//
//    public void concat3(String st) {
////        this.reentrantLock.lock();
////        this.data += st;
////        this.reentrantLock.unlock();
//
//        if (this.reentrantLock.tryLock()) {
//            try {
//                this.data += st;
//            } finally {
//                this.reentrantLock.unlock();
//            }
//        }
//    }
//
//    public synchronized static void print() {
//        for(int i =0; i<10; i++) {
//            System.out.println(i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public String getData() {
//        return this.data;
//    }
//}
//
//class Main {
//    public static void main(String[] args) throws InterruptedException {
//        SharedResource resource = new SharedResource();
//
//        Thread t1 = new Thread(() -> {
//            resource.concat3("thread 1");
////            SharedResource.print();
//        });
//        Thread t2 = new Thread(() -> {
//            resource.concat3("thread 2");
////            SharedResource.print();
//        });
//        Thread t3 = new Thread(() -> {
//            resource.concat3("thread 3");
////            SharedResource.print();
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//        t1.join();
//        t2.join();
//        t3.join();
//
//        System.out.println(resource.getData());
//    }
//}



/*
    4 types of synchronization
        1). method
        2). block
        3). static
        4). reentrant
 */


























////callable and Future
//
//class MathsProblem<T> implements Callable<T> {
//    private final FutureTask<T> futureTask;
//    private final Thread thread;
//
//    public MathsProblem() {
//        this.futureTask = new FutureTask<>(this);
//        this.thread = new Thread(this.futureTask);
//    }
//
//    @Override
//    public T call() throws Exception {
//        return (T) Stream.generate(() -> new Random().nextInt() % 100).limit(10).reduce(Integer::sum).get();
//    }
//
//    public void start() {
//        this.thread.start();
//    }
//
//    public T get() throws ExecutionException, InterruptedException {
//        return this.futureTask.get();
//    }
//}
//
//class Main {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MathsProblem<Integer> problem = new MathsProblem<>();
//        problem.start();
//        int sum = problem.get();
//        System.out.println(sum);
////
////        ExecutorService executorService = Executors.newSingleThreadExecutor();
////        Future<Integer> future = executorService.submit(problem);
////        int sum2 = future.get();
////        System.out.println(sum2);
//
//        //create callable
//        //create futuretask
//        // create thread with future task
//        //start thread
//        //get the future task value
//
//
//
//        //create callable
//        //start thread
//        //get the future value
//
//    }
//}


/*

start() → Starts the thread.
run() → Defines the task performed by the thread.
sleep(ms) → Puts the thread to sleep for a given time (in milliseconds).
join() → Waits for a thread to finish execution before continuing.
setName("name") → Sets the thread's name.
getName() → Returns the thread's name.
setPriority(int) → Sets thread priority (1 to 10).
yield() → Temporarily pauses execution to allow other threads to execute.
isAlive() → Checks if the thread is still running.


New → Created but not started (new Thread()).
Runnable → Ready to run (start() called).
Running → Executing the run() method.
Blocked/Waiting → Waiting for a resource or another thread.
Terminated → Execution finished.


 */


































//
//class Shopping extends Thread {
//    @Override
//    public void run() {
//        Thread.yield();
//        System.out.println(Thread.currentThread().getName() + ":The shopping thread is working");
//    }
//}
//
//class Cleaning implements Runnable {
//    private Cleaning() {}
//
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() + ": The cleaning thread is working");
//    }
//
//    public static Thread getThread(String suffix, int priority) {
//        Thread t1 = new Thread(new Cleaning());
//        t1.setPriority(priority);
//        t1.setName("Cleaning Thread: " + suffix);
//
//        return t1;
//    }
//}
//
//
//class Main {
//    public static void main(String[] args) throws InterruptedException {
//
//        Shopping shopping = new Shopping();
//        shopping.setName("Shopping Thread");
//
//        Thread cleaningThread1 = Cleaning.getThread("bedroom", 4);
//        Thread cleaningThread2 = Cleaning.getThread("living room", 1);
//        Thread cleaningThread3 = Cleaning.getThread("dining room", 2);
//        Thread cleaningThread4 = Cleaning.getThread("kitchen room", 3);
//
//        shopping.start();
//        cleaningThread1.start();
//        cleaningThread2.start();
//        cleaningThread3.start();
//        cleaningThread4.start();
//
//        shopping.join();
//        System.out.println("I need something after the execution of shopping thread");
//
//        System.out.println("Main Thread ends");
//    }
//}




//  A[10], B[10], C[10]  -> result sum of all the list ((Sum of A) + (sum of B) + (Sum of c))






















//class Main {
//    public static void main(String[] args) {
////        List<Integer> nums = Stream.generate(() -> new Random().nextInt()).limit(1000).toList();
////        System.out.println(nums.size());
////
////        List<Integer> allOdds = nums.stream().filter(n -> n % 2 == 1).toList();
////        System.out.println(allOdds.size());
////
////
////        List<Integer> distincts = nums.stream().distinct().toList();
////        System.out.println(distincts.size());
//
//        Long start = System.nanoTime();
//        List<List<Integer>> lol = Stream.generate(() -> {
//            return Stream.generate(() -> new Random().nextInt()).limit(10000).toList();
//        }).limit(510).toList();
//        Long end = System.nanoTime();
//        System.out.printf("Time Taken %d\n", (end-start)/100000);
//
//        start = System.nanoTime();
//        List<Integer> lolFlat = lol.stream().flatMap(List::stream).toList();
//        end = System.nanoTime();
//        System.out.printf("Time Taken %d\n", (end-start)/100000);
//
//        start = System.nanoTime();
//        List<Integer> lolFlatDouble1 = lolFlat.stream().map(n -> n * 2).toList();
//        end = System.nanoTime();
//        System.out.printf("Time Taken %d\n", (end-start)/100000);
//
//
//        start = System.nanoTime();
//        List<Integer> lolFlatDouble2 = lolFlat.parallelStream().map(n -> n * 2).toList();
//        end = System.nanoTime();
//        System.out.printf("Time Taken %d\n", (end-start)/100000);
//    }
//}































//class Main {
//    public static void main(String[] args) {
//        List<Integer> nums = Stream.iterate(1, n -> n+1).limit(10000).toList();
//        Stream<Integer> stream1 = nums.stream();
//        List<MyObj> objs = stream1.map(n -> new MyObj(n, "")).toList();
////        List<MyObj> objs2 = stream1.map(n -> new MyObj(n*2, "a")).toList();
//        List<MyObj> objs2 = nums.stream().map(n -> new MyObj(n*2, "a")).toList();
//
//        List<MyObj> oddObjs = objs.stream().filter(obj -> obj.roll % 2 != 0).peek(obj -> {
//            obj.roll *= 2;
//            obj.name = "default";
//        }).toList();
//        System.out.println(oddObjs);
//    }
//}





































//class Main {
//    public static void main(String[] args) {
//        List<Integer> nums = Stream.iterate(1, n -> n+1).limit(100_000_000).toList();
//
//        long start = System.nanoTime();
//
//        Long sum = 0l;
//        for (Long i = 0l; i<nums.size(); i++) {
//            sum += (nums.get(Math.toIntExact(i)) * 2);
//        }
//        System.out.println(sum);
//
//        long end = System.nanoTime();
//        System.out.println((end - start)/1_000_000);
//
//        System.out.println();
//
//        start = System.nanoTime();
//
//        Long sum2 = nums.stream().map(i -> Long.valueOf(i*2)).reduce(0L, Long::sum);
//        System.out.println(sum2);
//
//        end = System.nanoTime();
//        System.out.println((end - start)/1_000_000);
//
//
//        System.out.println();
//
//        start = System.nanoTime();
//
//        Long sum3 = (long) nums.stream().mapToInt(i -> i * 2).sum();
//        System.out.println(sum3);
//
//        end = System.nanoTime();
//        System.out.println((end - start)/1_000_000);
//    }
//}














//class Main {
//    public static void main(String[] args) {
//        long start = System.nanoTime();
//        long range = 1_000_000_000;
//        long sum = 0;
//        for (long i = 1; i<=range; i++) {
//            sum += i;
//        }
//        System.out.println(sum);
//        long end = System.nanoTime();
//        System.out.println((end - start)/1_000_000);
//
//
//        System.out.println();
//
////        start = System.nanoTime();
////        Long range2 = 1_000_000_000L;
////        Long sum2 = 0L;
////        for (Long i = 1L; i<=range2; i++) {
////            sum2 += i; // sum2 = sum2 + i; => sum2 = Long.valueOf(sum2.longValue() + i.longValue());
////        }
////        System.out.println(sum2);
////        end = System.nanoTime();
////        System.out.println((end - start)/1_000_000);
//
////        System.out.println();
//
//        start = System.nanoTime();
//        long sum3 = LongStream.range(0, 1_000_000_001).sum();
//        System.out.println(sum3);
//        end = System.nanoTime();
//        System.out.println((end - start)/1_000_000);
//    }
//}
































//import interfaces.CustomInterface;
//import models.myobj.MyObj;
//
//import java.util.*;
////
//
//abstract class TestX {
//    abstract public void print();
//}
//
//class Main {
//
//    public static void main(String[] args) {
//
//        CustomInterface customInterface = new CustomInterface() {
//            @Override
//            public String changeCase(String value, String type) {
//                return null;
//            }
//
//            @Override
//            public String changeCase2(String value, String type) {
//                return null;
//            }
//        };
//
//        customInterface.printx();
//
//        TestX testX = new TestX() {
//            @Override
//            public void print() {
//                System.out.println("testx");
//            }
//        };

//        TestX testX1 = () -> System.out.println("asd");

//        testX.print();
//
//        List<MyObjLastDigitCompare> objs = new ArrayList<>();
//        objs.add(new MyObjLastDigitCompare(1, "a"));
//        objs.add(new MyObjLastDigitCompare(34, "b"));
//        objs.add(new MyObjLastDigitCompare(146, "c"));
//        objs.add(new MyObjLastDigitCompare(23, "d"));
//        objs.add(new MyObjLastDigitCompare(12, "e"));
//        objs.add(new MyObjLastDigitCompare(67, "f"));
//
//        Collections.sort(objs);
//
//        System.out.println(objs);
//    }
//}




//class Main {
//    public static void main(String[] args) {
//
//        List<Integer> nums = new ArrayList<>();
//        nums.add(23);
//        nums.add(56);
//        nums.add(345);
//        nums.add(78);
//        nums.add(12);
//        nums.add(1);
//        nums.add(79);
//        nums.add(3);
//


////        Comparator<Integer> lastDigitComparator = new Comparator<Integer>() {
////            @Override
////            public int compare(Integer o1, Integer o2) {
////                return (o1 % 10) - (o2 % 10);
////            }
////        };
////
////
////        Comparator<Integer> lastDigitComparator = (Integer o1, Integer o2)-> {
////                return (o1 % 10) - (o2 % 10);
////        };
////        Comparator<Integer> lastDigitComparator = (Integer o1, Integer o2) -> (o1 % 10) - (o2 % 10);
//
////        Comparator<Integer> lastDigitComparator = (o1, o2) -> (o1 % 10) - (o2 % 10);
////
//            Collections.sort(nums);
////        nums.sort(lastDigitComparator);
////
//
////        nums.sort((o1, o2) -> (o1 % 10) - (o2 % 10));
//        nums.sort(Comparator.comparingInt(o -> (o % 10)));
//
//        System.out.println(nums);
//    }

//    public static void bubbleSort(List<Integer> nums) {
//        for (int i = 0; i<nums.size(); i++) {
//            for (int j = i+1; j<nums.size(); j++) {
//                int a = nums.get(i) % 10;
//                int b = nums.get(j) % 10;
//
//                if (a > b) {
//                    int temp = nums.get(i);   // temp = num[i]
//                    nums.set(i, nums.get(j)); // num[i] = num[j]
//                    nums.set(j, temp);        // num[j] = temp
//                }
//            }
//        }
//    }
//
//}













//class Main {
//    public static void main(String[] args) {
//        String s = "some string";
//
//        String para = "";
//        para += "first sentence\n";
//        para += "second sentance\n";
//        para += "third sentence";
//
//
//        String para2 = """
//                first sentence
//                second sentence
//                third sentence
//                """;
//
////        System.out.println(para);
//        System.out.println(para2);
//    }
//}




















//public class Main {
//    public static void main(String[] args) {
//
//        CustomHashMap<Integer, String> map = new CustomHashMap<>();
//        map.put(1, "asd");
//        map.put(2, "wer");
//        map.put(3, "tyu");
//        map.put(4, "iop");
//        map.put(5, "qwe");
//        map.put(18, "zxc");
//        map.put(45, "bnm");
//        map.put(34, "bnm");
//        map.put(1, "xxx");
//        map.put(2, "yyy");
//        map.put(3, "zzz");
//
//        System.out.println(map.entrySet());
//    }
//}
//
















//public class Main {
//    public static void main(String[] args) {
//
//        EntrySet<Integer, String> entrySet1 = new EntrySet<>(1, "asd");
//        EntrySet<String, String> entrySet2 = new EntrySet<>("ret", "asd");
//        EntrySet<Integer, Double> entrySet3 = new EntrySet<>(1, 1.1);
//        EntrySet<String, Integer> entrySet4 = new EntrySet<>("rty", 1);
//
//        System.out.println(entrySet1);
//        System.out.println(entrySet2);
//        System.out.println(entrySet3);
//        System.out.println(entrySet4);
//
//    }
//}























//public class Main {
//    public static void main(String[] args) {
//
//        Map<Integer, String> studentMap = new HashMap<>();
//        studentMap.put(1, "asdasd");
////        {
////
////            //only key ; not value
////            int n = 16; => 12
////            int hashCode = 12;
////            int index = hashCode & (n-1); //=> 12   > 10
////            n = n * 2;
////            index = hashCode & (n-1); // 12
////            System.out.println(index);
////        }
//
//        studentMap.put(2, "uiiu");
//        studentMap.put(3, "qweeqw"); // hashcode = 3; => index = 3
//        studentMap.put(3, "qwerty"); // hashcode = 3; => index = 3
//        studentMap.put(18, "lamp");
//
//
//
//        /*
//            HashMap<Type of Key, Type of value> -
//                ArrayList<LinkedList>
//                    -  LinkedList<Map.Entry>
//                        - Map.Entry<Type of Key, Type of value>
//        */
//
//
//        //new entry => < 3, qwerty>
//       //exising entries =>  <3,qweeqw> -> Integer(3).equals(Integer(3)) -> true // replace the value
//
//        //new entry <18, lamp>
//        //existing entries <2, uiiu> => Integer(2).equals(Integer(18) -> false // append the value
////
////        System.out.println(Integer.valueOf("1").hashCode());   // for a Integer "hashCode -> value" "equals -> value1 == value2"
//        // hashCode -> 1  // equals (1 == 1) => true
//
//
//        /*
//                x(1)(a) -> (unique id) (hashcode) = 1 => noOfBuckets % hashcode = 1
//                y(2)(b) -> (unique id) (hashcode) = 2 => noOfBuckets % hashcode = 2
//                z(1)(c) -> (unique id) (hashcode) = 1 => noOfBuckets % hashcode = 1
//                i(17)(d) -> (unique id) (hashcode) = 17 => noOfBuckets % hashcode = 1
//
//                       i
//                       z
//                       x  y
//                    -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -
//                    0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
//
//
//         */
//
//
////        System.out.println(studentMap);
//    }
//}



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