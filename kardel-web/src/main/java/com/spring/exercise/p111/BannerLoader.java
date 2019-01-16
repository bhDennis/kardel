package com.spring.exercise.p111;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dennis on 2018/12/18.
 */
public class BannerLoader implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void showBanner() throws IOException{

        Resource resource = resourceLoader.getResource("classpath:banner.txt");
        InputStream inputStream = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (true){
            String line = reader.readLine();
            if(line == null)
                break;
            System.out.print(line);
        }
        reader.close();
    }
}
