# Java DevOps refactoring

![Tests](https://github.com/SalathielGenese/java-devops-refactoring/actions/workflows/test.yaml/badge.svg)

This is a pre-technical interview test. It demos developing a client side of a banking app.

A client:

+ is entitled to an account
+ has the account initialized to 0 (zero)
+ can make deposits into his account
+ may withdraw some or all of his savings
+ print his account statement

## Stack

+ Java 23
  + JDK for .class build and JAR packaging
  + GraalVM for native build
+ Maven

## Methodology

+ Behaviour Driven Development (BDD) with Cucumber
+ Test-Driven Development (TDD) with JUnit Jupiter

## Architecture

+ [Single repository](https://github.com/SalathielGenese/java-devops-refactoring)
+ Maven multi-module
+ Bill-Of-Material (BOM) described in the [root module](https://github.com/SalathielGenese/java-devops-refactoring)
+ Sub-modules:
  + [`core`](https://github.com/SalathielGenese/java-devops-refactoring/tree/main/core):
    The heart logic for an account management.
    + initialization
    + withdrawal
    + deposit
    + balance
    + statement
  + [`console`](https://github.com/SalathielGenese/java-devops-refactoring/tree/main/console):
    A wrapper of the code module to provide a command-line interface (CLI) aka console.
  + [`test`](https://github.com/SalathielGenese/java-devops-refactoring/tree/main/test):
    All the tests of this application.
    + [`core`](https://github.com/SalathielGenese/java-devops-refactoring/tree/main/test/core):
      Tests for the above-mentioned `core` module
    + [`console`](https://github.com/SalathielGenese/java-devops-refactoring/tree/main/test/core):
      Tests for the above-mentioned `console` module
+ Java Platform Module System (JPMS):
  Each of these modules is encapsulated and secured with JPMS.
  JPMS provides dependency-level encapsulation, higher security and performance optimization is some cases.

## Operations (Ops)

Two pipelines are integrated to this project, both as GitHub Actions.

+ [`test`](https://github.com/SalathielGenese/java-devops-refactoring/blob/main/.github/workflows/test.yaml):
  It is triggered by the push of a new commit on any branch.
  It runs tests for all the Maven modules in here (root and descendant).
  + Test report is available too, and you can see a badge of it at the top of this [README.md](https://github.com/SalathielGenese/java-devops-refactoring/blob/main/README.md)
+ [`release`](https://github.com/SalathielGenese/java-devops-refactoring/blob/main/.github/workflows/release.yaml):
  It is trigger by the tagging of any commit on the main branch.
  It leverages GraalVM to build native OS executables.

> **NOTE:** You can even [download](https://github.com/SalathielGenese/java-devops-refactoring/releases) the executable
> for your platform (if supported: GitHub does not support a native Linux ARM for example).
> 
> **NOTE:** If the download link is not working, it probably means GitHub
> [retention policy](https://docs.github.com/en/actions/administering-github-actions/usage-limits-billing-and-administration#artifact-and-log-retention-policy)
> has expired. But there is hope for you... You can fork this repository, tag the main branch et voilà!

## Development

Make sure you have Java 23 & Maven setup. (Consider GraalVM instead, if you want to make native builds).

Clone this repository:
```shell
git clone git@github.com:SalathielGenese/java-devops-refactoring.git
```

Position yourself in the root directory:
```shell
cd java-devops-refactoring
```

Run tests:
```shell
mvn clean test
```

Build native executable for the CLI (`console`):
```shell
mvn clean package -Pnative -pl console -am
```
_(Now, your executable is at `./console/target/java-devops-refactoring-console`)_
