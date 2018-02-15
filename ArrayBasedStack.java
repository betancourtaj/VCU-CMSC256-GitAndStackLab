import java.util.EmptyStackException;
import java.util.Arrays;

public class ArrayBasedStack<T> implements StackInterface<T> {
   
   private T[] data;
   private int topOfStack;
   private final int INITIAL_CAPACITY = 5;
   private boolean initialized = false;
   private int capacity;
   
   public ArrayBasedStack(int capacity) {
      if(capacity < 0) {
         throw new IllegalArgumentException("Illegal capacity");
      }
      this.capacity = capacity;
      topOfStack = -1;
      initialized = true;
      data = (T[]) new Object[this.capacity];
   } 
   
   public ArrayBasedStack() {
      this.capacity = INITIAL_CAPACITY;
      topOfStack = -1;
      initialized = true;
      data = (T[]) new Object[this.capacity];
   }
   
   private void expandArray() {
      Arrays.copyOf(data, data.length * 2);
   }
   
   public void push(T value) {
      if(topOfStack < this.capacity) {
         topOfStack++;
         data[topOfStack] = value;
      } else {
         expandArray();
      }
   }
   
   public T pop() {
      if(topOfStack == -1) {
         throw new EmptyStackException();
      }
      
      T obj = null;
      obj = data[topOfStack];
      data[topOfStack] = null;
      topOfStack--;
         
      return obj;
   }
  
   public T peek() {
      if(isEmpty()) {
         throw new EmptyStackException();
      }
      return data[topOfStack];
   }
  
   public boolean isEmpty() {
      if(topOfStack > -1)
         return false;
         
      return true;
   }
  
   public void clear() {
      while(!isEmpty()) {
         pop();
      }
   }
}  