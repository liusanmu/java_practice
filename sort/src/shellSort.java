
public class shellSort {

	public  static void shellInsert(int a[]){
		int len = a.length; //单独把数组长度拿出来，提高长度
		while(len!=0){	
			len=len/2;
			for(int i=0;i<len;i++){ 
				  for(int j=i+len;j<a.length;j+=len){
					  int k = j-len;//k为有序序列最后一位的位数
					  int temp = a[j];//要插入的元素 
					  while(k>=0 && temp<a[k]){//从后往前遍历
						  a[k+len]=a[k];
						  k-=len;//向后移动len位
					  } 
					  a[k+len]=temp;
				  }
				
			}			
		}
	for (int value : a) {
		System.out.print(value+",");
	}
	    			
}
	
	
	public static void main(String[] args) {
		int[] a1= {5,6,1,3,8,9,2,5,1};
		shellInsert(a1);
	}
	
	
	
}
