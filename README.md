# autosaver
Autosaver java GUI application  
# Building executable jar 
### Compile the main class
```
javac NewJFrame.java
```
### Check MANIFEST.mf file content
```
Manifest-Version: 1.0
Main-Class: NewJFrame
```
### package the compiled classes into one executable jar 
```
jar cfm autosaver.jar MANIFEST.MF *.class
```
### Run jar file
```
java -jar autosaver.jar 
```
