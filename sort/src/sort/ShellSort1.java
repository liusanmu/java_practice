package sort;

public class ShellSort1 {

	public static int[] sheelSort(int [] a){
        int len=a.length;//���������鳤���ó��������Ч��
        while(len!=0){
            len=len/2;
            for(int i=0;i<len;i++){//����
                for(int j=i+len;j<a.length;j+=len){//Ԫ�شӵڶ�����ʼ
                    int k=j-len;//kΪ�����������һλ��λ��
                    int temp=a[j];//Ҫ�����Ԫ��
                    
                    while(k>=0&&temp<a[k]){//�Ӻ���ǰ����
                        a[k+len]=a[k];
                        k-=len;//����ƶ�lenλ
                    }
                    a[k+len]=temp;
                }
            }
        }
        return a;
    }
	
	public static void main(String[] args) {
		int[] a= {5,6,1,3,8,9,2,5,1};
		int[] sort = sheelSort(a);
		for (int i : sort) {
			System.out.println(i);
		}
	}
}
