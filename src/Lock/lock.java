package Lock;

public class lock {
    public static final String lock1 = "lock1";
    public static final String lock2 = "lock2";
    // 创建一个线程锁程序
    public static void main(String[] args) {
        
        Thread thread1 = new Thread(() -> {
            System.out.println("线程1开始");
            synchronized (lock2) {
                System.out.println("线程2锁");
            }
            System.out.println("线程1结束");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("线程2开始");
            synchronized (lock1) {
                System.out.println("线程1锁");
            }
            System.out.println("线程2结束");
        });
        
        thread2.start();
    }
        

}
