package intellijConfigWriter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Method {
    @XmlElement
    private List<Option> option;
    @XmlAttribute(name = "v")
    private String version;


    public void setOption(List<Option> option) {
        this.option = option;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Method(List<Option> option, String version) {
        this.option = option;
        this.version = version;
    }

    public Method() {
    }
}
