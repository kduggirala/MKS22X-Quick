import java.util.Arrays;
public class Quick{	
	public static void main(String[]args){
		  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
		  int[]MAX_LIST = {1000000000,500,10};
		  for(int MAX : MAX_LIST){
		    for(int size = 31250; size < 2000001; size*=2){
		      long qtime=0;
		      long btime=0;
		      //average of 5 sorts.
		      for(int trial = 0 ; trial <=5; trial++){
		        int []data1 = new int[size];
		        int []data2 = new int[size];
		        for(int i = 0; i < data1.length; i++){
		          data1[i] = (int)(Math.random()*MAX);
		          data2[i] = data1[i];
		        }
		        long t1,t2;
		        t1 = System.currentTimeMillis();
		        Quick.quicksort(data2);
		        t2 = System.currentTimeMillis();
		        qtime += t2 - t1;
		        t1 = System.currentTimeMillis();
		        Arrays.sort(data1);
		        t2 = System.currentTimeMillis();
		        btime+= t2 - t1;
		        if(!Arrays.equals(data1,data2)){
		          System.out.println("FAIL TO SORT!");
		          System.exit(0);
		        }
		      }
		      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
		    }
		    System.out.println();
		  }
		}
	
	public static int quickselect(int[] data, int k) {
		int start = 0;
		int end = data.length - 1;
		while (true) {
			int[] pivotIndices = partitionDutch(data, start, end);
			if (k >= pivotIndices[0] && k <= pivotIndices[1] ) {
				return data[k];
			}
			if (pivotIndices[1] < k) {
				start = pivotIndices[1] + 1;
			}
			else {
				end = pivotIndices[0] - 1;
			}
		}
	}
	
	public static void quicksort(int[] data) {
		quicksortHelp(data, 0, data.length - 1);
	}
	private static void quicksortHelp(int[] data, int start, int end) {
		if (start < end) {
			if (end - start < 4) {
				insertionsort(data, start, end);
			}
			else {
				int[] partitionIndices = partitionDutch(data, start, end);
				quicksortHelp(data, start, partitionIndices[0] - 1);
				quicksortHelp(data, partitionIndices[1] + 1, end);
			}
		}
	}
	
	private static int[] partitionDutch(int[] data, int start, int end) {
		if (start == end) {
			int[] pair = {start, end};
			return pair;
		}
		int pivotIndex = ((int)(Math.random() * (end - start + 1))) + start;
		int pivot = data[pivotIndex];
		swap(data, start, pivotIndex);
		int i = start + 1;
		while (i <= end) {
			if (data[i] > pivot) {
				swap(data, i, end--);
			}
			else if (data[i] < pivot){
				swap(data, start++, i++);
			}
			else {
				i++;
			}
		}
		int[] pair = {start, end};
		return pair;
	}
	private static void swap(int[] data, int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	private static void insertionsort(int[] data, int lo, int hi) {
		int temp, j;
		for(int i = lo + 1; i <= hi; i++) {
	        temp = data[i];
	        j = i - 1;
	        while (j >= lo && data[j] > temp) {
	            data[j + 1] = data[j--];
	        }
	        data[j + 1] = temp;
	    }
	}
}