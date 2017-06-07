package pl.karol.littleshelter.tool;

public class ValidationUtil {

	private static String[] insecureCharactersNoSQL = { "'", "\"", "\\", ";", "{", "}", "$", };

	public static String cleanDataForNoSQL(String data) {
		for (String item : insecureCharactersNoSQL) {
			data = data.replace(item, "");
		}
		return data;
	}

}
