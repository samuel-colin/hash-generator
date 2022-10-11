package fr.akoubayo.hashgenerator.service;

import fr.akoubayo.hashgenerator.utils.HashUtil;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class HashServiceImpl implements HashService {

    @Override
    public String hash(String data, String hashMethod, String secretKey) {
        String result;

        try {
            if (HashUtil.SHA_256.equals(hashMethod)) {
                result = HashUtil.hashSHA256(data, secretKey);
            } else {
                result = HashUtil.hashHMACSHA256(data, secretKey);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            result = "";
        }

        return result;
    }
}
