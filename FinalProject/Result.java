package FinalProject;

public class Result {

    private final boolean success;
    private final double troco;
    private final String message;

    public Result(boolean success, double troco, String message) {
        this.success = success;
        this.troco = troco;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public double getTroco() {
        return troco;
    }

    public String getMessage() {
        return message;
    }
}
