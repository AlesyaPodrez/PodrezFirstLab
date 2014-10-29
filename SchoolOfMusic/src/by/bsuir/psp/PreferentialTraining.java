package by.bsuir.psp;

public class PreferentialTraining extends SchoolOfMusic{
	private String Allowance;
	
	public PreferentialTraining(){
		super();
		this.setAllowance(new String());
	}
	
	public PreferentialTraining(int number, String specialty, String surName, String allowance){
		super(number, specialty, surName);
		this.setAllowance(allowance);
	}

	public String getAllowance() {
		return Allowance;
	}

	public void setAllowance(String allowance) {
		Allowance = allowance;
	}
	
	public boolean Show(){
		System.out.println("\n�������: " + getSurName() + "\nC������������: " + GetSpecialty() 
				+ "\n���� ��������, ���: " + getTrainingPeriod()+ "\n������� ������: " + getAllowance());
		return true;
	}
	
	@Override
	public String toString() {
		return "\n�������: " + getSurName() + " " + "\n�������������: " + GetSpecialty() + " " 
			+ "\n���� ��������, ���: "	+ getTrainingPeriod() + " " + "\n������� ������: " + getAllowance();
	}
}
