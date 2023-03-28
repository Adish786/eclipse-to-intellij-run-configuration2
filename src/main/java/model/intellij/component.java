package model.intellij;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class component implements Serializable {
    @XmlAttribute
    private String name;
    @XmlElement
    private Configuration configuration;

    public component(String name, Configuration configuration) {
        this.name = name;
        this.configuration = configuration;
    }


    public component() {

    }


}
