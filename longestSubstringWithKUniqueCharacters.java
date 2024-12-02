// 1. Using Sliding Window Approach, O(N)

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
 
        longestKSubstr(s, k);
    }
    
    static void longestKSubstr(String str, int k){
        int currStart = 0;
        int currEnd = -1;
        
        int maxWindowSize = 1;
        int maxWindowStart = -1;
        int uniqueCharacters = 0;
        
        int [] charCount = new int[26];
        
        for(int i=0; i<str.length(); i++){
            if(charCount[str.charAt(i) - 'a'] == 0){
                uniqueCharacters++;
            }
            charCount[str.charAt(i) - 'a']++;
        }
        
        if(uniqueCharacters < k){
            System.out.println("Not enough unique characters");
            return;
        }
        
        Arrays.fill(charCount, 0);
        
        for(int i=0; i<str.length(); i++){
            charCount[str.charAt(i) - 'a']++;
            currEnd++;
            
            while(!isValid(charCount, k)){
                charCount[str.charAt(currStart) - 'a']--;
                currStart++;
            }
            
            if(currEnd - currStart + 1 > maxWindowSize){
                maxWindowSize = currEnd - currStart + 1;
                maxWindowStart = currStart;
            }
        }
        
        System.out.println(str.substring(maxWindowStart, currEnd + 1));
        
        System.out.println("Length" + " " + maxWindowSize);
    }
    
    static boolean isValid(int [] charCount, int k){
        int uniqueChars = 0;
        
        for(int i=0; i<charCount.length; i++){
            if(charCount[i] > 0){
                uniqueChars++;
            }
        }
        
        return k >= uniqueChars;
    }
}

// 2. Using Maps, O(N)

//Java program to find the longest substring with k unique characters in a given string
 
import java.io.*;
import java.util.*;
 
class Main {
    public static int longestkSubstr(String S, int k)
    {
        // code here
        Map<Character, Integer> map = new HashMap<>();
 
        int i = -1;
        int j = -1;
        int ans = -1;
 
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            while (i < S.length() - 1) {
                flag1 = true;
                i++;
                char ch = S.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
 
                if (map.size() < k)
                    continue;
                else if (map.size() == k) {
                    int len = i - j;
                    ans = Math.max(len, ans);
                }
                else
                    break;
            }
            while (j < i) {
                flag2 = true;
                j++;
                char ch = S.charAt(j);
 
                if (map.get(ch) == 1)
                    map.remove(ch);
                else
                    map.put(ch, map.get(ch) - 1);
 
                if (map.size() == k) {
                    int len = i - j;
                    ans = Math.max(ans, len);
                    break;
                }
                else if (map.size() > k)
                    continue;
            }
            if (flag1 == false && flag2 == false)
                break;
        }
        return ans;
    }
    public static void main(String[] args)
    {
        String s = "aabacbebebe";
        int k = 3;
 
        // Function Call
        int ans = longestkSubstr(s, k);
        System.out.println(ans);
    }
}

// 3. Using Sets, O(N)2

import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
 
        longestKSubstr(s, k);
    }
    
    static void longestKSubstr(String str, int k){
        HashSet<Character> distinct = new HashSet<Character>();
        int maxLength = 0;
        int startIdx = -1;
        int endIdx = -1;
        
        for(int i=0; i<str.length(); i++){
            distinct.clear();
            distinct.add(str.charAt(i));
            for(int j=i+1; j<str.length(); j++){
             distinct.add(str.charAt(j));
             
             if(distinct.size() == k && (j-i+1) > maxLength){
                maxLength = j - i + 1;
                startIdx = i;
                endIdx = j;
             }
            }
        }
        
        System.out.println(str.substring(startIdx, endIdx + 1));
        System.out.println("Length" + " " + maxLength);
    }
}
