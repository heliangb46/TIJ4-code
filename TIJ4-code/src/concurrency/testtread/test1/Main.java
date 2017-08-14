package concurrency.testtread.test1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Map<String, String> tm = new HashMap<String, String>();
        int key = 0;
        int value = 0;
        tm.put("" + key++, "" + value++);
        tm.put("" + key++, "" + value++);
        tm.put("" + key++, "" + value++);

        Iterator<Entry<String, String>> it = tm.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, String> tmp = it.next();
            String keystr = tmp.getKey();
            String valuestr = tmp.getValue();
            new Thread(() -> {
                try {
                    int sl = new Random(Integer.parseInt(tmp.getValue())).nextInt(5000);
                    System.out.println(sl);
                    Thread.sleep(sl);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("key:" + keystr + " value:" + valuestr);
            }).start();
        }
        tm.put("" + key++, "" + value++);
    }
}
