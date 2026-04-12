package ThreadPractice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BandCount {
     private String name;
     private int count;

     public void getMount(int count){
          if (count >= getCount()){
               System.out.println("剩余余额" + getCount() +"元");
          }
     }
}
