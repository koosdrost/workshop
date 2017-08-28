JSR 367: Java API for JSON Binding (JSON-B)
https://jcp.org/en/jsr/detail?id=367

Sources
JSON-B spec: https://github.com/javaee/jsonb-spec/releases/tag/1.0
Reference impl: https://repo.eclipse.org/content/repositories/yasson-releases/org/eclipse/yasson/1.0/


Maven

    <dependencies>
        <!--JSON-B API-->
        <dependency>
            <groupId>javax.json.bind</groupId>
            <artifactId>javax.json.bind-api</artifactId>
            <version>1.0</version>
        </dependency>
        <!--JSON-B Reference Implementation (Yasson) -->
        <dependency>
            <groupId>org.eclipse</groupId>
            <artifactId>yasson</artifactId>
            <version>1.0</version>
            <scope>runtime</scope>
        </dependency>
        <!-- JSON-P API -->
        <dependency>
            <groupId>javax.json</groupId>
            <artifactId>javax.json-api</artifactId>
            <version>1.1</version>
        </dependency>
        <!-- JSON-P Reference Implementation -->
        <dependency>
            <groupId>org.glassfish</groupId>
            <artifactId>javax.json</artifactId>
            <version>1.1</version>
            <scope>runtime</scope>
        </dependency>
    </dependencies>

	<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>