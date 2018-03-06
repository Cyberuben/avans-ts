package ProjectManagement.SprintState;

import ProjectManagement.Sprint;

public class SprintStateFactory {
    public static SprintState getPreSprintState(Sprint sprint) {
        return new PreSprintState(sprint);
    }
}
