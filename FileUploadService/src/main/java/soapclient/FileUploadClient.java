package soapclient;

import javax.xml.namespace.QName;

import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.xml.ws.Service;
import soapbackend.IFileUploadService;

import java.net.URL;

public class FileUploadClient {

    private static IFileUploadService fileUploadService;

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/fileupload?wsdl");
        QName qname = new QName("http://soapbackend/", "FileUploadServiceService");
        Service service = Service.create(url, qname);
        fileUploadService = service.getPort(IFileUploadService.class);

        // Příklad odeslání souboru
        uploadFile("src/main/resources/input/test.txt");
    }

    public static void uploadFile(String filePath) {
        FileDataSource dataSource = new FileDataSource(filePath);
        DataHandler dataHandler = new DataHandler(dataSource);

        fileUploadService.uploadFile(dataHandler);
    }
}
