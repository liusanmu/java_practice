
public class Sort {

	//直接插入算法
	/**
	 public static void Sort(int[] arr){
	        for(int i=1;i<arr.length;i++){
	            int tempdata = arr[i];
	            int j;
	            for(j=i-1;j>=0;j--){
	                 if(arr[j]>tempdata){
	                     arr[j+1] = arr[j];
	                 }else{
	                     break;
	                 }
	            }
	            arr[j+1] = tempdata;
	        }
	        for (int value  : arr){
		        System.out.print(value+",");
		    }
	    }
	*/
	public static void insertSort(int a[]){
		int len = a.length;
		for(int i=1;i<len;i++){
			int temp = a[i];
			int j;
			for(j=i-1;j>=0;j--){
				if(a[j]>temp){
					a[j+1]=a[j];
                }else{
                    break;
                }
		
			}
			a[j+1] = temp;
		}
		 for (int value  : a){
		        System.out.print(value+",");
		    }
	}
	
	public static void main(String[] args) {
		int[] a1= {5,6,1,3,8,9,2,5,1};
		//Sort(a1);
		insertSort(a1);
	}
}
