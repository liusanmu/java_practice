package sort;

public class BubbleSort {

	/**
	 * √∞≈›≈≈–Ú
	 * @param args
	 */
	public static int[] bubbleSort(int[] a ){
		
		int len =  a.length;
		for(int i = 0;i < len-1;i++){
			for(int j = len-2;j>i-1;j--){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		return a;
	
		
	}
	
/*
 * for (int i = 0;i<a.length -1;i++){
 * 		for(int j=len-1;j>i;j--){
 * 			if(a[j]>a[j+1]){
 * Ωªªª
 * 			
 * 
 * 		}
 * 
 * }
 * 
 * }
 * 	
 */
	public static void main(String[] args) {
		int a[] = new int[] {3,1,33, 66, 999, 5, 9, 11, 22 };
		int[] sort = bubbleSort(a);
		for (int i : sort) {
			System.out.println(i);
		}
		

	}

}
