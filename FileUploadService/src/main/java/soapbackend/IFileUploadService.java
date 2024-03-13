package soapbackend;

import jakarta.activation.DataHandler;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface IFileUploadService {
    @WebMethod
    String uploadFile(DataHandler dataHandler);
}

