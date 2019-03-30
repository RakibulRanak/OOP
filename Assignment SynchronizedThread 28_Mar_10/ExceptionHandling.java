/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionHandling;

/**
 *
 * @author MD. RAKIBUL HASAN
 */
public class ExceptionHandling{
    public static void main(String[] args) throws InterruptedException{
        Thread t=new Thread();
        A obj =new A(t);
        int k=10;
        
        try{
            if(k==10){
            Exception n=new Exception();
            throw n;
        }
        int x=10/0;
        }
        catch(ArithmeticException e){
            System.out.println("Arithmatic Exception");
        }
         catch(Exception e){
            System.out.println(" Exception");
        }
       
       
                
    }
}
class A{
    A(Thread t)throws InterruptedException
    {
        t.start();
        t.sleep(100);
    }
}
