package fr.akoubayo.hashgenerator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashInputModel {
    private String data;
    private String hashMethod;
    private String secretKey;
}
