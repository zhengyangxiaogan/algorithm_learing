import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by zy on 2017/8/7.
 */
public class Shell {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h<N/4) h = 4*h+1;
        while(h>=1){
            for(int i=h; i<N; i++){
                for(int j=i; j >=h && less(a[j], a[j-h]); j-=h){
                    exch(a, j, j - h);
                }
            }
            h = h/4;
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

    private static void show(Comparable[] a){
        for(int i=0; i < a.length; i ++)
        {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        In in = new In("D:\\java\\algorithm_learing\\2.1\\a.txt");
        String[] a = in.readAllStrings();
        StdOut.println(a.length);
        sort(a);
        show(a);
    }
}
