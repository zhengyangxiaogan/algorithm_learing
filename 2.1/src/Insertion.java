import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by zy on 2017/8/6.
 */
public class Insertion {
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i=0; i< N; i++){
            for(int j=i; j > 0 && less(a[j], a[j-1]); j--){
                exch(a, j, j-1);
            }
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }

    public static boolean isSorted(Comparable[] a){
        for(int i = 1; i <a.length; i++){
            if(less(a[i], a[i-1])) return false;
            return true;
        }
        return true;
    }

    public static void main(String[] args){
        In in = new In("D:\\java\\algorithm_learing\\2.1\\tiny.txt");
        String[] a = in.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
