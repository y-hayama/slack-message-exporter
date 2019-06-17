package com.hanetarou;

/**
 * Hello world!
 */
public final class MessageExporter {
    private MessageExporter() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        MessageExporter app = new MessageExporter();
        app.hello();
    }

    public void hello() {
        System.out.println("Hello World!");
    }
}
