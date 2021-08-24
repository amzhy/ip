public class DoneCommand implements  Command {
    private String number;

    public DoneCommand(String no) {
        this.number = no;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws  DukeException {
        try {
            int i = Integer.parseInt(number.trim()) - 1;
            String t = taskList.markDone(i);
            ui.echo("Nice! I marked this task as completed: " + t);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeException("Oops! Enter a valid task no. to complete the task.");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
