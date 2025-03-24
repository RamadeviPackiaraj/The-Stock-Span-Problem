// Time O(n) space O(1)
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
public class Span_Stock_Optimized{
     static ArrayList<Integer> Span_Stock(int[] arr) {
        int n=arr.length;
        //Using Collections.nCopies(n, 0) ensures we can directly update indices without getting IndexOutOfBoundsException.
        ArrayList<Integer> arli=new ArrayList<>(Collections.nCopies(n,0));
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            //stk.peek() returns the top index of the stack.
            while(!st.isEmpty()&&arr[st.peek()]<arr[i]){
                st.pop();
            }//If the stack is empty, it means that all previous elements were smaller than the current element (arr[i]).Since no greater element exists on the left, the span of the current element extends all the way to the beginning of the array.
            if(st.isEmpty()){
                arli.set(i,(i+1));
            }else{
                arli.set(i,i-st.peek());
            }
            st.push(i);  // Push current index to stack

        }
        return arli;
        
    }   public static void main(String[] args) {

        int[] arr = {10, 4, 5, 90, 120, 80};

        ArrayList<Integer> span = Span_Stock(arr);

        for (int x : span) {
            System.out.print(x + " ");
        }
    }
}
