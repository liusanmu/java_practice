package sort;

public class InserttSort {

public static int[] insertSort(int[] a){
	int len = a.length;
	int i,j,temp;
	for(i=1;i<len;i++){
		temp = a[i];
		for(j=i-1;j>=0;j--){
			if(a[j]>temp){
			a[j+1]	= a[j];
			}else{
				break;
			}
		}
		a[j+1] = temp;
		
	}

	return a;
	
}
	
	public static void main(String[] args) {
		
		int a[] = new int[] {3,1,33, 66, 999, 5, 9, 11, 22 };
		int[] sort =insertSort(a);
		for (int i : sort) {
			System.out.println(i);
		}
		
		
	}
}
