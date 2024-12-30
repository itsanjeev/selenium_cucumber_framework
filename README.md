## Selenium Cucumber Framework - Starter Pack

The **Selenium Cucumber Framework - Starter Pack** is a simple, flexible, and easy-to-use framework designed for
automated testing of web applications. It combines the powerful browser automation capabilities of Selenium WebDriver
with Cucumber's behavior-driven development (BDD) approach. This framework enables teams to write test scenarios in
plain English using the Gherkin syntax, making test cases more readable and collaborative.

This framework is ideal for teams and individuals who aim to quickly set up a robust and maintainable automation testing
strategy while creating clear and understandable automated test scenarios.

---

### Features

1. **Selenium WebDriver for Browser Automation**  
   Automate modern browsers such as Chrome, Firefox, Edge, and others.

2. **Cucumber for Behavior-Driven Development (BDD)**  
   Write test scenarios in Gherkin syntax, enabling collaboration between technical teams and non-technical
   stakeholders.

3. **Cross-Browser Compatibility**  
   Execute tests seamlessly across multiple browsers by configuring the desired capabilities.

4. **Page Object Model (POM)**  
   Adopt an organized and maintainable Page Object Model (POM) design that separates test scripts and page-specific
   logic.

5. **Integration with Cucumber JUnit**  
   Easily integrate with test execution frameworks such as JUnit for seamless execution and reporting.

6. **Detailed Logging with Log4j**  
   Harness the power of **Log4j** for detailed and customizable test execution logs.

7. **Extensibility**  
   The framework is easy to extend, allowing integration with additional tools like CI/CD pipelines, reporting
   frameworks, and more.

---

### Benefits

- **Readable and Maintainable Scenarios:** Gherkin syntax encourages collaboration, as scenarios can be understood by
  all stakeholders, whether technical or non-technical.
- **Rapid Setup:** Out-of-the-box template to start writing and running automated web tests.
- **Reusable Logic:** Centralized and modular test structure ensures reduced code redundancy.
- **Integration-Ready:** Adaptable for CI tools (e.g., Jenkins), customized test reports, and parallel execution.
- **Improved Collaboration:** Encourages teamwork across developers, testers, and business teams with a unified language
  for test scenarios.

---

### Getting Started

#### Prerequisites:

1. **Java Development Kit (JDK):** Ensure you have JDK 8 or later installed.  
   [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

2. **Maven:** The framework uses Maven as the build management tool.
   [Download Maven](https://maven.apache.org/download.cgi)

3. **Browsers:** Install the browsers you wish to test on, such as Google Chrome or Firefox.


---

#### Installation:

1. Clone the repository:
   ```bash
   git clone https://github.com/renuka2593/selenium_cucumber_framework.git
   cd selenium_cucumber_framework
   ```

2. Install dependencies:  
   Run the following Maven command in the project root directory:
   ```bash
   mvn clean install
   ```

3. Configure browser settings:  
   Update browser configurations in the `config.properties` file, located at `src/main/resources`.

4. Run Tests:  
   Use the following Maven command to execute your test scenarios:
   ```bash
   mvn -Dtest=HerokuAppTestRunner test
   ```

---

### Framework Directory Structure

Below is the high-level directory structure:

```
├── pom.xml  
│ Maven configuration file for managing project dependencies, build lifecycle, and plugins.  
├── src  
│ ├── main  
│ │ ├── java  
│ │ │ └── io.github.seleniumhelper  
│ │ │ Core helper classes for web automation such as element finding, dropdown handling, table interactions, and
WebDriver management.  
│ │ └── resources  
│ │ Contains configuration files such as `log4j2.xml` for logging and global settings.  
│ ├── test  
│ │ ├── java  
│ │ │ └── com  
│ │ │ ├── common  
│ │ │ │ Base classes, hooks, and reusable utility classes.  
│ │ │ ├── internet.herokuapp  
│ │ │ │ HerokuApp-specific page objects and step definitions.  
│ │ │ └── myntra  
│ │ │ Myntra-specific page objects and step definitions.  
│ │ └── resources  
│ │ ├── config  
│ │ │ Contains configuration files like `config.properties` for test configurations.  
│ │ └── features  
│ │ Contains feature files written in Gherkin syntax defining test scenarios.
```
```bash
#!/bin/bash

# List all files that are being staged
files=$(git diff --cached --name-only --diff-filter=ACM)

# Loop through all the files
for file in $files; do
  # Only check .java files
  if [[ "$file" == *.java ]]; then
    # Check if the file is a text file (not binary)
    if file --mime-type "$file" | grep -q "text"; then
      # Attempt to convert the file to UTF-8 and detect errors
      if ! iconv -f utf-8 -t utf-8 "$file" -o /dev/null 2>&1; then
        echo "Error: The file '$file' is not UTF-8 encoded. It might be in ISO-8859-1 or another encoding."
        exit 1  # Abort commit if any file is not UTF-8 encoded
      fi

      # Optionally, you can check for other encodings, e.g., ISO-8859-1
      if file -i "$file" | grep -q 'iso-8859-1'; then
        echo "Warning: The file '$file' is ISO-8859-1 encoded. Consider converting it to UTF-8."
        # You can exit with a warning, or just allow the commit but log the warning
        # exit 1  # Uncomment this line to block commit if ISO-8859-1 is detected
      fi
    fi
  fi
done

# Allow commit if all checks pass
exit 0


```

