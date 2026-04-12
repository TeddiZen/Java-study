package ThreadPractice;

public class Test1 {
    static void main(String[] args) {
//        Thread t1 = new ThreadClass1();
//        t1.start();
//        System.out.println("Main thread is running");
//        for (int i = 0; i < 50; i++) {
//            System.out.println("主线程正在运行\t" + i);
//            if (i == 20) {
//                try {
//                    t1.join();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        Thread t2 = new Thread(() -> {
            System.out.println("Runnable is running");
            for (int i = 0; i < 60; i++) {
                System.out.println("Runnable is running\t" + i);
            }
        }, "runnable 1");
        t2.start();
        System.out.println("Main thread is running");
        for (int i = 0; i < 30; i++) {
            System.out.println("主\t线程正在运行\t" + i);
            if (i == 6) {
                try {
                    t2.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
