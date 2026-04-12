package ThreadPractice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BandCount {
     private String name;
     private int count;
     private final Lock lock = new ReentrantLock();
     public BandCount(String name, int count) {
        this.name = name;
        this.count = count;
     }
     // 代码块同步

     // public void getMount(int count){
     //      synchronized (this) {
     //                if (this.count >= count){
     //                System.out.println("剩余余额" + this.count +"元,可以取款");
     //                this.count -= count;
     //                System.out.println("取款成功,当前余额" + this.count +"元");
     //           }else{
     //                System.out.println("余额不足");
     //           }
     //      }
     // }

     // 方法同步
     // public synchronized void getMount(int count){
     //      if (this.count >= count){
     //           System.out.println("剩余余额" + this.count +"元,可以取款");
     //           this.count -= count;
     //           System.out.println("取款成功,当前余额" + this.count +"元");
     //      }else{
     //           System.out.println("余额不足");
     //      }
     // }

     // 手动lock同步
     public  void getMount(int count){
          lock.lock();
          try {
               if (this.count >= count){
                    System.out.println("剩余余额" + this.count +"元,可以取款");
                    this.count -= count;
                    System.out.println("取款成功,当前余额" + this.count +"元");
               }else{
                    System.out.println("余额不足");
               }
          } finally {
               lock.unlock();
          }
     }
}

     
