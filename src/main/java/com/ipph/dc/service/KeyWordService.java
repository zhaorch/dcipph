package com.ipph.dc.service;

import com.ipph.dc.model.KeyWord;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.Set;

@WebService
public interface KeyWordService {
    @WebMethod
    Set<String> getKeyWords(@WebParam(name = "content") String content);

    @WebMethod
    List<KeyWord> getKeyWordsDetail(@WebParam(name = "content") String content);
}

