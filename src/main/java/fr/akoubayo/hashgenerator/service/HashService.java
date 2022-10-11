package fr.akoubayo.hashgenerator.service;

public interface HashService {

    String hash(String date, String hashMethod, String secretKey);

}
