package com.ipph.dc.service;

import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.ipph.dc.model.KeyWord;
import com.ipph.dc.model.KeyWordPosition;
import com.ipph.dc.util.IPPHString;
import com.sun.org.apache.xpath.internal.compiler.Keywords;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ZRC
 * Date Time: 2019/8/7 14:15
 * Description: No Description
 */
@WebService(serviceName="KeyWordService",targetNamespace="http://service.dc.ipph.com/",endpointInterface = "com.ipph.dc.service.KeyWordService")
@Service
public class KeyWordServiceImpl implements KeyWordService {
    @Override
    public Set<String> getKeyWords(String content) {
        Set<String> result = new HashSet<String>();

        final char[] charArray = content.toCharArray();
        CustomDictionary.parseLongestText(content, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>() {
            @Override
            public void hit(int begin, int end, CoreDictionary.Attribute value) {
                String temp = new String(charArray, begin, end - begin);
                if (value.nature[0].toString().equals(IPPHString.CHEMICAL)) {
                    result.add(temp);
                    // System.out.printf("[%d:%d]=%s %s\n", begin, end, temp, value);
                }
            }
        });
        return result;
    }

    @Override
    public List<KeyWord> getKeyWordsDetail(String content) {
        List<KeyWord> result = new ArrayList<KeyWord>();
        Map<String, KeyWord> map = new HashMap<String,KeyWord>();

        final char[] charArray = content.toCharArray();
        CustomDictionary.parseLongestText(content, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>() {
            @Override
            public void hit(int begin, int end, CoreDictionary.Attribute value) {
                String keyWord = new String(charArray, begin, end - begin);
                if (value.nature[0].toString().equals(IPPHString.CHEMICAL)) {
                    if(!map.containsKey(keyWord)){
                        KeyWord temp = new KeyWord(keyWord);
                        map.put(keyWord,temp);
                        result.add(temp);
                    }
                    map.get(keyWord).addKeyWordPosition(new KeyWordPosition(begin,end));
                }
            }
        });
        return result;
    }

}
