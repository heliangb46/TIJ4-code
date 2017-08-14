//: typeinfo/pets/Individual.java
package typeinfo.pets;

/**
 * 个人，个体
 */
public class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public Individual(String name) {
        this.name = name;
    }

    // 'name' is optional:
    public Individual() {
    }

    public long id() {
        return id;
    }

    @Override
    public int compareTo(Individual arg) {
        // Compare by class name first:
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if (firstCompare != 0) {
            //首先按类名排序
            return firstCompare;
        } else if (name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if (secondCompare != 0) {
                //其次按照属性中的name排序
                return secondCompare;
            }
        }
        return (int) (arg.id - id);
        //        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Individual && id == ((Individual) o).id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (name != null) result = 37 * result + name.hashCode();
        result = 37 * result + (int) id;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }

} ///:~
