
public class Quick{
	public static void main(String[] args) {
		int[] data = {17, 61, 67, 47, 93,12, 20, 4, 44, 68, 1234, 13, 34, 57, 16, 85, 21};
		System.out.println(partition(data, 5, data.length - 3));
		for (int a : data) {
			System.out.print(a + " ");
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
