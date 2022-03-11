import com.google.common.base.Preconditions;
import org.json.JSONObject;

public class JsonExample {
    public static JSONObject createJSON() {
        JSONObject person = new JSONObject();
        person.put("name", "Mick");
        person.put("age", 25);

        person.put("favorite_foods", new String[]{"Prosciutto", "Papardelle", "Brezel"});

        return person;
    }

    public static void main(String[] args) {
        var value = 90;
        Preconditions.checkArgument(value >= 0.0, "negative value: %s", value);
        System.out.println(createJSON().toString(4));

    }
}
