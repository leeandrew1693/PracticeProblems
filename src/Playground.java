import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by andrew on 2/3/17.
 */
public class Playground {
    public static void main (final String args[]) {
        Map<String, String> nameMapping = new HashMap<>();
        nameMapping.put("Tiffany", "Chiu");
        nameMapping.put("Andrew", "Lee");

        List<String> andrews = new ArrayList<>();
        for(Map.Entry<String, String> temp : nameMapping.entrySet()) {
            if(temp.getKey().equals("Andrew")) {
                andrews.add(temp.getKey());
            }
        }

    }
}
