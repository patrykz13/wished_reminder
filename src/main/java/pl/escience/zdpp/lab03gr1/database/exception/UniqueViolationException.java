package pl.escience.zdpp.lab03gr1.database.exception;

/**
 * <p>UniqueViolationException class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
public class UniqueViolationException extends Exception {
    /**
     * <p>Constructor for UniqueViolationException.</p>
     *
     * @param message a {@link java.lang.String} object.
     * @param cause a {@link java.lang.Throwable} object.
     */
    public UniqueViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
