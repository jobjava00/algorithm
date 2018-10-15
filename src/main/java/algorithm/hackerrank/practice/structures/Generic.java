package algorithm.hackerrank.practice.structures;

import java.lang.reflect.Method;

/**
 *
 * https://www.hackerrank.com/challenges/java-generics/problem
 */
class Printer {
	//접근 제어자를 지정하지 않을 경우 동일 패키지에 속하는 클래스만 접근 가능
	<T> void printArray(T[] array) {
		for (T t : array) {
			System.out.println(t);
		}
	}
}

public class Generic {

	public static void main(String args[]) {
		Printer myPrinter = new Printer();
		Integer[] intArray = { 1, 2, 3 };
		String[] stringArray = { "Hello", "World" };
		myPrinter.printArray(intArray);
		myPrinter.printArray(stringArray);
		int count = 0;

		for (Method method : Printer.class.getDeclaredMethods()) {
			String name = method.getName();

			if (name.equals("printArray"))
				count++;
		}
		if (count > 1)
			System.out.println("Method overloading is not allowed!");
	}
}
