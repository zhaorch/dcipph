package com.ipph.dc.controller;

import com.ipph.dc.model.KeyWord;
import com.ipph.dc.service.KeyWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ZRC
 * Date Time: 2019/8/7 13:41
 * Description: No Description
 */
@RestController
public class KeyWordController {

    @Autowired
    private KeyWordService keyWordService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello IPPH";
    }
    @PostMapping("/keyword")
    public Set<String> getKeywords(@RequestBody String content){
        return keyWordService.getKeyWords(content);
    }

    @PostMapping("/keyword-detail")
    public List<KeyWord> getKeyWordsDetail(@RequestBody String content){
        return keyWordService.getKeyWordsDetail(content);
    }
}
