package dao;

import java.util.ArrayList;

import model.Medication;

public class MedicationDaoSqlImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedicationDao dao=new MedicationDaoSqlImpl();
		dao.deleteMedication(2);
	}

	
}
