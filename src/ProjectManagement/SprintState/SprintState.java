package ProjectManagement.SprintState;

import ProjectManagement.*;
import Shared.MethodNotAllowedException;

import java.util.Date;

public abstract class SprintState {
    public Sprint sprint;

    public SprintState() {

    }

    public void setName(String name) throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public void setDuration(Date start, Date end) throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public SprintMember addMember(Member member) throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public SprintBacklogItem addBacklogItem(BacklogItem item) throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public void setType(Sprint.SprintType type) throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public void start() throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public void finish() throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public void release() throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public void review() throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public void cancelRelease() throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }

    public void finishReview(String file) throws MethodNotAllowedException {
        throw new MethodNotAllowedException();
    }
}
