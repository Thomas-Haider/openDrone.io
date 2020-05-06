package server;

import data.Fahrzeugdaten;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXB {
    private final String filePath;

    private Fahrzeugdaten fahrzeugdaten;

    JAXB(String filePath){
        this.filePath = filePath;
        unMarshall();
    }

    private void unMarshall() {
        try {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Fahrzeugdaten.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            fahrzeugdaten = (Fahrzeugdaten) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Fahrzeugdaten.Cars getCars(){
        return fahrzeugdaten.getCars();
    }

}
