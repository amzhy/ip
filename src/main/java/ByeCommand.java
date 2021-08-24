public class ByeCommand implements Command {

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        storage.save(taskList.getTasks());
        ui.exit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
