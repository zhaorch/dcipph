package com.ipph.dc.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZRC
 * Date Time: 2019/8/7 14:54
 * Description: No Description
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class KeyWord {
    //@XmlTransient 忽略字段
    private String value;
    private int count;
    private List<KeyWordPosition> keyWordPositionList;

    public KeyWord(String value) {
        this.value = value;
        this.keyWordPositionList = new ArrayList<KeyWordPosition>();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<KeyWordPosition> getKeyWordPositionList() {
        return keyWordPositionList;
    }

    public void setKeyWordPositionList(List<KeyWordPosition> keyWordPositionList) {
        this.keyWordPositionList = keyWordPositionList;
    }

    public int getCount(){
        return this.keyWordPositionList.size();
    }
    public boolean addKeyWordPosition(KeyWordPosition keyWordPosition){
        return this.keyWordPositionList.add(keyWordPosition);
    }
}
