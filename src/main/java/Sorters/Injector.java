package Sorters;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Created by HOME on 21.03.2018.
 */
public class Injector {

    private Properties properties;

    public Injector() {
        this.properties = new Properties();

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("C:\\Users\\user\\IdeaProjects\\lab\\src\\main\\resources\\Config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Object inject(Object object) {
        for (Field field : object.getClass().getDeclaredFields()){
            field.setAccessible(true);

            if (field.isAnnotationPresent(AutoInjectable.class)){
                try {
                    field.set(object, Class.forName(properties.getProperty(field.getType().getName())).getDeclaredConstructor().newInstance());
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return object;
    }
}
