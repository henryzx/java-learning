package cc150.chpt12;

/**
 * Created by zhengxiao on 7/16/14.
 */
public class Cons<T> {
    public T data;
    public Cons<T> next;

    public Cons(T data, Cons<T> next) {
        this.data = data;
        this.next = next;
    }
}
