package internalchallenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Test1 {
//https://www.hackerrank.com/contests/smart-interviews-vbgm-ic1/challenges
    public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	//int a[] = {-4, -3, 2, 5, 8};
	int a[] = {-3, 5, 8, 2, -4}; 
	//System.out.println(findSumV1(a,a.length));
	BSTFloorCeilMain();

    }
    
    static String findSumV1(int arr[], int n){
        //-4 -3 2 5 8
        for(int i=0;i<n-1; i++){
            int sum = 0;
            sum = arr[i]+arr[i+1];
           int  idx = i+1;
           int sum2 = 0;
           
            for(int j = idx+1; j<n; j++){
                sum2 = sum2+ arr[j];
                //System.out.println("i :"+i+", j: "+j+" sum2 : "+sum2 +", sum1: "+sum);
            }
           // System.out.println("sum1: "+sum+" before k loop : "+sum2);
            
            for(int k= 0; k<i;k++)
        	sum2 =sum2+arr[k];
            System.out.println("sum1: "+sum+", after loop : "+sum2);
            
            if(sum2==sum){
                return "Yes";
            }
            
            boolean barr[] = {true};
        }
        return "No";
    }
    
    private static void BSTFloorCeilMain() throws Exception{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        
	        int size = Integer.parseInt(br.readLine());
	        String inp[] = br.readLine().split(" ");
	        int a[] = new int[size];
	        for (int i= 0; i<size; i++){
	            a[i] = Integer.parseInt(inp[i]);
	        }
	        Arrays.sort(a);
	        //for(int k=0; k<a.length;k++)
	         ///System.out.print(a[k] +" ");
	        //System.out.println();
	        
	        int qSize = Integer.parseInt(br.readLine());
	        for (int q= 0; q<qSize; q++){
	           String ele = br.readLine();
	            //System.out.println("ele: "+ele);
	            //int ceil  = ceilBST(a,a.length,Integer.parseInt(ele));
	            int floor = floorBST(a,a.length,Integer.parseInt(ele));
	            //bw.write(ceil+"\n"); 
	            bw.write(floor+"\n");
	            bw.flush();
	        }
	        
    }
    private static int ceilBST(int a[], int n, int q){
        int low =0; int high=n-1;
        //-6 -1 5 10 15 20
        // 0 1  2  3  4  5
        //q: -4, 8
        int res = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high)/2;
           if(a[mid] >= q){    
                res = a[mid];
                high = mid-1;
            }else{
                low = mid+1;
            }
            
        }
        return res;
    }
    
    private static int floorBST(int a[], int n, int q){
        int low =0; int high=n-1;
        //-6 -1 5 10 15 20
        // 0 1  2  3  4  5
        //q: -4, 8
        int res = Integer.MIN_VALUE;
        while(low <= high){
            int mid = (low + high)/2;
            if (a[mid]==q) return q;
           if(a[mid] > q){    
                high = mid-1;	
            }else{
                low = mid+1;
                res = a[mid];
            }
            
        }
        return res;
    }

}
