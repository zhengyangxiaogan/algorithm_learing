import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by zy on 2017/8/6.
 */
public class Q_2_1_17 {
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

    private static void show(Double[] a) {
        for(int i=0; i<a.length; i++){
            double x = 1.0*i/a.length;
            double y = a[i]/2.0;
            double rw = 0.3/a.length;
            double rh = a[i]/2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
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

        int N = 50;
        Double[] a = new Double[N];
        for(int i=0; i<N; i++){
            a[i] = StdRandom.uniform();
        }

        StdDraw.setPenColor(Color.RED);
        show(a);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int index =0;
            @Override
            public void run() {
                StdDraw.clear();
                for(int j=index; j > 0 && less(a[j], a[j-1]); j--){//将插入排序的部分拆解，完成一次排序，刷新一次图片
                    exch(a, j, j-1);
                }
                show(a);
                index ++;
                if(index == N){
                    this.cancel();//当排序完成以后，结束定时器的线程
                }
            }
        }, 500,500); //第一个参数是线程中run()第一次开始执行之前需要延时的时间
                                    //第二个参数是线程中run()以后开始执行需要延时的时间
    }
}
