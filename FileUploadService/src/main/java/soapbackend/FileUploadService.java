package soapbackend;

import jakarta.activation.DataHandler;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.ws.soap.MTOM;

import java.io.*;

@WebService(endpointInterface = "soapbackend.IFileUploadService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@MTOM
public class FileUploadService implements IFileUploadService {
    @Override
    public String uploadFile(DataHandler dataHandler) {
        try {
            System.out.println("Zahájení přenosu");

            // Příprava vstupního streamu z DataHandler
            InputStream inputStream = dataHandler.getInputStream();

            // Specifikace cesty a názvu souboru pro uložení
            String filePath = "src/main/resources/output/soubor2.txt";
            File file = new File(filePath);

            // Zajištění, že cesta k souboru existuje
            file.getParentFile().mkdirs();

            // Vytvoření výstupního streamu pro zápis souboru
            OutputStream outputStream = new FileOutputStream(file);

            // Čtení dat a zápis do souboru
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Uzavření streamů
            outputStream.close();
            inputStream.close();

            return "Soubor byl úspěšně přijat a uložen.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Došlo k chybě při zpracování souboru: " + e.getMessage();
        }
    }
}
