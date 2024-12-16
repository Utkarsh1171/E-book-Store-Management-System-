I was asked to convert XSLX to JSON in a very short time. First I was thinking on the lines of using MS Excel export to CSV and then use sed or awk to output to JSON. However looking at the data and unescaped quotes it become almost impossible. Also we need to do some conversions while generating the giant JSON array.

So I then turned to apache POI library which allows to read from XLS after we save the file to XSLX from MS Excel. Next was the mirage of jars that were to be used, see below. I did not had time to create maven project for this and then came JSHELL to rescue.

1. commons-beanutils-1.8.3.jar => https://repo1.maven.org/maven2/commons-beanutils/commons-beanutils/1.8.3/commons-beanutils-1.8.3.jar
2. ezmorph-1.0.6.jar => https://repo1.maven.org/maven2/net/sf/ezmorph/ezmorph/1.0.6/ezmorph-1.0.6.jar
3. commons-collections-3.2.1.jar => https://repo1.maven.org/maven2/commons-collections/commons-collections/3.2.1/commons-collections-3.2.1.jar
4. commons-lang-2.6.jar => https://repo1.maven.org/maven2/commons-lang/commons-lang/2.6/commons-lang-2.6.jar
5. json-lib-2.4-jdk15.jar =>https://repo1.maven.org/maven2/net/sf/json-lib/json-lib/2.4/json-lib-2.4-jdk15.jar
6. poi-bin-3.16-20170419.zip  => https://archive.apache.org/dist/poi/release/bin/poi-bin-3.16-20170419.zip

- Download all files and execute using JSHELL path.
```
#!/usr/bin/java --source 12 --class-path /Users/dhval/project/jar/poi-3.16/lib/*
jshell> /open ReadExcelToJson.java
```

- Alternatively with JDK 1.9+
```
CLASSPATH=/Users/dhval/project/jar/poi-3.16/lib/* jshell
```


