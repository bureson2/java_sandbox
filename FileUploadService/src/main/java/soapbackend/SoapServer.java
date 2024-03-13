package soapbackend;

import jakarta.xml.ws.Endpoint;

public class SoapServer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/fileupload", new FileUploadService());
        System.out.println("Service is running...");
    }
}
