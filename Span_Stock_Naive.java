// Time O(n^2) space O(1)
import java.util.ArrayList;
public class Span_Stock_Naive{
    public static ArrayList<Integer> Span_Stock(int[] arr){
        int n=arr.length;
        ArrayList<Integer> neww=new ArrayList<>();
        for(int i=0;i<n;i++){
            neww.add(1);
        }
        //nested loop for the // decrease
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0&&(arr[i]>=arr[j]);j--){
                neww.set(i,neww.get(i)+1);
            }
        }
        return neww;
    }
    public static void main(String[] args){
        int[] arr={100,80,60,70,60,75,85};
        ArrayList<Integer> neww=Span_Stock(arr);
        for(int x:neww){
            System.out.print(x+" ");
        }
    }
}