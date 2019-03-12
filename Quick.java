
public class Quick{
	public static void main(String[] args) {
		int[] data = {17, 61, 67, 47, 93,12, 20, 4, 44, 68, 1234, 13, 13, 34, 57, 16, 85, 21, 134, 136, 137326};
		for (int i = 0; i < data.length; i++) {
			System.out.println(quickselect(data, i));
		}
	}
	
	public static int quickselect(int[] data, int k) {
		int start = 0;
		int end = data.length - 1;
		while (true) {
			int[] pivotIndices = partition(data, start, end);
			if (k >= pivotIndices[0] && k <= pivotIndices[1] ) {
				return data[k];
			}
			if (pivotIndices[0] < k) {
				start = pivotIndices[0] + 1;
			}
			else {
				end = pivotIndices[1] - 1;
			}
		}
	}
	
	public static int[] partition(int[] data, int start, int end) {
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
				swap(data, start, end--);
			}
			else if (data[start] < pivot){
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