import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Pattern {
    @XmlElement
    private List<Option> option;

    public List<Option> getOption() {
        return option;
    }

    public void setOption(List<Option> option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Pattern{" +
                "option=" + option +
                '}';
    }

    public Pattern() {
    }
}
