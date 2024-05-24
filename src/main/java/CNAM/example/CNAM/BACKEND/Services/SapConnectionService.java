package CNAM.example.CNAM.BACKEND.Services;

import java.util.List;

import CNAM.example.CNAM.BACKEND.Models.usr02;

public interface SapConnectionService {
    boolean createSapConnection() throws Exception;
    List<usr02> getUsers() throws Exception;
}
