import java.util.function.Consumer;

class Node<T> {

  T data;
  Pointer<Node<T>> nextPtr;

  public Node(T data, Pointer<Node<T>> nextPtr) {
    this.data = data;
    this.nextPtr = nextPtr;
  }
}

public class List<T> {

  private Pointer<Node<T>> rootPtr;
  private int cnt;

  public List() {
    this.rootPtr = new Pointer<Node<T>>(null);
    this.cnt = 0;
  }

  public void copy(List<T> other) {
    this.rootPtr = recursiveClone(other.rootPtr);
    this.cnt = other.cnt;
  }

  private Pointer<Node<T>> recursiveClone(Pointer<Node<T>> nodePtr) {
    if (nodePtr.isNull()) {
      return new Pointer<Node<T>>();
    } else {
      return new Pointer<Node<T>>(
        new Node<T>(nodePtr.get().data, recursiveClone(nodePtr.get().nextPtr))
      );
    }
  }

  public boolean isEmpty() {
    return this.rootPtr.isNull();
  }

  public void add(T data) {
    recursiveAdd(rootPtr, data);
    this.cnt++;
  }

  private void recursiveAdd(Pointer<Node<T>> nodePtr, T data) {
    if (nodePtr.isNull()) {
      nodePtr.set(new Node<T>(data, new Pointer<Node<T>>()));
    } else {
      recursiveAdd(nodePtr.get().nextPtr, data);
    }
  }

  public void remove() {
    recursiveRemove(rootPtr);
    this.cnt--;
  }

  private void recursiveRemove(Pointer<Node<T>> nodePtr) {
    if (nodePtr.get().nextPtr.isNull()) {
      nodePtr.set(null);
    } else {
      recursiveRemove(nodePtr.get().nextPtr);
    }
  }

  public int size() {
    return this.cnt;
  }

  public void forEach(Consumer<T> fun) {
    recursiveForEach(rootPtr, fun);
  }

  private void recursiveForEach(Pointer<Node<T>> nodePtr, Consumer<T> fun) {
    if (nodePtr.isNull()) {
      return;
    } else {
      fun.accept(nodePtr.get().data);
      recursiveForEach(nodePtr.get().nextPtr, fun);
    }
  }

  public boolean contains(T data) {
    return recursiveContains(rootPtr, data);
  }

  public boolean recursiveContains(Pointer<Node<T>> nodePtr, T data) {
    if (nodePtr.isNull()) {
      return false;
    } else {
      if (nodePtr.get().data.equals(data)) {
        return true;
      } else {
        return recursiveContains(nodePtr.get().nextPtr, data);
      }
    }
  }
}
