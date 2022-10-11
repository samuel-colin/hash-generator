package fr.akoubayo.hashGenerator.service;

import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class HashServiceImpl implements HashService {

    static final char[] hexChar = {
            '0' , '1' , '2' , '3' ,
            '4' , '5' , '6' , '7' ,
            '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f'};

    @Override
    public String hash(String data, String hashMethod, String secretKey) {
        try {
            Mac hashMethodElement = Mac.getInstance(hashMethod);
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), hashMethod);
            hashMethodElement.init(keySpec);

            return encodeHexString(hashMethodElement.doFinal(data.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private static String encodeHexString ( byte[] b ) {
        StringBuffer sb = new StringBuffer( b.length * 2 );

        for (int i=0; i<b.length; i++ ) {
            // look up high nibble char
            sb.append( hexChar [( b[i] & 0xf0 ) >>> 4] );

            // look up low nibble char
            sb.append( hexChar [b[i] & 0x0f] );
        }

        return sb.toString();
    }
}
