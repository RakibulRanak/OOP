
package Multithreading;

/**
 * There are 4 arrays to sum up in one array ,have to use multithreading 
 * 2 arrays and other 2 arrays are summed up at a time 
 * lastly, 2 summed up arrays are summed up 
 * Used Interface(Implements Runnable)
 *
 * @author MD. RAKIBUL HASAN RANAK
 * Reg No:2017831005
 *
 */

public class MultithreadSumUp4Arrays {

    public static void main(String[] args) {
        int[] finalsum = new int[5];
        Sum1 obj1 = new Sum1();
        Sum2 obj2 = new Sum2();
        Thread a = new Thread(obj1);
        Thread b = new Thread(obj2);
        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {

        }
        System.out.println("Summation Array of four arrays:");
        for (int i = 0; i < 5; i++) {
            finalsum[i] = obj1.sum1[i] + obj2.sum2[i];
            System.out.print(finalsum[i] + " ");
        }
        System.out.println("");

    }
}

class Sum1 extends A implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sum1[i] = ara1[i] + ara2[i];
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }
}

class Sum2 extends A implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sum2[i] = ara3[i] + ara4[i];
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
    }
}

class A {

    int[] ara1 = {1, 7, 89, 13, 40};
    int[] ara2 = {3, 21, 62, 51, 57};
    int[] ara3 = {78, 22, 61, 57, 432};
    int[] ara4 = {13, 98, 0, 25, 76};
    int[] sum1 = new int[5];
    int[] sum2 = new int[5];
}
