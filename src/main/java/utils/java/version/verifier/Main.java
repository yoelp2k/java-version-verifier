package utils.java.version.verifier;

/**
 * example script to call this program
 * #!/bin/bash
 *
 * # Check if Java is installed
 * if ! command -v java &> /dev/null; then
 *     echo "Java is not installed."
 *     exit 1
 * fi
 *
 * # Run your Java version verifier JAR file
 * java_version_output=$(java -jar java-version-verifier-1.0.jar "17.")
 *
 * # Check the exit code of the Java version verifier
 * if [ $? -eq 0 ]; then
 *     echo "Java version 17 or compatible is installed."
 * else
 *     echo "Java version 17 or compatible is required."
 *     exit 1
 * fi
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Verify installed Java version");
            System.out.println("Usage:");
            System.out.println(" > java -jar java-version-verifier-1.0.jar <version-prefix>");
            System.out.println("Where <version-prefix> is the version prefix to verify.");
            System.out.println("For Java 17, use '17.' (e.g., > java -jar java-version-verifier-1.0.jar 17.)");
            System.out.println("For Java 8, use '1.8.'.");
            System.out.println("The program checks 'System.getProperty(\"java.version\")' against <version-prefix>.");
            System.out.println("If the version matches, the program exits without error (exit code 0).");
            System.out.println("If not, the exit value will be 1, indicating that the current Java version does not match the specified prefix.");
            System.out.println();
            System.out.println("Exit code legend:");
            System.out.println(" - 0: Specified version matches");
            System.out.println(" - 1: Specified version mismatch");
            System.out.println(" - 2: No arguments - display help");
            System.out.println(" - 3: Security manager exception");
            System.out.println(" - 4: Unknown exception");
            System.exit(2); // Changed the exit code for incorrect usage
        } else {
            String prefix = args[0];

            try {
                String javaVersion = System.getProperty("java.version");
                if (javaVersion.startsWith(prefix)) {
                    // System.out.println("Success! '" + prefix + "' found in java version '" + javaVersion + "'");
                    System.exit(0);
                } else {
                    // System.out.println("Failure! '" + prefix + "' not found in java version '" + javaVersion + "'");
                    System.exit(1);
                }
            } catch (SecurityException e) {
                System.err.println("Security manager does not allow access to system properties.");
                System.exit(3); // Exit with an error code for security exception
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
                System.exit(4); // Exit with a generic error code for other exceptions
            }
        }
    }
}
