
public class MainClass {
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("key1", "value1");
		hashMap.put("key2", "value2");
		
		System.out.println("Value for key2 : " + hashMap.get("key2"));
	}
}
