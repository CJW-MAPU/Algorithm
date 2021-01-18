package Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String str = dayTime.format(new Date((time)));
        System.out.println(str);

        System.out.println(time);
        System.out.println(((time >> 0x10) ^ (time >> 0x08)) + ((time >> 0x18) ^ (time)));

        
    }
}