import java.util.*;
public class MinimumWindowSizeSubstringm {
    public static String output(String s,String t) {
        int freqt[]=new int [256];
        int freqs[]=new int [256];
        for(int i=0;i<t.length();i++){
            freqt[t.charAt(i)]++;
        }
        int si=0;
        
        int ans=Integer.MAX_VALUE;
        int count=0;
        int k=-1;
        for(int ei=0;ei<s.length();ei++){
            freqs[s.charAt(ei)]++;
            if(freqt[s.charAt(ei)]>=freqs[s.charAt(ei)]){
                count++;
            }
            if(count==t.length()){
                while (freqs[s.charAt(si)]>freqt[s.charAt(si)]){
                    freqs[s.charAt(si)]--; si++;
                }
                if(ans>ei-si+1){
                    ans=ei-si+1;
                    k=ans;
                }

            }
        }
        if(k==-1){
            return "";
        }
        return s.substring(si, si+ans);

        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s =sc.next();
        String t =sc.next();
        System.out.println(output(s, t));
    }
}
