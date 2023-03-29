import model.eclipse.LaunchConfiguration;
import model.intellij.*;
import model.intellij.Module;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationConvertor {
    public static void main(String args[]) throws JAXBException {
        String filePath = args[0];
        File file = new File(filePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(LaunchConfiguration.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        LaunchConfiguration launchConfiguration = (LaunchConfiguration) unmarshaller.unmarshal(file);
        getLaunchConfiguration(launchConfiguration);
    }

    private static void getLaunchConfiguration(LaunchConfiguration launchConfiguration) throws JAXBException {
        JAXBContext jaxbContextInstance = JAXBContext.newInstance(LaunchConfiguration.class);
        Marshaller jaxbMarshaller = jaxbContextInstance.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBContext contextObj = JAXBContext.newInstance(Component.class);
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerObj.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        String fullyQualifiedMainClassName = getFullQualifiedMainClass(launchConfiguration);
        String mainClassName = getMainClassName(fullyQualifiedMainClassName);
        Configuration configuration = generateConfiguration(launchConfiguration, mainClassName, fullyQualifiedMainClassName);
        Component component = new Component("ProjectRunConfigurationManager", configuration);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        marshallerObj.marshal(component, outputStream);
        String outputFileName = mainClassName + "-run-intellij.xml";
        marshallerObj.marshal(component, new File(outputFileName));
    }

    private static Configuration generateConfiguration(LaunchConfiguration launchConfiguration, String mainClassName, String fullyQualifiedMainClassName) {
        Configuration configuration = new Configuration();
        configuration.setDefaults("false");
        configuration.setType("Application");
        configuration.setName(mainClassName);
        configuration.setFactoryName("Application");
        configuration.setNameIsGenerated("true");
        List<Envs> envsList = generateEnvs();
        configuration.setEnvs(envsList);
        List<Option> optionArrayList = generateOptions(fullyQualifiedMainClassName, launchConfiguration);
        configuration.setOption(optionArrayList);
        Module module = new Module();
        String moduleFullPath = getFullQualifiedModule(launchConfiguration);
        module.setName(moduleFullPath);
        configuration.setModule(module);
        List<Extension> extensionList = generateExtension(launchConfiguration);
        configuration.setExtension(extensionList);
        List<Method> methodList = generateMethod();
        configuration.setMethod(methodList);
        return configuration;
    }

    private static List<Method> generateMethod() {
        List<Method> methodList = new ArrayList<>();
        Method method = new Method();
        method.setVersion("2");
        List<Option> optionLists = new ArrayList<>();
        Option optionMake = new Option();
        optionMake.setName("Make");
        optionMake.setValue("true");
        method.setOption(optionLists);
        methodList.add(method);
        optionLists.add(optionMake);

        return methodList;
    }

    private static List<Extension> generateExtension(LaunchConfiguration launchConfiguration) {
        List<Extension> extensionList = new ArrayList<>();
        Extension extension = new Extension();
        extension.setName("coverage");
        List<Pattern> patternList = new ArrayList<>();
        Pattern pattern = new Pattern();
        List<Option> optionList = new ArrayList<>();
        pattern.setOption(optionList);
        extension.setPatterns(patternList);
        Option optionPattern = new Option();
        optionPattern.setName("PATTERN");
        String fullQualifiedWithStar = getFullQualifiedWithStar(launchConfiguration);
        optionPattern.setValue(fullQualifiedWithStar);
        Option optionEnabled = new Option();
        optionEnabled.setName("ENABLED");
        optionEnabled.setValue("true");
        optionList.add(optionPattern);
        optionList.add(optionEnabled);
        patternList.add(pattern);
        extensionList.add(extension);
        return extensionList;
    }

    private static List<Option> generateOptions(String fullyQualifiedMainClassName, LaunchConfiguration launchConfiguration) {
        List<Option> optionArrayList = new ArrayList<>();
        Option option = new Option();
        option.setName("MAIN_CLASS_NAME");
        option.setValue(fullyQualifiedMainClassName);
        optionArrayList.add(option);
        Option optionVM = new Option();
        optionVM.setName("VM_PARAMETERS");
        String fullQualifiedserver = getFullServerPath(launchConfiguration);
        optionVM.setValue(fullQualifiedserver);
        optionArrayList.add(optionVM);
        Option optionDir = new Option();
        optionDir.setName("WORKING_DIRECTORY");
        optionDir.setValue("$MODULE_WORKING_DIR$");
        optionArrayList.add(optionDir);
        return optionArrayList;
    }


    private static List<Envs> generateEnvs() {
        List<Envs> envsList = new ArrayList<>();
        Envs envs = new Envs();
        List<Env> envList = new ArrayList<>();
        Env envAbout = new Env();
        envAbout.setName("AWS_PROFILE");
        envAbout.setValue("about-dev");
        Env envUsEast = new Env();
        envUsEast.setName("AWS_REGION");
        envUsEast.setValue("us-east-1");
        envList.add(envAbout);
        envList.add(envUsEast);
        envs.setEnv(envList);
        envsList.add(envs);
        return envsList;
    }

    private static String getMainClassName(String fullQualifiedClassName) {
        String mainClassName = null;
        String[] split = fullQualifiedClassName.split("\\.");
        mainClassName = split[split.length - 1];
        return mainClassName;
    }

    private static String getFullQualifiedMainClass(LaunchConfiguration stringAttributeNode) {
        String fullyQualifiedMainClassName = null;
        for (int i = 0; i < stringAttributeNode.getStringAttribute().size(); i++) {
            if (stringAttributeNode.getStringAttribute().get(i).getKey().equals("org.eclipse.jdt.launching.MAIN_TYPE")) {
                fullyQualifiedMainClassName = stringAttributeNode.getStringAttribute().get(i).getValue();
            }
        }
        return fullyQualifiedMainClassName;
    }

    private static String getFullServerPath(LaunchConfiguration stringAttributeNode) {
        String fullQualifiedServerPath = null;
        for (int i = 0; i < stringAttributeNode.getStringAttribute().size(); i++) {
            if (stringAttributeNode.getStringAttribute().get(i).getKey().equals("org.eclipse.jdt.launching.VM_ARGUMENTS")) {
                fullQualifiedServerPath = stringAttributeNode.getStringAttribute().get(i).getValue();
            }
        }

        return fullQualifiedServerPath;
    }

    private static String getFullQualifiedWithStar(LaunchConfiguration stringAttributeNode) {
        String optionStar = null;
        for (int i = 0; i < stringAttributeNode.getStringAttribute().size(); i++) {
            if (stringAttributeNode.getStringAttribute().get(i).getKey().equals("org.eclipse.jdt.launching.MAIN_TYPE")) {
                String node = stringAttributeNode.getStringAttribute().get(i).getValue();
                String[] word = node.split("\\.");
                int lastWordIndex = word.length - 1;
                word[lastWordIndex] = "*";
                optionStar = String.join(".", word);
            }
        }
        return optionStar;
    }

    private static String getFullQualifiedModule(LaunchConfiguration stringAttributeNode) {
        String modulePath = null;
        for (int i = 0; i < stringAttributeNode.getStringAttribute().size(); i++) {
            if (stringAttributeNode.getStringAttribute().get(i).getKey().equals("org.eclipse.jdt.launching.PROJECT_ATTR")) {
                modulePath = stringAttributeNode.getStringAttribute().get(i).getValue();
            }
        }
        return modulePath;
    }
}
