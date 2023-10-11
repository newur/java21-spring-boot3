package com.example.demo.restservice;

import com.example.demo.dto.AbstractPackage;
import com.example.demo.dto.HeavyPackage;
import com.example.demo.dto.LightPackage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PackageController {

    @PostMapping(value = "/package", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String newPackage(@RequestBody AbstractPackage abstractPackage) {
        processPackage(abstractPackage);

        return "thanks for your package";
    }

    @PostMapping(value = "/packages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String newPackages(@RequestBody List<AbstractPackage> abstractPackages) {
        for (AbstractPackage abstractPackage : abstractPackages) {
            String result = processPackage(abstractPackage);
            System.out.println(result);
        }

        return "thanks for your packages";
    }

    private String processPackage(AbstractPackage abstractPackage) {
        return switch (abstractPackage) {
            case LightPackage lightPackage -> lightPackage.description();
            case HeavyPackage heavyPackage -> heavyPackage.description() + " Weight: " + heavyPackage.weight();
        };
    }
}
