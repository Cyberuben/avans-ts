package ProjectManagement.SprintState;

import ProjectManagement.Sprint;

public class ReviewingSprintState extends SprintState {
    public ReviewingSprintState(Sprint sprint) {
        this.sprint = sprint;
    }

    public void finishReview(String file) {
        this.sprint.state = new ClosedSprintState(this.sprint);
    }
}
