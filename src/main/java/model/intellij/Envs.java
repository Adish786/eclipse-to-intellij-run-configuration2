package model.intellij;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Envs {
    @XmlElement
    private List<Env> env;
    public void setEnv(List<Env> env) {
        this.env = env;
    }
    public List<Env> getEnv() {
        return env;
    }
    public Envs() {
    }

}
