public class DukeException extends Exception {
    private String error;


    public DukeException(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return this.error;
    }
}
