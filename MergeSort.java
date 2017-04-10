public class MergeSort {
	int[] _array;
	int _size;

	public void initialize() {
		_array = new int[] {2,4,5,7,1,2,3,6};
		_size = _array.length;
	}

	public void print() {
		for (int idx = 0; idx < _size; idx++)
			System.out.print(_array[idx] + " ");
	}

	public static void prt(int p, int q, int r) {
		System.out.println("p = " + p + ", q = " + q + ", r = " + r);
	}

	public static void sort(int[] A, int p, int r, Boolean details) {
		if (p < r) {
			int q = (p + r)/2;

			if (details){
				System.out.println();
				prt(p,q,r);
			}

			sort(A, p, q, details);
			sort(A, q + 1, r, details);
			merge(A, p, q, r, details);
		}
	}

	public static void merge(int[] A, int p, int q, int r, Boolean details) {
		int n1 = q - p + 1;
		int n2 = r - q;

		int[] L = new int[n1+1];
		int[] R = new int[n2+1];

		for (int i = 0; i < n1; i++)
			L[i] = A[p + i];
		for (int j = 0; j < n2; j++)
			R[j] = A[q + 1 + j];

		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		if (details) {
			System.out.println();
			System.out.print("L : ");
			for (int x = 0; x < n1; x++)
				System.out.print(L[x] + " ");
			System.out.println();
			System.out.print("R : ");
			for (int y = 0; y < n2; y++)
				System.out.print(R[y] + " ");
		}

		int i = 0;
		int j = 0;

		for (int k = p; k <= r; k++){
			if (L[i] < R[j])
				A[k] = L[i++];
			else
				A[k] = R[j++];
		}
	}

	public static void main(String[] args) {
		MergeSort arr = new MergeSort();
		Boolean details = false;
		arr.initialize();
		System.out.print("Before sort : ");
		arr.print();
		System.out.println();
		sort(arr._array, 0, arr._size - 1, details);
		System.out.print("\nAfter sort : ");
		arr.print();
	}
}


/*-----------------Algorithm in easily readable code-----------------------------



void MergeSort(int[] array, int begin, int end){
	if (begin < end) {
		int middle = (begin + end) / 2;
		MergeSort(array, begin, middle);
		MergeSort(array, middle+1, end);
		Merge(array, begin, middle, end);
	}
}

void Merge(int[] array, int begin, int middle, int end) {
	int sizeL = middle - begin + 1;
	int sizeR = end - middle;

	int[] subArrayLeft = new int[sizeL + 1];
	int[] subArrayRight = new int[sizeR + 1];

	for (int i = 0; i < sizeL; i++)
		subArrayLeft[i] = array[begin + i];
	for (int j = 0; j < sizeR; j++)
		subArrayRight[j] = array[middle + 1 + j];

	subArrayLeft[sizeL] = Integer.MAX_VALUE;
	subArrayRight[sizeR] = Integer.MAX_VALUE;

	int counterL = 0;
	int counterR = 0;

	for (int counter = 0; counter <= end; counter++){
		if (L[counterL] < R[counterR])
			array[counter] = subArrayLeft[counterL++];
		else
			array[counter] = subArrayRight[counterR++];
	}
}


-----------------------------------------------------------------------------------*/