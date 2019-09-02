package search;

public class Search {
	/*
	 * public static int query(int[] arr, int x){
	 * 
	 * int len = arr.length; int high = len - 1; int low = 0; while(low <=
	 * high){ int mid = (low + high)/2; if(arr[mid] == x){
	 * 
	 * return mid ;
	 * 
	 * }else if(arr[mid] > x){
	 * 
	 * high = mid - 1;
	 * 
	 * }else{
	 * 
	 * high = mid +1; } }
	 * 
	 * return -1; }
	 */
	public static int binarySearch(int[] a, int k) {
		int high = a.length - 1;
		int low = 0;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (a[mid] == k) {

				return mid;

			} else if (a[mid] > k) {

				high = mid - 1;

			} else {
				low = mid + 1;

			}

		}
		return -1;
	}

	public static int recursionBinarySearch(int[] arr,int key,int low,int high){  
	      
	    if(key < arr[low] || key > arr[high] || low > high){  
	        return -1;                
	    }  
	      
	    int middle = (low + high) / 2;          //初始中间位置  
	    if(arr[middle] > key){  
	        //比关键字大则关键字在左区域  
	        return recursionBinarySearch(arr, key, low, middle - 1);  
	    }else if(arr[middle] < key){  
	        //比关键字小则关键字在右区域  
	        return recursionBinarySearch(arr, key, middle + 1, high);  
	    }else {  
	        return middle;  
	    }     
	      
	}  
	
	public static int search(int[] a, int key){
		
		for(int i = 0;i<a.length;i++ )
		{
			if(key == a[i]){
				return i;
			}
			
		}
		
		return -1;
		
	}
	public static void main(String[] args) {

		int a[] = new int[] { 1, 3, 5, 9, 11, 22, 33, 66, 999 };
		//System.out.println(binarySearch(a, 333));
		System.out.println(search(a, 11));
	}
}
