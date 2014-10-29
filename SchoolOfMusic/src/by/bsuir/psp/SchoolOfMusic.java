package by.bsuir.psp;

import java.io.Serializable;

abstract public class SchoolOfMusic implements SchoolOfInterface, Serializable {
	private int TrainingPeriod;
	private String Specialty;
	private String SurName;
	
	public SchoolOfMusic(){
		this.setTrainingPeriod(0);
		this.Specialty = new String();
		this.setSurName(new String());
	}
	
	public SchoolOfMusic(int number, String spec, String surname){
		this.setTrainingPeriod(number);
		this.Specialty = spec;
		this.setSurName(surname);
	}
	
	public void SetSpecialty(String Specialty){
		this.Specialty = Specialty;
	}
	
	public String GetSpecialty(){
		return this.Specialty;
	}
	
	public String getSurName() {
		return SurName;
	}

	public void setSurName(String surName) {
		SurName = surName;
	}
	
	public int getTrainingPeriod() {
		return TrainingPeriod;
	}

	public void setTrainingPeriod(int trainingPeriod) {
		TrainingPeriod = trainingPeriod;
	}
	
	
	@Override
	public void PayTraining() {
		// TODO Auto-generated method stub
		System.out.println("�� �������� ��������.");
	}

	@Override
	public void Benefits() {
		// TODO Auto-generated method stub
		System.out.println("������� ������.");
	}

	@Override
	public boolean Show() {
		// TODO Auto-generated method stub
		System.out.println("\n�������: " + getSurName() + "\nC������������: " + GetSpecialty() 
				+ "\n���� ��������, ���: " + getTrainingPeriod());
		return true;
	}

	@Override
	public String toString() {
		return "\n�������: " + getSurName() + " " + "\n�������������: " + GetSpecialty() + " " 
			+ "\n���� ��������, ���: "	+ getTrainingPeriod();
	}

}
