package Lock;

public class lock {
    public static final String lock1 = "lock1";
    public static final String lock2 = "lock2";
    // 创建一个线程锁程序
    public static void main(String[] args) {
        
        Thread thread1 = new Thread(() -> {
            System.out.println("线程一开始");
            synchronized (lock1) {
                System.out.println("线程一1锁开始");
                try {
                    Thread.sleep(1000);
                    System.out.println("线程一1锁结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("线程一2锁");
                }
                System.out.println("线程一1锁结束");
            }
            System.out.println("线程一结束");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("线程二开始");
            synchronized (lock2) {
                System.out.println("线程二1锁开始");
                try {
                    Thread.sleep(1000);
                    System.out.println("线程二1锁结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("线程二2锁");
                }
                System.out.println("线程二1锁结束");
            }
            System.out.println("线程二结束");
        });
        thread1.start();
        thread2.start();
    }
        

}
