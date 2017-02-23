package cs2321.sorting;

public class MergeSort<E extends Comparable<E>> implements Sorter<E> {

	public void sort(E[] array) {

		MergeSort(array, 0, array.length - 1);
	}

	private void MergeSort(E[] arr, int low, int high) {
		if (low >= high) {
			return;
		}

		if (low < high) {
			int mid = (high + low) / 2;
			MergeSort(arr, low, mid);
			MergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private void merge(E[] arr, int low, int mid, int high) {

		int n = high - low + 1;
		Object[] values = new Object[n];
		int bot = low;
		int middle = mid + 1;
		int index = 0;

		while (bot <= mid && middle <= high) {
			if (arr[bot].compareTo(arr[middle]) < 0) {
				values[index] = arr[bot];
				bot++;
			} else {
				values[index] = arr[middle];
				middle++;
			}
			index++;
		}
		while (bot <= mid) {
			values[index] = arr[bot];
			bot++;
			index++;
		}
		while (middle <= high) {
			values[index] = arr[middle];
			middle++;
			index++;
		}
		for (index = 0; index < n; index++)
			arr[low + index] = (E) values[index];
	}

}
