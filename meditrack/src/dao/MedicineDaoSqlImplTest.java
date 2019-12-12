package dao;

import java.util.ArrayList;

public class MedicineDaoSqlImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedicineDao dao=new MedicineDaoSqlImpl();
		ArrayList<String> list=dao.getMedicine();
		System.out.println(list.get(9));
	}

	
}
