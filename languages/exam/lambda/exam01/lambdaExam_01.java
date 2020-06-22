package exam.lambda.exam01;

public class lambdaExam_01 {
	public static void main(String[] args) {
		// without Lambda
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello");
			}
		}).start();
	}
}
