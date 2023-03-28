import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class MapEntry {
    @XmlAttribute
    private String key;
    @XmlAttribute
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MapEntry{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public MapEntry() {

    }
}
