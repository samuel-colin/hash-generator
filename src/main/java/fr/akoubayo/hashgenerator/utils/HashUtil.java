package fr.akoubayo.hashgenerator.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    public static final String HMAC_SHA_256 = "HmacSHA256";

    public static final String SHA_256 = "SHA-256";

    static final char[] hexChar = {
            '0' , '1' , '2' , '3' ,
            '4' , '5' , '6' , '7' ,
            '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f'
        };

    private HashUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String hashSHA256(String data, String secretKey) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(SHA_256);
        md.update((data + secretKey).getBytes(StandardCharsets.UTF_8));

        return encodeHexString(md.digest());
    }

    public static String hashHMACSHA256(String data, String secretKey) {
        try {
            Mac hashMethodElement = Mac.getInstance(HMAC_SHA_256);
            SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), HMAC_SHA_256);
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
