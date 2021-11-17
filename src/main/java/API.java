import java.net.*;
import java.io.*;

public class API {
	public static void main(String[] args) {
		/* try {
			URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + lat1 + "%2C" + long1 + "&destinations=" + lat2 + "%2C" + long2 + "&key=AIzaSyDpQAp0FfH4cDRtiXNlwutqJsLuuCAuQa4");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			InputStream inputStream = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
			StringBuilder sb = new StringBuilder();
			String output;
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}
			System.out.println(sb.toString());
		}
		catch (Exception ex) {
			System.out.println("Couldn't get API");
		} */
		//getMinDuration(47.606209, -122.332069, 47.676891, -122.205986);
	}

	public static int getMinDuration(double lat1, double long1, double lat2, double long2) {
		URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + lat1 + "%2C" + long1 + "&destinations=" + lat2 + "%2C" + long2 + "&key=AIzaSyDpQAp0FfH4cDRtiXNlwutqJsLuuCAuQa4");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		InputStream inputStream = con.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
		StringBuilder sb = new StringBuilder();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		String[] arr = sb.toString().split("mins\",                  \"value\" : ");
		String s = new String("arr[1]");
		Matcher matcher = Pattern.compile("\\d+").matcher(s);
		matcher.find();
		int i = Integer.valueOf(matcher.group());
		System.out.println(i);
	}
}