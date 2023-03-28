import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Env {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String value;

    @Override
    public String toString() {
        return "Env{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
