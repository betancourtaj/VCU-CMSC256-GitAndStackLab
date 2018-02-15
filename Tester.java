public class Tester{

   private static StackInterface<String> stack = new ArrayBasedStack(3);

   public static void main(String[] args) {
      System.out.println(stack.isEmpty());
      
      stack.push("b");
      stack.push("e");
      stack.peek();
      stack.pop();
      stack.peek();
      stack.pop();
      stack.push("o");
      stack.pop();
      
      System.out.println(stack.isEmpty());
      stack.pop();
   }
}