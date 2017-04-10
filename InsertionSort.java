public class InsertionSort {
	int[] _array;
	int _SIZE;

	public void initialize() {
		_array = new int[] {5,2,4,6,1,3};
		_SIZE = _array.length;
	}

	public void print() {
		for (int idx = 0; idx < _SIZE; idx++)
			System.out.print(_array[idx] + " ");
	}

	public void sort() {
		for (int j = 1; j < _SIZE; j++) {
			int key = _array[j];
			int i = j - 1;
			while (i >= 0 && _array[i] > key) {
				_array[i+1] = _array[i];
				i = i - 1;
			}
			_array[i + 1] = key;
			System.out.print("Iteration " + j + ": ");
			print();
			System.out.println();
		}
	}

	public static void main (String[] args) {
		InsertionSort newObject = new InsertionSort();
		newObject.initialize();
		System.out.print("Before Sort : ");
		newObject.print();
		System.out.println();
		newObject.sort();
		System.out.print("After Sort : ");
		newObject.print();
	}
}