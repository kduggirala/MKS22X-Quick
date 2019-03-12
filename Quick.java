
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
			int pivotIndex = partition(data, start, end);
			if (pivotIndex == k) {
				return data[k];
			}
			if (pivotIndex < k) {
				start = pivotIndex + 1;
			}
			else {
				end = pivotIndex - 1;
			}
		}
	}
	
	public static int partition(int[] data, int start, int end) {
		if (start == end) {
			return start;
		}
		int pivotIndex = ((int)(Math.random() * (end - start + 1))) + start;
		int pivot = data[pivotIndex];
		swap(data, start, pivotIndex);
		pivotIndex = start++;
		while (start != end) {
			if (data[start] > pivot) {
				swap(data, start, end--);
			}
			else {
				start++;
			}
		}
		if (data[start] < pivot) {
			swap(data, pivotIndex, start);
			pivotIndex = start;
		}
		else if (data[start] > pivot){
			swap(data, pivotIndex, start - 1);
			pivotIndex = start - 1;
		}
		return pivotIndex;
	}
	private static void swap(int[] data, int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
}