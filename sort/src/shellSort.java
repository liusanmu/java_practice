
public class shellSort {

	public  static void shellInsert(int a[]){
		int len = a.length; //���������鳤���ó�������߳���
		while(len!=0){	
			len=len/2;
			for(int i=0;i<len;i++){ 
				  for(int j=i+len;j<a.length;j+=len){
					  int k = j-len;//kΪ�����������һλ��λ��
					  int temp = a[j];//Ҫ�����Ԫ�� 
					  while(k>=0 && temp<a[k]){//�Ӻ���ǰ����
						  a[k+len]=a[k];
						  k-=len;//����ƶ�lenλ
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
