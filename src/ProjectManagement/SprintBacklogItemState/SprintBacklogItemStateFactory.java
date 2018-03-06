package ProjectManagement.SprintBacklogItemState;

import ProjectManagement.SprintBacklogItem;

public class SprintBacklogItemStateFactory {
    public static SprintBacklogItemState getTodoState(SprintBacklogItem item) {
        return new TodoSprintBacklogItemState(item);
    }
}
