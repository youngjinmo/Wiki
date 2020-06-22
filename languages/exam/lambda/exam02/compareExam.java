package exam.lambda.exam02;

public class compareExam {
	
	public static void exec(Compare compare) {
		int a = 10;
		int b = 20;
		int value = compare.compareTo(a, b);
		System.out.println(value);
	}
	
	public static void main(String[] args) {
		exec((i,j)->{
			 return i-j;
		 });
	}
}
