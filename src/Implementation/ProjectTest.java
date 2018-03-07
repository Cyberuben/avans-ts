package Implementation;

import Core.NotifyService.NotificationAgent;
import ProjectManagement.*;
import Shared.MethodNotAllowedException;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectTest {
    public static Project project;
    public static Sprint sprint;
    public static SprintStateObserver sprintStateObserver;
    public static BacklogItemStateObserver backlogItemStateObserver;

    @org.junit.BeforeClass
    public static void setUp() throws Exception {
        MemorySender sender = new MemorySender();
        SlackNotificationService slack = new SlackNotificationService(sender);
        EmailNotificationService email = new EmailNotificationService(sender);
        NotificationAgent.getInstance().registerService("slack", slack);
        NotificationAgent.getInstance().registerService("email", email);

        project = new Project("Test project");

        sprintStateObserver = new CheckSprintFinishedObserver();
        backlogItemStateObserver = new NotifyBacklogItemTodoObserver();
    }

    @org.junit.Test
    public void t01_CreatingBacklogItems() {
        project.addBacklogItem("Creating diagrams");
        project.addBacklogItem("Writing code");
        project.addBacklogItem("Writing tests");
        project.addBacklogItem("Print the report");

        assertEquals(project.backlogItems.size(), 4);
    }

    @org.junit.Test
    public void t02_CreatingMembers() {
        Member m = project.addMember("Pascal");
        m.roles.add("productowner");
        m.notifyConfig.put("email", "pascal@avans.nl");
        m.notifyConfig.put("slack", "slackid:pascal");
        m = project.addMember("Koen");
        m.notifyConfig.put("email", "koen@avans.nl");
        m = project.addMember("Ruben");
        m.notifyConfig.put("slack", "slackid:ruben");

        assertEquals(project.members.size(), 3);
    }

    @org.junit.Test
    public void t03_CreatingSprints() {
        sprint = project.addSprint("Test sprint");

        sprint.subscribe(sprintStateObserver);

        assertEquals(project.sprints.size(), 1);
        assert(sprint != null);
    }

    @org.junit.Test
    public void t04_NotAllowedMethodsSprint() {
        try {
            sprint.finish();
        } catch (MethodNotAllowedException e) {
            assert(e instanceof MethodNotAllowedException);
        }
        try {
            sprint.release();
        } catch (MethodNotAllowedException e) {
            assert(e instanceof MethodNotAllowedException);
        }
        try {
            sprint.review();
        } catch (MethodNotAllowedException e) {
            assert(e instanceof MethodNotAllowedException);
        }
        try {
            sprint.cancelRelease();
        } catch (MethodNotAllowedException e) {
            assert(e instanceof MethodNotAllowedException);
        }
        try {
            sprint.finishReview("hi");
        } catch (MethodNotAllowedException e) {
            assert(e instanceof MethodNotAllowedException);
        }
    }

    @org.junit.Test
    public void t05_AllowedMethodsSprint() {
        try {
            sprint.setName("Test sprint1");
            assertEquals(sprint.name, "Test sprint1");

            for(int i = 0; i < project.backlogItems.size(); i++) {
                SprintBacklogItem b = sprint.addBacklogItem(project.backlogItems.get(i));
                b.subscribe(backlogItemStateObserver);
            }
            assertEquals(sprint.backlogItems.size(), project.backlogItems.size());

            sprint.setDuration(new Date(new Date().getTime() - (24 * 3600 * 1000)), new Date());
            assertNotNull(sprint.startDate);
            assertNotNull(sprint.endDate);

            SprintMember m = sprint.addMember(project.members.get(1));
            m.roles.add("developer");
            m = sprint.addMember(project.members.get(2));
            m.roles.add("developer");
            m.roles.add("scrummaster");
            assertEquals(sprint.members.size(), 2);

            sprint.setType(Sprint.SprintType.RELEASE);
            assertEquals(sprint.type, Sprint.SprintType.RELEASE);

            sprint.start();
        } catch (MethodNotAllowedException e) {
            fail("Should never throw exception");
        }
    }

    @org.junit.Test
    public void t06_SprintStartedForbiddenMethods() {
        try {
            sprint.setName("Test project2");
        } catch (MethodNotAllowedException e) {
            assert(e instanceof MethodNotAllowedException);
        }
        try {
            sprint.addBacklogItem(project.backlogItems.get(0));
        } catch (MethodNotAllowedException e) {
            assert(e instanceof MethodNotAllowedException);
        }
        try {
            sprint.setDuration(new Date(), new Date());
        } catch (MethodNotAllowedException e) {
            assert(e instanceof MethodNotAllowedException);
        }
        try {
            sprint.addMember(project.members.get(0));
        } catch (MethodNotAllowedException e) {
            assert(e instanceof MethodNotAllowedException);
        }
        try {
            sprint.setType(Sprint.SprintType.PARTIAL_PRODUCT);
        } catch (MethodNotAllowedException e) {
            assert(e instanceof MethodNotAllowedException);
        }
        try {
            sprint.start();
        } catch (MethodNotAllowedException e) {
            assert(e instanceof MethodNotAllowedException);
        }
    }

    @Test
    public void t07_AssignMemberToBacklogItem() {
        // Assign to non-assigned item without tasks
        SprintMember m = sprint.members.get(0);
        SprintBacklogItem item = sprint.backlogItems.get(0);
        try {
            item.assignTo(m);
            assertEquals(item.assignedTo, m);
        } catch (MethodNotAllowedException e) {

        }

        // Assign to item with tasks
        item = sprint.backlogItems.get(1);
        try {
            item.addTask("Subtask1");
            assertEquals(item.tasks.size(), 1);
            item.assignTo(m);
            assertNull(item.assignedTo);
        } catch (MethodNotAllowedException e) {

        }

        item = sprint.backlogItems.get(2);
        try {
            item.assignTo(m);
            item.addTask("Subtask2");
            assertEquals(item.tasks.size(), 0);
        } catch (MethodNotAllowedException e) {

        }
    }

    @Test
    public void t08_BacklogItemDone() {
        SprintBacklogItem item = sprint.backlogItems.get(0);

        // Can't set to done without doing it first
        try {
            item.setDone();
        } catch (MethodNotAllowedException e) {
            assert(e instanceof MethodNotAllowedException);
        }

        // Can set to doing and then to done, no tasks
        try {
            item.setDoing();
            item.setDone();
            assert(item.isDone());
        } catch (MethodNotAllowedException e) {

        }

        // Item with tasks, so should be able to be set to done
        item = sprint.backlogItems.get(1);
        try {
            item.setDoing();
        } catch (MethodNotAllowedException e) {

        }

        // Should not be able to set to done because subtask not done
        try {
            item.setDone();
            assert(!item.isDone());
            item.tasks.get(0).done = true;
            item.setDone();
            assert(item.isDone());
        } catch (MethodNotAllowedException e) {

        }
    }

    @Test
    public void t09_SetTodoSendMessage() {
        try {
            SprintBacklogItem item = sprint.backlogItems.get(1);
            item.setTodo();
            assertEquals(1, MemorySender.sentMessages.size());
            MemorySender.sentMessages.clear();
        } catch (MethodNotAllowedException e) {

        }
    }
}