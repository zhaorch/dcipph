package com.ipph.dc.runner;

import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.ipph.dc.util.IPPHString;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: ZRC
 * Date Time: 2019/8/7 13:59
 * Description: No Description
 */

@Component
public class IPPHRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("DictZh.txt");
        InputStreamReader read = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader reader = new BufferedReader(read);
        String str;

        // 用户字典
        while ((str = reader.readLine()) != null) {
            CustomDictionary.add(str, IPPHString.CHEMICAL + " 1024");
        }
        reader.close();
        read.close();
        inputStream.close();
    }
}
