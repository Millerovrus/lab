package Sorters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurator {
    public int config;
    private static Logger LOGGER = LogManager.getLogger();

    /**
     * Считывает информацию из конфига
     */
    public Configurator() {
        try{
            Properties prop = new Properties();
            prop.load(new FileInputStream(new File("C:\\Users\\user\\IdeaProjects\\lab\\src\\main\\resources\\Config.properties")));
            config = Integer.valueOf(prop.getProperty("sort"));
        }
        catch (IOException e){
            System.out.println("Путь неверный");
            LOGGER.catching(e);
        }
    }
}
