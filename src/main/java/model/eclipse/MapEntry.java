package model.eclipse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class MapEntry {
    @XmlAttribute
    private String key;
    @XmlAttribute
    private String value;
    public MapEntry() {

    }
}
