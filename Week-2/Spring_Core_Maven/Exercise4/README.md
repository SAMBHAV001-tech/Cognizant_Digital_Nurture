Exercise 4 - Maven Configuration

What is Maven
Maven is a build automation and project management tool primarily used for Java projects. It uses a XML file called pom.xml (Project Object Model) to describe the project configuration, dependencies, plugins, and build lifecycle.

What is a POM File
POM stands for Project Object Model. It is the core XML file of any Maven project. It defines metadata about the project (groupId, artifactId, version), dependencies (external libraries needed by the project), plugins (used to customize the build process), and compiler settings.

Maven Build Lifecycle
The Maven build lifecycle is a sequence of phases that Maven executes when building a project. The primary phases include:
- clean: Deletes the target directory to start fresh.
- validate: Validates the project information and structure.
- compile: Compiles the source code of the project.
- test: Runs unit tests using testing frameworks.
- package: Packages the compiled code into a distributable format (like JAR or WAR).
- install: Installs the package into the local repository for use by other projects.
- deploy: Copies the final package to a remote repository.
