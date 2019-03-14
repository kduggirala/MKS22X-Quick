public class Quick{
	public static void main(String[]args){
		int[] testing = new int[100];
		for (int i = 0; i < 100; i++) {
			testing[i] = (int) (Math.random() * 100);
		}
		quicksort(testing);
		for(int i : testing) {
			System.out.print(i + " ");
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
			int[] partitionIndices = partitionDutch(data, start, end);
			quicksortHelp(data, start, partitionIndices[0] - 1);
			quicksortHelp(data, partitionIndices[1] + 1, end);
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
	
}