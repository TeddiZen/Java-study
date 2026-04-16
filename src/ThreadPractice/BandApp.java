package ThreadPractice;

public class BandApp {
    public static void main(String[] args) {
        BandCount bandCount = new BandCount("账户1", 10000);
        Thread thread1 = new Thread(() -> {
            System.out.println("线程1取款");
            bandCount.getMount(10000);
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("线程2取款");
            bandCount.getMount(10000);
        });
        thread1.start();
        thread2.start();
    }
}
