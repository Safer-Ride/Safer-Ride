import java.net.*;
import java.io.*;
import java.util.*;

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
        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + lat1 + "%2C" + long1 + "&destinations=" + lat2 + "%2C" + long2 + "&key=AIzaSyDpQAp0FfH4cDRtiXNlwutqJsLuuCAuQa4");
            System.out.println(url.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // handle error response code it occurs
            int responseCode = con.getResponseCode();
            InputStream inputStream;
		    /*if (200 <= responseCode && responseCode <= 299) {
		        inputStream = con.getInputStream();
		    } else {
		        inputStream = con.getErrorStream();
		    }*/
            inputStream = con.getErrorStream();
            //InputStream inputStream = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            //System.out.println(sb.toString());
            String s = sb.toString();
            String[] arr = s.split("\"value\" : ");
            int duration = new Scanner(arr[2]).useDelimiter("\\D+").nextInt();
            //System.out.println("\n" + duration);
            return duration;
        }
        catch (Exception ex) {
            System.out.println("Couldn't access API correctly");
        }
        return -1;
    }

    public static String coordsToAddress(DummyGPSLocationVar loc) {
        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?latlng=" + loc.getLat() + "%2C" + loc.getLong() + "&key=AIzaSyDpQAp0FfH4cDRtiXNlwutqJsLuuCAuQa4");
            System.out.println(url.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            // handle error response code it occurs
            int responseCode = con.getResponseCode();
            InputStream inputStream = con.getErrorStream();
            //InputStream inputStream = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            //System.out.println(sb.toString());
            String s = sb.toString();
            String[] arr = s.split("\"formatted_address\" : \"");
            String location = arr[1].split("\"")[0];
            return location;
        }
        catch (Exception ex) {
            System.out.println("Couldn't access API correctly");
        }
        return "";
    }
}