package Lessons.lesson4;


public class GenBox <T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public GenBox(T obj) {
        this.obj = obj;
    }
}
