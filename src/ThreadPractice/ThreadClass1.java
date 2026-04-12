package ThreadPractice;

public class ThreadClass1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("子线程正在运行\t" + i);
        }
    }
}
