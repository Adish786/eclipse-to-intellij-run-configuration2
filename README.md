## Introduction:
This application will convert the eclipse run configuration XML file to IntelliJ run configuration XML file
The absolute path of the file (Eclipse xml) is passed as an argument to the program.
ConfigurationConvertor.java is the file with the main method.

The application uses JAXB to marshall and unmarshal XML.
Appropriate Model classes corresponding to the Eclipse XML and IntelliJ XML are created and
used to Marshal and UnMarshall XML.


## How to use:
Pass the Eclipse XML run configuration file as an argument to the program.
Run the file ConfigurationConvertor.java
The output file will be generated with name inputFileName-run-intellij.xml