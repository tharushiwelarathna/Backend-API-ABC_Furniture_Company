package lk.abc.exception;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
