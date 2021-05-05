import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import dao.UserAccountClass;
import model.UserAccount;

public class test {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        InputStream input = this.getClass().getClassLoader().getResourceAsStream("settings.yml");
        Map<String, Object> obj = yaml.load(input);
        System.out.println(obj);
    }
}
