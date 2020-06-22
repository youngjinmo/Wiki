package exam.lambda.exam03;

import java.util.ArrayList;
import java.util.List;

public class CarExamWithLambda {
	public static void main(String[] args) {
		
		List<Car> cars = new ArrayList<>();
		
		cars.add(new Car("bmw 520d",30,7500,5));
		cars.add(new Car("model3", 0, 6700, 1));
		cars.add(new Car("sonata", 15, 2800, 3));
		
		printCar(cars, 
				(Car car) -> {return car.capacity>3 && car.price<5000;}
		);
	}
	
	public static void printCar(
			List<Car> cars, checkCar check) {
		for(Car car:cars) {
			if(check.test(car)) {
				System.out.println(car);
			}
		}
	}
	
	interface checkCar{
		boolean test(Car car);
	}
}
