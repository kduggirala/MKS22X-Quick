
public class Quick{
	public static void main(String[] args) {
		int[] data = {999,999,999,4,1,0,3,2,999,999,999};
		for (int i = 0; i < data.length; i++) {
			System.out.println(quickselect(data, i));
		}
		System.out.println();
		
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
	
	private static int[] partitionDutch(int[] data, int start, int end) {
		if (start == end) {
			int[] pair = {start, end};
			return pair;
		}
		int pivotIndex = ((int)(Math.random() * (end - start + 1))) + start;
		int pivot = data[pivotIndex];
		swap(data, start, pivotIndex);
		pivotIndex = start++;
		int i = start;
		while (i != end) {
			if (data[i] > pivot) {
				swap(data, i, end--);
			}
			else if (data[i] < pivot){
				swap(data, start, i);
				start++;
				i++;
			}
			else {
				i++;
			}
		}
		if (data[i] < pivot) {
			swap(data, pivotIndex, i);
		}
		else {
			swap(data, pivotIndex, --start);
			if (data[end] > pivot) {
				end--;
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
	
	
}