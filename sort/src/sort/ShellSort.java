package sort;


public class ShellSort {

	public static int[] shell_sort(int array[]){
		int lenth = array.length;
		   int temp = 0;
		   int incre = lenth;

		   while(true){
		       incre = incre/2;
		       for(int k = 0;k<incre;k++){    //根据增量分为若干子序列
		           for(int i=k+incre;i<lenth;i+=incre){
		               for(int j=i;j>k;j-=incre){
		                   if(array[j]<array[j-incre]){
		                       temp = array[j-incre];
		                       array[j-incre] = array[j];
		                       array[j] = temp;
		                   }else{
		                       break;
		                   }
		               }
		           }
		       }

		       if(incre == 1){
		           break;
		       }
		   }
		   return array;
		}
	public static void main(String[] args) {
		int[] a= {5,6,1,3,8,9,2,5,1};
		int[] sort = shell_sort(a);
		for (int i : sort) {
			System.out.println(i);
			
		}
	}
}
