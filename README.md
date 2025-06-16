# java-mvn-jpautils

Utility classes for JPA projects. The library is built with **Java 20** and can
be published as a package in GitHub so it can be consumed from other Maven
projects.

## Publishing to GitHub Packages

The `pom.xml` already contains a `distributionManagement` section pointing to
GitHub Packages. To publish you need a [personal access token](https://docs.github.com/en/packages)
with the `write:packages` scope and configure it in your Maven `settings.xml`:

```xml
<servers>
  <server>
    <id>github</id>
    <username>YOUR_GITHUB_USERNAME</username>
    <password>YOUR_GITHUB_TOKEN</password>
  </server>
</servers>
```

Deploy the package with:

```bash
mvn deploy
```

## Using the package

Other projects can consume the package by defining the GitHub Packages
repository and adding the dependency:

```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/STDevLib/java-mvn-jpautils</url>
  </repository>
</repositories>

<dependency>
  <groupId>com.froyo</groupId>
  <artifactId>java-mvn-jpautils</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```
