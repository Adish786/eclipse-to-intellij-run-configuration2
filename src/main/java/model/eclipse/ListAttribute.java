package model.eclipse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ListAttribute {
    @XmlElement
    private List<ListEntry> listEntry;
    public ListAttribute() {
    }

}
