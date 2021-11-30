import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class TestMaven {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try(InputStream resourceAsStream=TestMaven.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            prop.load(Objects.requireNonNull(resourceAsStream));
        }catch (IOException e) {
            System.err.println("Unable to load properties file: "+"config.properties");
        }

        System.out.println(prop.get("props.local.hello")+"\n"+prop.get("props.mvn.hello"));
    }
}