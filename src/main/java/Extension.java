import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Extension {
    @XmlElement
    private List<Pattern> patterns;
    @XmlAttribute
    private String name;

    @Override
    public String toString() {
        return "Extension{" +
                "patterns=" + patterns +
                ", name='" + name + '\'' +
                '}';
    }

    public Extension(List<Pattern> patterns, String name) {
        this.patterns = patterns;
        this.name = name;
    }

    public List<Pattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<Pattern> patterns) {
        this.patterns = patterns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Extension() {
    }
}
