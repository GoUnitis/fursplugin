package si.gounitis.fursplugin;

/**
 * Created by Jure on 8.10.2015.
 */
public class FursPluginException extends Exception{
    public FursPluginException() {
        super();
    }

    public FursPluginException(String message) {
        super(message);
    }

    public FursPluginException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public FursPluginException(Throwable throwable) {
        super(throwable);
    }

}
