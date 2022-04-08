package pl.clockworkjava.advanced.jpa;

public class CountResult {
        private String name;
        private long count;

    public CountResult(String name, long count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "CountResult{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
