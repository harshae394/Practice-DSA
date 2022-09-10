package javaproject;

import java.util.Arrays;
import java.util.Hashtable;

public class BinarySearchTest {
/**https://www.educative.io/courses/binary-search-coding-interview/mED8kxJWRLE**/
    public static void main(String[] args) {
	/* int[] nums = new int[] {1,3,5,7,11,14};
	System.out.println("findEle: "+ findElement(nums, 1));
	System.out.println("binaryForm");
	binaryRepresentationV2(6);
	binaryRepresentation(6);
	System.out.println("\nbinaryFormOut");
	int res = 0;
	final int in[] = {5,6,7,9,10,11,-1,0,1};
	//{ 4,5,6,7,-3,1,2};
	res = findPivot(in);
	System.out.println(res+" pivotans : "+ Math.min(in[0],in[res]));
	res = getElementIndxInRotatedSortedArray(in,10);
	System.out.println("elementIndxInRotatedSortedArray: "+ res);
	res = getOrToBeInsertedIndexOfElement(new int[] { 1, 2, 4, 6, 8 }, 3);
	//System.out.println("res: " + res);*/
	int arr[] = { 1,2,3,3, 4 ,5,8,9 };
	int q[] = { 4, 3, 2, 6,5,7,8,9,0 };
	for(int x : arr)
	System.out.print(x+", ");
	System.out.println();
	for (int k: q) {
	    int pos = findNoOfElementsTillX(arr, k);
	    System.out.print (k+"="+pos +", ");
	}
    }
    //6==0110
    public static void binaryRepresentation(int num) {
	System.out.println("\n");
	for(int i=1; i<num; i++) { 
	    System.out.print(i%2);
	    num = num/2;
	}
	//if(num==0) System.out.print(num);
    }
    public static void binaryRepresentationV2(int num) {
  	if(num==0) return ;
  	binaryRepresentationV2(num/2);
  	System.out.print(num%2);
      }
    public static int findNoOfElementsTillX(int arr[], int k) {
	int left = 0; 
	int right = arr.length;
	while(left+1 < right) {
	    int mid = (left+right)/2;
	    
	    if(arr[mid]==k && (mid+1<arr.length && arr[mid]<arr[mid+1])) {
		return mid+1;
	    }else if(arr[mid]>k) {
		right = mid;
	    }
	    else {
		left = mid;
	    }
	}
	if(arr[left]>k) {
	    return left;
	}else if(arr[left]==k) {
	    return left+1;
	}else if(right<arr.length && arr[right]>k) {
	    return left;
	}
	else  {
	    return right+1;
	}
	
    }
    public static int getOrToBeInsertedIndexOfElement(int arr[], int k) {
	int left = 0;
	int right = arr.length;
	while (left + 1 < right) {
	    
	    int mid = (left + right) / 2;
	    if (arr[mid] == k) {
		
		return mid;
	    
	    } else if (arr[mid] > k) {
		right = mid;
		//if(right - left==1) return right-1;
	    
	    } else {
		left = mid;
		//if(right-left==1) return right+1;
	    }
	}
	if(arr[left]>=k) {
	    return left;
	}else
	    return right;
	
    }
    
    public static int findElement(int arr[], int k) {
	//{1,3,5,7,11,13};
   	int res = -1;
   	int left = 0;
   	int right = arr.length;//6

   	while (left + 1 < right) {
   	    
   	    int mid = (left + right) / 2;
   	    if (arr[mid] == k)  {
   		return arr[mid];
   	    } else if (arr[mid] > k) {
   		right = mid;
   	    } else {
   		left = mid;
   	    }
   	}
   	if (arr[left] == k) {
   	    return arr[left];
   	}

   	return res;

       }
    

       static int findPivot(int[] nums) {//4,5,6, 7,0,1,2
	   				 //0,1,2, 3,4,5,6
	   int left = 0;
	   int right = nums.length;
	   while (left + 1 < right) {
	       int mid = (right + left) / 2;

	       if (nums[mid - 1] > nums[mid]) {
		   return mid-1;
	       } else if (nums[left] < nums[mid]) {
		   left = mid;
	       } else {
		   right = mid;
	       }
	   }
	   System.out.println("pivot idx: "+left);
	   return left;
       }

       static int getElementIndxInRotatedSortedArray(int nums[], int k) {
	   
	   int ans = 0;
	   int pivot = findPivot(nums);
	   ans = ascendingBinarySearch(nums, 0, pivot, k);
	   if(ans!=-1) {
	       return ans;
	   }
	   
	   ans = ascendingBinarySearch(nums, pivot, nums.length, k);
	   if(ans!=-1) {
	       return ans;
	   }
	   return ans;
       }
       static int ascendingBinarySearch(int[] nums, int start, int end, int k) {
	   int left = start;
	   int right = end;//4,5,6, 7, 1,2
	   while (left + 1 < right) {
	       int mid = (right + left) / 2;
	       if(nums[mid] ==k) {
		   return mid;
	       }
	       else if(nums[mid]> k) {
		   right = mid;
	       }else {
		   left = mid;
	       }
	   }
	   if(nums[left]==k) {
	       return left;
	   }else if(end <nums.length && nums[right]==k) {
	       return right;
	   }
	   return -1;
       }

	 /**Each element occurs twice except once find that**/
      static int findDistinctElment(int arr[]) {// new int[] {1,1,2, 2  3,3,8 };
	  int left = 0;					    //0,1,2, 3, 4,5,6
	  int right = arr.length;
	  
	  while(left+1 < right) {
	      int mid  = (left+right)/2;
	      if( (1+mid ==arr.length && arr[mid]!=arr[mid+1]) && (arr[mid]!=arr[mid-1])) {
		  return arr[mid];
	      }else if( (mid%2!=0 && arr[mid]==arr[mid-1]) || (mid%2==0 && arr[mid]==arr[mid+1])) {
		  left = mid;
	      }else {
		  right = mid;
	      }
	  }
	  return arr[left];
      }

      static int searchEleInDescendingOrderList(int arr[],int left, int right, int k) {
	  //9,8,4,2,1,0
	  while(left+1 < right) {
	      int mid= (left+right)/2;
	      
	      if(arr[mid]==k) 
		  return mid;
	      else if( arr[mid]>k) {
		  right = mid;
	      }else 
		  left =mid;
	  }
	  return -1;
      }
}
