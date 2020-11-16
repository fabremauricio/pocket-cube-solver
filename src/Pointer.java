public class Pointer<T> {

  private T ref;

  public Pointer() {
    this.ref = null;
  }

  public Pointer(T ref) {
    this.ref = ref;
  }

  public void set(T ref) {
    this.ref = ref;
  }

  public T get() {
    return this.ref;
  }

  public boolean isNull() {
    return this.ref == null;
  }
}
