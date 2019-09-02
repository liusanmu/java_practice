
public class bubbleSort {
	/**
	public static void bubbleSort(int[] a){
		boolean isExchanged = true;
		int len = a.length;
		for(int i = 0;i < len-1;i++){
			for(int j=0;j<len-i-1;j++){
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1]=temp;			
					isExchanged = true;
				}
				if (!isExchanged) break;

			}
		}	
		 for (int value  : a){
		        System.out.print(value+",");
		    }
	}
	
	*/
	public static void bubbleSort2(int[] arr){
		int len = arr.length;
		for(int i=0;i<len;i++){
			for(int j=len-1;j>i;j--){
				if(arr[j]<arr[j-1]){
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					
				}
			}
			
		}
		for (int value  : arr){
	        System.out.print(value+",");
	    }
		
	}
	
	public static void main(String[] args) {
		int[] a1= {5,6,1,3,8,9,2,5,1};
		//bubbleSort(a1);
		bubbleSort2(a1);
	}
}
