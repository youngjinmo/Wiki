package exam.lambda.exam01;

public class lambdaExam_02 {
	public static void main(String[] args) {
		// with Lambda
		new Thread(()->{
			System.out.println("Hello Lambda!");
		}).start();
	}
}
