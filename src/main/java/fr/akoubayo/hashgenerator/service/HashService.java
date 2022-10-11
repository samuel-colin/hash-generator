package fr.akoubayo.hashGenerator.service;

import org.springframework.stereotype.Service;

public interface HashService {

    String hash(String date, String hashMethod, String secretKey);

}
