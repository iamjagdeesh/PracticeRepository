package com.practice.pkg;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalInterfaceExClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionalInterfaceEx functionalInterfaceEx = () -> {
			System.out.println("F1 called!");
		};
		functionalInterfaceEx.print();
		
		FunctionalInterfaceEx2 functionalInterfaceEx2 = (String name) -> {
			System.out.println(name + " called f2!");
		};
		functionalInterfaceEx2.printName("Jagdeesh");
		System.out.println(isPrime(3011));
		Integer[] ns = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
		List<Integer> numbers = Arrays.asList(ns);
		System.out.println(sumWithCondition(numbers, n -> n%2 == 0));
		
		Stream<Integer> stream = Stream.of(new Integer[]{1,2,3,4});
	}
	
	public static boolean isPrime(int number) {
		
		/* One way of writing
		return number > 1 
				&& IntStream.range(2, number).noneMatch(
								index -> number % index == 0);
		*/
		IntPredicate isDivisible = index -> number % index == 0;
		return number > 1
				&& IntStream.range(2, number).noneMatch(isDivisible);
	}
	
	public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
		return numbers
				.parallelStream()
				.filter(predicate)
				.mapToInt(num -> num)
				.sum();
	}

}
