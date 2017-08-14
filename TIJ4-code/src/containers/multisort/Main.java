package containers.multisort;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<StatReport> data = new ArrayList<StatReport>() {
            {
                add(new StatReport());
                add(new StatReport());
                add(new StatReport());
                add(new StatReport());
                add(new StatReport());
                add(new StatReport());
                add(new StatReport());
                add(new StatReport());
                add(new StatReport());
                add(new StatReport());
            }
        };

        System.out.println(data);

        data.sort(new StatReportComparetor());
        System.out.println("--===--");
        System.out.println(data);
        data.sort(new StatReportComparetor());
    }

}
