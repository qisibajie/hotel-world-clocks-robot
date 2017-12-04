# The sample project of robotframework-maven-plugin 1.2

Use RobotFramework and Java to implement the Hotel World Clocks kata and refactor it to Observer design pattern. In this kata, a hotel has 5 clocks showing the time of Beijing (UTC+8), London (UTC+0), Moscow (UTC+4), Sydney (UTC+10), and New York (UTC-5). You have to consider daylight saving time (DST) for cities like London and New York in this kata. When the time of each one of these clocks is set due to incorrect time or start/end of daylight saving period, the time of all other clocks will be set automatically. The hotel would add more clocks for different cities in the future.

# Steps

1. Create `RobotKeywordLibrary` class under `src/main/java`
```
   public class RobotKeywordLibrary {
   /**
    *  Means that that this instance of the class well be used
    *  for whole lifecycle of test execution.
    */
   public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";
   }
```
2. Add test data file `hotel_world_clocks.txt` under `\src\test\robotframework\acceptance\`. Note this line in this file:
```
Library     com.wubinben.katas.bdd.robot.RobotKeywordLibrary
```
3. Start `ride.py` to view the test data file
4. Add the robotframework maven plugin to the `pom.xml`
```
  <build>
    <plugins>
      <plugin>
        <groupId>org.robotframework</groupId>
        <artifactId>robotframework-maven-plugin</artifactId>
        <version>1.2</version>
        <executions>
          <execution>
            <goals>
              <goal>run</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>2.5.1</version>
        <configuration>
          <encoding>UTF-8</encoding>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
```
5. Run command `mvn clean package robotframework:run`
6. Make all the keywords green
7. Check out the reports in `target/robotframework-reports`



