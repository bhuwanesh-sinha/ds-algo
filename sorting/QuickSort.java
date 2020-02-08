package sorting;

public class QuickSort {

	private static void quickSort(int[] arr, int l, int r) {

		if (l >= r)
			return;

		int pos = partition(arr, l, r);
		quickSort(arr, l, pos - 1);

		quickSort(arr, pos + 1, r);

	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 1, 0, 8, 9, 2, 5, 6, 7 };

		printArray(arr);
		quickSort(arr, 0, arr.length - 1);
		printArray(arr);

	}

	private static int partition(int[] arr, int l, int r) {
		int pos = -1;
		int i = l - 1; // not in picture initially...
		int pivot = r;

		for (int j = l; j <= r; j++) {

			if (arr[j] < arr[pivot]) {
				i++; // comes in pucture and stores smaller element in nest
						// position..
				if (i != j)
					swap(arr, i, j);
			}

		}

		pos = i + 1;
		if (pos != pivot)
			swap(arr, pos, pivot);

		return pos;
	}

	private static void swap(int[] arr, int first, int last) {

		int temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;

	}

	private static void printArray(int[] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();

	}

}
