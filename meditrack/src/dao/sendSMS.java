package dao;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class sendSMS {
	public String sendSms(String time, String mobile, String text) {
		try {
			// Construct data
			String apiKey = "apikey=" + "s5SQTdtbT38-OfBymvnIS2ZdVG1wzHq2FQsPK3gfgL";
			String message = "&message=" + "This is a reminder"+text;
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "91"+mobile;
			String schedule_time="&schedule_time="+time;
			String test="&test="+"true";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender+ schedule_time + test;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
		
	}
	public static void main(String args[]) {
		sendSMS sms=new sendSMS();
		String message=sms.sendSms("2019-12-04 15:00:00", "9908445003","Hi");
		System.out.println(message);
	}
}
