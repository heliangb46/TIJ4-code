package containers.multisort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StatReportComparetor implements Comparator<StatReport> {
    private static Map<String, Method> methodMap = new HashMap<String, Method>();

    public StatReportComparetor() {
        if (!methodMap.containsKey("compareName")) {
            fillMethodMap();
        }
    }

    @Override
    public int compare(StatReport first, StatReport second) {
        try {
            return getReturn(first, second);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void fillMethodMap() {
        String needMethod = "compareName,compareKlass,compareScore";
        Method[] methods = StatReportComparetor.class.getMethods();
        for (Method m : methods) {
            if (needMethod.contains(m.getName())) {
                System.out.println("" + m);
                methodMap.put(m.getName(), m);
            }
        }
    }

    private int getReturn(StatReport first, StatReport second) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int result = 0;
        String firstMethodName = "compareKlass";
        String mainOrder = "asc";

        String secondMethodName = "compareScore";
        String secondOrder = "desc";

        String thirdMethodName = "compareName";
        String thirdOrder = "asc";

        result = (int) methodMap.get(firstMethodName).invoke(this, first, second);
        if ("desc".equals(mainOrder)) {
            result = -result;
        }
        if (result == 0) {
            result = (int) methodMap.get(secondMethodName).invoke(this, first, second);
            if ("desc".equals(secondOrder)) {
                result = -result;
            }
        }
        if (result == 0) {
            result = (int) methodMap.get(thirdMethodName).invoke(this, first, second);
            if ("desc".equals(thirdOrder)) {
                result = -result;
            }
        }

        return result;
    }

    public int compareName(StatReport first, StatReport second) {
        return first.getRealName().compareToIgnoreCase(second.getRealName());
    }

    public int compareKlass(StatReport first, StatReport second) {
        return first.getKlassName().compareToIgnoreCase(second.getKlassName());
    }

    public int compareScore(StatReport first, StatReport second) {
        int firstScore = first.getExamScore() == null ? 0 : first.getExamScore();
        int secondScore = second.getExamScore() == null ? 0 : second.getExamScore();
        return firstScore - secondScore;
    }
}
