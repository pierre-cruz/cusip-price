package com.ice.cusipprice.service;

import com.ice.cusipprice.model.Cusip;
import com.ice.cusipprice.repository.CusipRepository;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;


@Service
public class CusipService {

    @Autowired
    CusipRepository cusipRepository;

    public void ingestCusipFile(String fileName) throws IOException {
        File theFile = getFileFromResources(fileName);
        LineIterator it = FileUtils.lineIterator(theFile, "UTF-8");
        try {
            String cusip = null;
            String lastCusip = null;
            Double price = null;
            while (it.hasNext()) {
                lastCusip = cusip;
                String line = it.nextLine().trim();
                if(isCusip(line)) {
                    if(lastCusip != null && price != null) {
                        cusipRepository.save(new Cusip(lastCusip, price));
                    }
                    price = null;
                    cusip = line;
                    continue;
                }
                if(NumberUtils.isCreatable(line)) {
                    price = Double.parseDouble(line);
                }
            }
            cusipRepository.save(new Cusip(cusip, price));
        } finally {
            it.close();
        }
    }

    private File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
    private boolean isCusip(String cusipString) {
        return cusipString.length() == 8 && StringUtils.isAlphanumeric(cusipString);
    }


}
