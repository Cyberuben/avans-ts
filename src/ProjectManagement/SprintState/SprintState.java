package ProjectManagement.SprintState;

import ProjectManagement.BacklogItem;
import ProjectManagement.Sprint;

import java.util.Date;

public abstract class SprintState {
    public Sprint sprint;

    public SprintState() {

    }

    public SprintState(Sprint sprint) {
        this.sprint = sprint;
    }

    public void setName(String name) throws Exception {
        throw new Exception("Method not allowed");
    }

    public void setDuration(Date start, Date end) throws Exception {
        throw new Exception("Method not allowed");
    }

    public void addBacklogItem(BacklogItem item) throws Exception {
        throw new Exception("Method not allowed");
    }

    public void start() throws Exception {
        throw new Exception("Method not allowed");
    }

    public void finish() throws Exception {
        throw new Exception("Method not allowed");
    }

    public void release() throws Exception {
        throw new Exception("Method not allowed");
    }

    public void review() throws Exception {
        throw new Exception("Method not allowed");
    }

    public void cancelRelease() throws Exception {
        throw new Exception("Method not allowed");
    }

    public void finishReview(String file) throws Exception {
        throw new Exception("Method not allowed");
    }
}
