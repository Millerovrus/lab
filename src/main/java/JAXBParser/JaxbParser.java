package JAXBParser;

import Repositories.RepositoryAbstract;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser {
    public static RepositoryAbstract convertXmlToObject (String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(RepositoryAbstract.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (RepositoryAbstract) unmarshaller.unmarshal(new File(filePath));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void convertObjectToXml(RepositoryAbstract rep, String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(rep.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(rep, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
