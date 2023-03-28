package model.intellij;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Configuration {
    @XmlAttribute(name = "default")
    private String defaults;
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String type;
    @XmlAttribute
    private String factoryName;
    @XmlAttribute
    private String nameIsGenerated;
    @XmlElement
    private List<Envs> envs;
    @XmlElement
    private List<Option> option;
    @XmlElement
    private Module module;
    @XmlElement
    private List<Extension> extension;
    @XmlElement
    private List<Method> method;


    public String getDefaults() {
        return defaults;
    }

    public void setDefaults(String defaults) {
        this.defaults = defaults;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getNameIsGenerated() {
        return nameIsGenerated;
    }

    public void setNameIsGenerated(String nameIsGenerated) {
        this.nameIsGenerated = nameIsGenerated;
    }

    public List<Envs> getEnvs() {
        return envs;
    }

    public void setEnvs(List<Envs> envs) {
        this.envs = envs;
    }

    public List<Option> getOption() {
        return option;
    }

    public void setOption(List<Option> option) {
        this.option = option;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<Extension> getExtension() {
        return extension;
    }

    public void setExtension(List<Extension> extension) {
        this.extension = extension;
    }

    public List<Method> getMethod() {
        return method;
    }

    public void setMethod(List<Method> method) {
        this.method = method;
    }

    public Configuration() {
    }
}
