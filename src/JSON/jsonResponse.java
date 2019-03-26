package JSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class jsonResponse {
	public static void main(String[] args) {
		hitEndpoint();
	}

	public static void hitEndpoint() {
		String endpoint = "https://api.meetup.com/2/groups?lat=51.509980&lon=-0.133700&page=20&key=1f5718c16a7fb3a5452f45193232";

		try {
			URL url = new URL(endpoint);

			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int response = connection.getResponseCode();
			System.out.print("Response code: " + response);

			if (response == 200) {
				InputStreamReader inputStreamReader = new InputStreamReader((connection.getInputStream()));
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				StringBuilder stringBuilder = new StringBuilder();

				String buffer;
				while ((buffer = bufferedReader.readLine()) != null) {

					stringBuilder.append(buffer);
				}

				String json = stringBuilder.toString();
				System.out.print("\nJSON:\n" + json);
			}

		} catch (Exception e) {

			System.out.print(e.toString());
		}
	}
}