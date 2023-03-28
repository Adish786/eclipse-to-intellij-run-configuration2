import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "component")
public class XmlMainConfiguration implements Serializable {
    @XmlAttribute
    private String name;
    @XmlElement
    private Configuration configuration;

    public XmlMainConfiguration(String name, Configuration configuration) {
        this.name = name;
        this.configuration = configuration;
    }

    @Override
    public String toString() {
        return "XmlMain{" +
                "name='" + name + '\'' +
                ", configuration=" + configuration +
                '}';
    }

    public XmlMainConfiguration() {

    }


}
