
package File;
import java.util.Scanner;
import java.io.*;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateFile {
    public static void main(String[] args) throws IOException {
        
        File file= new File("output.txt");
        File file2=new File("input.txt");
        file.createNewFile();
        file2.createNewFile();
        
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            
        }
        
        String str,tmp ="";
        String[] word,word_unique;
        word=new String[1000];
        word_unique=new String[1000];
        
        int total_word=0,total_char=0,unique_word=0;
        int[] freq;
        freq=new int[1000];
        
        Scanner input = null;
        try {
            input = new Scanner(file2);
        } catch (FileNotFoundException ex) {
          
        }
        
        str=input.nextLine();
        //System.out.println(str);
        for(int i=0;i<str.length();i++){
            if((str.charAt(i)>='A' && str.charAt(i)<='Z') || (str.charAt(i)>='a' && str.charAt(i)<='z')){
                total_char++;
                tmp+=str.charAt(i);
            }else{
                word[total_word]=tmp;
                tmp="";
                total_word++;
            }
        }
        word[total_word]=tmp;
        total_word++;
        
        
        
        for(int i=0;i<total_word;i++){
            int cnt=1;
            for(int j=i+1;j<total_word;j++){
                if(word[i].length()==word[j].length() && word[i].length()>0){
                                        
                    boolean flag=true;
                    for(int k=0;k<word[i].length();k++){
                        if(word[i].charAt(k)!=word[j].charAt(k)){
                            flag=false;
                        }
                    }
                    if(flag==true){
                        cnt++;
                        word[j]="";
                    }
                }
            }
            if(word[i].length()>0){
                word_unique[unique_word]=word[i];
                freq[unique_word]=cnt;
                unique_word++;
            }
        }
        
        for(int i=0;i<unique_word-1;i++){
            for(int j=i+1;j<unique_word;j++){
                if(freq[i]>freq[j]){
                    int t=freq[i];
                    freq[i]=freq[j];
                    freq[j]=t;
                    
                    tmp=word_unique[i];
                    word_unique[i]=word_unique[j];
                    word_unique[j]=tmp;
                }
            }
        }
        

        output.println("Total chartectar: " + total_char);
        output.println("Total word: " + total_word);
        output.println("Total unique word: " + unique_word);
        for(int i=0;i<unique_word;i++){
            output.println(word_unique[i] + " "+ freq[i]);
        }
        output.close();
        
    }
}