package by.bsuir.psp.name;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import by.bsuir.psp.PreferentialTraining;
import by.bsuir.psp.SchoolOfMusic;

public class MainMethod {
	List<SchoolOfMusic> Student = new ArrayList<SchoolOfMusic>();
	private Iterator<SchoolOfMusic> index;
	Scanner in = new Scanner(System.in);
	
	public void Sort() {
		// InFileSchool();
		Comparator<SchoolOfMusic> comp = new Comparator<SchoolOfMusic>() {
			public int compare(SchoolOfMusic obj1, SchoolOfMusic obj2) {
				return obj1.getSurName().compareTo(obj2.getSurName());
			}
		};
		Collections.sort(Student, comp);
	}

	

	public void Redact() {
		int number;
		index = Student.iterator();
		while (index.hasNext()) {
			SchoolOfMusic stud = index.next();
			System.out.println(stud.Show());
		}
		System.out
				.println("Введите номер записи, которую Вы хотите изменить: ");
		number = in.nextInt();
		System.out.println("Введите фамилию ученика: ");
		String surName = in.next();
		System.out.println("Введите специальность: ");
		String specialty = new String();
		specialty = in.next();
		System.out.println("Введите срок обучения: ");
		int period;
		period = in.nextInt();
		while (period > 6 || period < 1) {
			System.out.println("Введен неверный срок. Повторите ввод.");
			period = in.nextInt();
		}
		System.out.println("Введите наличие льготы, no/yes: ");
		String allowance = new String();
		allowance = in.next();
		SchoolOfMusic newStudent = new PreferentialTraining(period, specialty,
				surName, allowance);
		Student.set(number - 1, newStudent);
	}

	public void Create() {
		System.out.println("Введите фамилию ученика: ");
		String surName = new String();
		surName = in.next();
		System.out.println("Введите специальность: ");
		String specialty = new String();
		specialty = in.next();
		System.out.println("Введите срок обучения: ");
		int period;
		period = in.nextInt();
		while (period > 6 || period < 1) {
			System.out.println("Введен неверный срок. Повторите ввод.");
			period = in.nextInt();
		}
		System.out.println("Введите наличие льготы, no/yes: ");
		String allowance = new String();
		allowance = in.next();
		SchoolOfMusic newStudent = new PreferentialTraining(period, specialty,
				surName, allowance);
		Student.add(newStudent);

	}

	public void Delete() {
		String name;
		index = Student.iterator();
		while (index.hasNext()) {
			SchoolOfMusic stud = index.next();
			System.out.println(stud.Show());
		}
		System.out
				.println("Введите фамилию ученика, которого Вы хотите удалить: ");
		name = in.next();
		index = Student.iterator();
		while (index.hasNext()) {
			SchoolOfMusic stud1 = index.next();
			if (stud1.getSurName().equals(name)) {
				Student.remove(stud1);
				System.out.println("Запись удалена.");
			}
		}
	}

	public void OutFileSchool() throws ClassNotFoundException {
		
		ObjectOutputStream ostream = null;
		try {
			File fw = new File("fileSchool.txt");
			ostream = new ObjectOutputStream(
					new FileOutputStream(fw));
			ostream.writeObject(Student);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ostream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void InFileSchool() throws ClassNotFoundException{
			
			ObjectInputStream istream = null;
			try {
				File fw = new File("fileSchool.txt");
				istream = new ObjectInputStream(new FileInputStream(
						fw));
				Student = (List<SchoolOfMusic>) istream.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					istream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Student);
		}

}
