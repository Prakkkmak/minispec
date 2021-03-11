package main.java.model;

public abstract class Type {
    protected Integer min;
    protected Integer max;


    public Type(Integer min, Integer max){
        this.min = min;
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }


    @Override
    public abstract String toString();
}
