import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by zy on 2017/8/7.
 */
public class Q_2_2_11 {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) {
            return ;
        }
        int mid = lo + (hi-lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        //2.2.2.2 测试数组是否有效来规避无效的归并
/*        if(less(a[mid+1], a[mid])){
            merge(a, lo, mid, hi);
        }*/

        //2.2.2.1 对小规模的数组进行插入排序
        if(a.length <50){
            int temp=a.length;
            for(int m=0; m<temp; m++){
                for(int n=m; n>0 && less(a[n], a[n-1]); n--){
                    exch(a, n, n-1);
                }
            }
        }else merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for(int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args) {
        int N = 50;
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform();
        }
        sort(a);
        show(a);
    }

}
