package dao;

import java.util.ArrayList;

import model.Medication;

public interface MedicationDao {
	public ArrayList<Medication> getMedicationList(int userId);
	public void addMedication(Medication medication);
	public Medication getMedication(int medicationId);
	public void editMedication(Medication medication);
	public void deleteMedication(int medicationId);
	
}
