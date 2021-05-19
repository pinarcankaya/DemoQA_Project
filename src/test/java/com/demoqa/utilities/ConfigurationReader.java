package com.demoqa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    public static Properties properties;  ///properties nesnemizi olusturduk cingig.properties deki bilgiler var artik

    static {//java ilk once static methodlari b=ve static bloklari okur

        String path = "configuration.properties";//dosyayi bulur

        FileInputStream file = null;
        try {
            file = new FileInputStream(path); ///FileInputStream yardimi ile acar ve okur
            properties = new Properties();   //properties nesnesi olusturulur
            properties.load(file);//okudugu dosyayi properties icine yukler

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String getProperty(String key) {  ///buradaki ismi biz verdik
        return properties.getProperty(key);  //buradaki isim properties classindan gelen method ismi
        //yani sadce isim benziyor yoksa ustteki frakli bir isim de olabilir
        //cevap olarak propertideki bilgi return edilir
    }
}
