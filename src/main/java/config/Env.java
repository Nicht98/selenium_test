package config;

import java.io.FileReader;
import java.util.Properties;

public enum Env {

    PRODUCTION,
    INTEGRATION;

    private final static String CONFIG_ENV = "config/env.properties";

    private String environmentUrl;

    public static Env parse(String value){
        return Env.valueOf(value);
    }

    public String getUrl(){
        if(this.environmentUrl == null ){
            this.initEnv();
        }
        return this.environmentUrl;
    }

    public String getUrl(String endPoint) {
        String base = getUrl();
        return base + (base.endsWith("/") || endPoint.startsWith("/") ? "" : "/") + endPoint;
    }

    private void setUrl(String url){ this.environmentUrl=url; }

    public void initEnv(){
        try{
            Properties prop = new Properties();
            prop.load(new FileReader(CONFIG_ENV));
            prop.forEach((key, value)->{
                Env.valueOf(key.toString().toUpperCase()).setUrl(value.toString());
            });

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
