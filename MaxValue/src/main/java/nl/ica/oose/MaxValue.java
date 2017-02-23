package nl.ica.oose;

public class MaxValue extends Thread{
	private int low, high;
	private int[] array;
	private int answer;

	public MaxValue(int[]array, int low, int high) {
		this.low = low;
		this.high = high;
		this.array = array;
	}

	public void run() {
		for (int i = low; i < high; i++) {
			if (array[i] > answer) {
				answer = array[i];
			}
		}
	}

	public static void main( String[] args ) throws InterruptedException{
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
			System.out.println(arr[i]);
		}

		int maxValue = maxValue(arr);
		System.out.println("maxValue: " + maxValue);
	}

	private static int maxValue(int[] arr) throws InterruptedException {
		int answer = 0;
		int len = arr.length;

		MaxValue[] maxValueThreads = new MaxValue[4];
		for (int i = 0; i < 4; i++) {
			maxValueThreads[i] = new MaxValue(arr, (i * len) / 4, ((i + 1) * len / 4));
			maxValueThreads[i].start();
		}

		sleep(10);

		for (int i = 0; i < 4; i++) {
			if (maxValueThreads[i].answer > answer) {
				answer = maxValueThreads[i].answer;
			}
		}
		return answer;
	}
}
