package by.bsuir.psp.name;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import by.bsuir.psp.PreferentialTraining;
import by.bsuir.psp.SchoolOfInterface;
import by.bsuir.psp.SchoolOfMusic;

public class Main extends MainMethod{
	Scanner in = new Scanner(System.in);

	public void Menu() throws FileNotFoundException, IOException,
			ClassNotFoundException {
		while (true) {
			System.out
					.println("1. Добавить ученика\n2. Удалить ученика\n3. Редактировать запись\n"
							+ "4. Сортировать\n5. Чтение из файла\n6. Выход");
			System.out.println("Сделайте свой выбор: ");
			int choise;
			choise = in.nextInt();
			switch (choise) {
			case 1: {
				Create();
				OutFileSchool();
				break;
			}
			case 2: {
				Delete();
				OutFileSchool();
				break;
			}
			case 3: {
				Redact();
				OutFileSchool();
				break;
			}
			case 4: {
				Sort();
				break;
			}
			case 5: {
				InFileSchool();
				break;
			}
			case 6: {
				return;
			}
			default:
				System.out.println("Нет такого пункта меню, повторите ввод.");
				break;

			}
		}
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		Main obj = new Main();
		obj.Menu();
	}

}
