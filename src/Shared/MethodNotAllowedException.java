package Shared;

public class MethodNotAllowedException extends Exception {
    public MethodNotAllowedException() {
        super("Method not allowed");
    }
}
