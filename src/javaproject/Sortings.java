package javaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sortings {

    public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	/*BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int arr[] = {-6, 10, -1, 20, -1, 15, 5, -1, 15};
	//int arr[] = {-6,-1,-1,-1,5,10,15,15,20};
	sort(arr,0,arr.length-1);
	for(int i = 0; i<arr.length; i++) {
	    System.out.print(arr[i]+" ");
	}
	System.out.println();
	int q[] = {-1,10,8,15,20};
	for(int i = 0; i<q.length; i++) {
	    int ele =q[i];
	    int p2 = BSTCeil(arr,arr.length,ele);
	    bw.write(ele+" "+"ceil : "+p2+"\n");
	    int p1 = BSTFloor(arr,arr.length,ele);
	    bw.write(ele+" "+"floor : "+p1+"\n");
	    /*if(p1==-1) bw.write(ele+"" +" : "+ 0);
	    else bw.write(ele+"" +" : "+((p2-p1)+1));*/
	//}
	
	//bw.flush();
	//selectionSort();*/
	//mergeSort();
	//mergeSortV1();
	mergeSortV2InPlace();
    }
    
    static void mergeSortV2InPlace() {
   	int arr[] = {5,4,1,3,2,7};
   	
   	mergeSortV2Rec(arr,0,arr.length);
   	System.out.println("res: "+ Arrays.toString(arr));
   	
       }
    private static void mergeSortV2Rec(int[] arr, int start, int end) {
	if(end-start==1) {
	    return;
	}
	int mid = (start+end)/2;
	mergeSortV2Rec(arr, start, mid);
	mergeSortV2Rec(arr, mid, end);
	mergeV2Inplace(arr,start,mid,end);
    }

    private static void mergeV2Inplace(int[] arr, int start, int mid, int end) {
	int res[] = new int[end-start];
	int i = start;
	int j = mid;
	int k = 0;
	
	while(i<mid &&j<end) {
	    if(arr[i]<=arr[j]) {
		res[k]=arr[i];
		i++;
		k++;
	    }else {
		res[k]=arr[j];
		j++;
		k++;
	    }
	}
	while(i<mid) {
	    res[k]=arr[i];
	    i++;
	    k++;
	}
	while(j<end) {
	    res[k]=arr[j];
	    j++;
	    k++;
	}
	System.out.println("mergeRes : "+Arrays.toString(res));
	for(int p = 0; p<res.length; p++) {
	    arr[start+p] = res[p];
	}
    }

    static void mergeSortV1() {
	int arr[] = {5,4,1,3,2};
	int res[] = mergeSortV1Rec(arr);
	System.out.println("res: "+ Arrays.toString(res));
	
    }
   
    
    private static int[] mergeV1(int arr[], int[] first, int[] second) {
	System.out.println("first : "+Arrays.toString(first));
	System.out.println("second : "+Arrays.toString(second));
	int k = 0;
	int i = 0;
	int j = 0;
	
	while(i< first.length && j<second.length) {
	    if(first[i]<=second[j]) {
		arr[k] = first[i];
		i++;
	    }else {
		arr[k] = second[j];
		j++;
	    }
	    k++;
	}
	while(i< first.length) {
	    arr[k] = first[i];
	    i++;
	    k++;
	}
	while(j< second.length) {
	    arr[k] = second[j];
	    j++;
	    k++;
	}
	System.out.println("result : "+Arrays.toString(arr));
	return arr;
    }

    static int[] mergeSortV1Rec(int arr[]) {
   	if(arr.length ==1) 
   	    return arr;
   	int mid  = arr.length/2;
   	int left[] = mergeSortV1Rec(Arrays.copyOfRange(arr, 0, mid));
   	System.out.println("left : "+Arrays.toString(left));
   	
   	int right[] = mergeSortV1Rec(Arrays.copyOfRange(arr, mid, arr.length));
   	System.out.println("right : "+Arrays.toString(right));
   	return mergeV2(left,right);
      }
    
    private static int[] mergeV2(int[] first, int[] second) {
	System.out.println("merge-first : "+Arrays.toString(first));
	System.out.println("merge-second : "+Arrays.toString(second));
	int k = 0;
	int i = 0;
	int j = 0;
	int res [] = new int[first.length+second.length];
	while(i< first.length && j<second.length) {
	    if(first[i]<=second[j]) {
		res[k] = first[i];
		i++;
	    }else {
		res[k] = second[j];
		j++;
	    }
	    k++;
	}
	while(i< first.length) {
	    res[k] = first[i];
	    i++;
	    k++;
	}
	while(j< second.length) {
	    res[k] = second[j];
	    j++;
	    k++;
	}
	System.out.println("***********result : "+Arrays.toString(res));
	return res;
    }
    static void mergeSort() {
	int arr[] = {5,4,1,3,2};
	mergeSort(arr,0,arr.length-1);
	for(int i = 0; i<arr.length ; i++)
	    System.out.print(arr[i]+" ");
    }
    static  void mergeSort(int arr[], int l, int r){
	//int arr[] = {-6,-1,-2,-4, 5 ,10,15,15,20};
        if(l < r ){
            int m = (l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
           merge(arr,l,m,r);
        }
     }
    
    private static void merge(int arr[],int left, int mid,int right){
        int n1 = mid-left+1;
        int n2 = right-mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        for(int i=0; i<n1; i++){
            L[i] = arr[left+i];
        }
        for(int j=0; j<n2; j++){
            R[j] = arr[mid+1+j];
        }
        
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
         while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
   
    //-6,-1,-1,-1,5,10,15,15,20
    //-6 -1 5 10 15 20 
    // 0  1 2 3  4  5
    //q=13 mid =2;																			
    private static int BSTCeil(int a[],int n,int q){
        int low = 0;//3
        int hi = n-1;//5//3
        int ans = -1;
        while(low <= hi){
            int mid = (low+hi)/2;
            if(a[mid]==q) {
                ans = mid;
                low = mid+1;
            } else if(a[mid]<q){
               low = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return ans;
    }
    // {-6,-1,-1,-1,5,10,15,15,20};
    private static int BSTFloor(int a[],int n,int q){
        int low = 0;
        int hi = n-1;
        int ans = -1;
        while(low <= hi){
            int mid = (low+hi)/2;
            if(a[mid]==q) {
                ans = mid;
                hi = mid-1;
            } else if(a[mid]<q){
                low = mid+1;
             }else{
              hi = mid-1;
             }
        }
        return ans;
    }
    
    /**5.find Frequency of element in array using Compressed array*/
    public static void frequency_5(int a[], int N) {
	int p1=0; int p2=p1+1;
	while(p1<=p2) {
	    if(a[p1]==a[p2]) {
		p1++;
		p2++;
	    }else {
		
	    }
	}
    }
    /**https://www.hackerrank.com/contests/smart-interviews/challenges/si-selection-sort*/
    public static void selectionSort() throws Exception{
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         int tests = Integer.parseInt(br.readLine());
         for (int it = 0; it < tests; it++) {
             int size = Integer.parseInt(br.readLine());
             String inputs[] = br.readLine().split(" ");
             int arr[] = new int[size];
             for(int i =0; i<size; i++ ) {
        	 arr[i]= Integer.parseInt(inputs[i]);
             }
             //2 4 3 1 7
             int Imin = 0;
             boolean swap =false;
             for(int i = 0;i<size;i++) {
        	 Imin = i;
        	 for(int j = i+1; j<size;j++) {
        	     if(arr[Imin]<arr[j]) {
        		 System.out.print(i+" ");
        		 swap =true;
        		 Imin= j;
        	     }
        	 }
        	 if(swap) {
            	 int temp = arr[Imin];
            	 arr[Imin]= arr[i];
            	 arr[i]=temp;
        	 
        	 }
             }
             System.out.println();
             for(int i =0; i<size; i++)
        	 System.out.print(arr[i]+" ");
             System.out.println();
         }
    	}
    

    public static void sortZeroOnesTwos(int arr[], int n){
       int low = 0;
       int mid = 0;
       int high = n-1;
       
       while(mid<=high){
           
           if(arr[mid]==0){
               
               int temp = arr[low];
               arr[low] = arr[mid];
               arr[mid] = temp;
               low++;
               mid++;
           }else if(arr[mid]==1){
               mid++;
           }else if(arr[mid]==2){
               int temp = arr[high];
               arr[high] = arr[mid];
               arr[mid]=temp;
               
               high--;
           }
           
       }
    }
	
}
