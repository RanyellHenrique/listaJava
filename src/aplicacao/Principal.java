package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;


public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registered?");
		Integer n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println();
			System.out.println("Employee #"+i);
			System.out.print("id: ");
			Integer id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if(emp == null) {
			System.out.println("This id does not exist!");
		}else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.encrementSalary(percentage);
		}
		
		System.out.println();
		System.out.println("List of employees:");
		for (Employee obj : list) {
			System.out.println(obj);

		}
		
		sc.close();
	}

}
