/**
* The hello World test program.
* @author: Matthew Sanii
* @version: 1.0
* @since 2022-01-07
*/

final class HelloWorld {

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private HelloWorld() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
    }
}

