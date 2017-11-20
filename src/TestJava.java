import java.util.ArrayList;
import java.util.List;

public class TestJava {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<String>();
        List<? extends String> objectList = stringList;
    }
}
