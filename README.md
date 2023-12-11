# Java Version Verifier

The Java Version Verifier streamlines the process of confirming the precise Java version installed on a system. Usually, checking the Java version involves running `java -version` and deciphering the complex output, which varies widely and can be confusing. This tool simplifies the task by comparing the installed Java version to an exact version prefix specified by the user, providing a straightforward 'yes' or 'no' result. It's a basic but effective solution designed for exact version matches, which eliminates guesswork, saves time, and ensures that Java applications are set up with the correct version requirements from the start.
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them:

```bash
# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "Java is not installed."
    exit 1
fi
```

### Installing

A step by step series of examples that tell you how to get a development environment running:

1. Clone the repository to your local machine.
2. Navigate to the directory where you cloned the repository.
3. Run the script or the JAR file with the required version prefix.

### Cloning the Repository and Building

To clone the repository and work with the Java Version Verifier, you will need Git installed on your system. Open your terminal, command prompt, or Git bash and run the following command:

```bash
git clone https://github.com/yoelp2k/java-version-verifier.git
cd java-version-verifier
./gradlew build
```

### Using the verifier via bash

```bash

# Run your Java version verifier JAR file
java_version_output=$(java -jar java-version-verifier-1.0.jar "17.")

# Check the exit code of the Java version verifier
if [ $? -eq 0 ]; then
    echo "Java version 17 or compatible is installed."
else
    echo "Java version 17 or compatible is required."
    exit 1
fi
```

## Usage

To use the Java Version Verifier, run the following command:

```bash
java -jar java-version-verifier-1.0.jar <version-prefix>
```

Replace `<version-prefix>` with the version prefix that you wish to verify, such as `17.` for Java 17 or `1.8.` for Java 8.

## Exit Codes

The Java Version Verifier uses the following exit codes:

- `0`: Specified version matches
- `1`: Specified version mismatch
- `2`: No arguments provided (displays help)
- `3`: Security manager exception
- `4`: Unknown exception

## Built With

* Java - The programming language used

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details