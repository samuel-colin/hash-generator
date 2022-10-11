package fr.akoubayo.hashGenerator.controller;

import fr.akoubayo.hashGenerator.dto.HashInputModel;
import fr.akoubayo.hashGenerator.service.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HashController {

    @Autowired
    HashService hashService;

    @PostMapping("hash")
    public String hash(final @RequestBody HashInputModel hashInputModel) {
        return hashService.hash(hashInputModel.getData(), hashInputModel.getHashMethod(), hashInputModel.getSecretKey());
    }
}
