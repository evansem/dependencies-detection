import org.json.JSONObject;

public class JsonExample {
    private static void createJSON(boolean prettyPrint) {
        JSONObject tomJsonObj = new JSONObject();
        tomJsonObj.put("name", "Mick");
        tomJsonObj.put("age", 25);

        tomJsonObj.put("favorite_foods", new String[]{"Prosciutto", "Papardelle", "Brezel"});

        System.out.println(tomJsonObj.toString(4));
    }

    public static void main(String[] args) {
        createJSON(true);
    }
}
