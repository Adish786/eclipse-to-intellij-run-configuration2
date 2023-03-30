package model.eclipse;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "launchConfiguration")
public class LaunchConfiguration {
    @XmlAttribute
    private String type;

    private List<ListAttribute> listAttribute;
    private MapAttribute mapAttribute;
    private Attribute booleanAttribute;
    private List<Attribute> stringAttribute;

    public LaunchConfiguration() {
    }

    public String getLaunchConfiguration() {
        return type;
    }

    public void setLaunchConfiguration(String type) {
        this.type = type;
    }
    @XmlElement
    public List<ListAttribute> getListAttribute() {
        return listAttribute;
    }

    public void setListAttribute(List<ListAttribute> listAttribute) {
        this.listAttribute = listAttribute;
    }
    @XmlElement

    public MapAttribute getMapAttribute() {
        return mapAttribute;
    }

    public void setMapAttribute(MapAttribute mapAttribute) {
        this.mapAttribute = mapAttribute;
    }
    @XmlElement
    public Attribute getBooleanAttribute() {
        return booleanAttribute;
    }

    public void setBooleanAttribute(Attribute booleanAttribute) {
        this.booleanAttribute = booleanAttribute;
    }
    @XmlElement
    public List<Attribute> getStringAttribute() {
        return stringAttribute;
    }

    public void setStringAttribute(List<Attribute> stringAttribute) {
        this.stringAttribute = stringAttribute;
    }
}
