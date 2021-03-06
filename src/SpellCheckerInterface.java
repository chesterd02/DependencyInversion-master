import java.io.IOException;
import java.net.URL;
import java.util.SortedMap;

public interface SpellCheckerInterface {

    SortedMap<String, Integer> check(URL url) throws IOException;
    void makeDict(String dict);


}
