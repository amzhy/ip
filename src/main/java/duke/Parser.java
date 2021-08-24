package duke;

import duke.command.*;

public class Parser {

    public static Command parse(String cmd) throws DukeException {
        String[] arr = cmd.split(" ", 2);
        if (cmd.equals("bye")) {
            return new ByeCommand();
        } else if (cmd.equals("list")) {
            return new ListCommand();
        } else if (arr[0].equals("done")) {
            if (arr.length == 1) {
                throw new DukeException("Enter duke.task no. to complete the duke.task.");
            } else {
                return new DoneCommand(arr[1]);
            }
        } else if (arr[0].equals("delete")) {
            if (arr.length == 1) {
                throw new DukeException("Enter duke.task no. to delete the duke.task.");
            } else {
                return new DeleteCommand(arr[1]);
            }
        } else if (arr[0].equals("todo") || arr[0].equals("deadline") || arr[0].equals("event")) {
            if (arr.length == 1 || arr[1].trim().length() == 0) {
                throw new DukeException("Invalid duke.task.Task entry. Description of a duke.task cannot be empty.");
            } else {
                return new AddTaskCommand(arr);
            }
        } else {
            throw new DukeException("Oops! Invalid entry.");
        }
    }
}
