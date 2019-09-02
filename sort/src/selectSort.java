


public class selectSort {

	
	/*public static void selectSort(int[] a){
		
		for (int i=0;i<a.length;i++){
			int min = i;
			for(int j=i+1;j<a.length;j++){
		
				if(a[j]<a[min]){
					int temp = a[j];
					a[j] = a[min];
					a[min]= temp;
				}
			}
		}
		for (int i : a) {
			System.out.print(i+",");
		}
		
	}*/
public static void selectSort(int[] a){
	int min;
		for (int i=0;i<a.length;i++){
			min = i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[min]){
					min = j;
				}
				if(min != i){
					int temp = a[min];
					a[min] = a[i];
					a[i]= temp;
				}
			}
		}
		for (int i : a) {
			System.out.print(i+",");
		}
		
	}

/*
 * for(int i=0;i<len;i++){
 *    min = i;
 *    for(int j=i+1;j<len;j++){
 *    	if(a[j]<a[min]){
 *      min = j;
 *    }
 *    if(min != i){
 *    jiaohuan
 *    
 *    }
 *    
 *    
 *    }
 * 
 * }
 */

	public static void main(String[] args) {
		int[] a1= {5,6,1,3,8,9,2,98,5,4};
		selectSort(a1);
	}
}
