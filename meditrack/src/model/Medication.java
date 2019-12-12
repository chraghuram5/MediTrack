package model;

public class Medication {
	private int medicationId;
	private String medicine;
	private int morning;
	private int afternoon;
	private int evening;
	private int night;
	private int userId;

	public Medication(int medicationId, String medicine, int morning, int afternoon, int evening, int night,
			int userId) {
		super();
		this.medicationId = medicationId;
		this.medicine = medicine;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.night = night;
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Medication(String medicine, int morning, int afternoon, int evening, int night, int userId) {
		super();
		this.medicine = medicine;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.night = night;
		this.userId = userId;
	}

	public int getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(int medicationId) {
		this.medicationId = medicationId;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public int getMorning() {
		return morning;
	}

	public void setMorning(int morning) {
		this.morning = morning;
	}

	public int getAfternoon() {
		return afternoon;
	}

	public void setAfternoon(int afternoon) {
		this.afternoon = afternoon;
	}

	public int getEvening() {
		return evening;
	}

	public void setEvening(int evening) {
		this.evening = evening;
	}

	public int getNight() {
		return night;
	}

	public void setNight(int night) {
		this.night = night;
	}

}
