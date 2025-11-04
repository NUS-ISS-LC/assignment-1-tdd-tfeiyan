package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import java.util.Collection;

import static org.junit.Assert.*;


public class ToDoListTest  {
    // Define Test 
    private ToDoList todoList;
    private Task task1;
    private Task task2;
    private Task task3;

    public ToDoListTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
        todoList = new ToDoList();
        task1 = new Task("Pay bills");
        task2 = new Task("Play game");
        task3 = new Task("Do homework", true);
        todoList.addTask(task1);
        todoList.addTask(task2);
        todoList.addTask(task3);
    }

    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
        todoList = null;
    }

    @Test
    public void testAddTask() {
        Task newTask = new Task("Exercise");
        todoList.addTask(newTask);

        Task fetched = todoList.getTask("Exercise");
        assertNotNull("Task should be added to the list", fetched);
        assertEquals("Task description should match", "Exercise", fetched.getDescription());
        //fail("Not implemented yet");
    }

    @Test
    public void testGetStatus() {
        //fail("Not implemented yet");
        assertTrue("Completed task should return true", todoList.getStatus("Do homework"));
        assertFalse("Incomplete task should return false", todoList.getStatus("Play game"));
    }

    @Test
    public void testRemoveTask() {
        Task removed = todoList.removeTask("Pay bills");
        assertNotNull("Removed task should not be null", removed);
        assertEquals("Removed task should be 'Pay bills'", "Pay bills", removed.getDescription());
        assertNull("Removed task should no longer exist in list", todoList.getTask("Pay bills"));
        //fail("Not implemented yet");
    }

    @Test
    public void testGetCompletedTasks() {
        //fail("Not implemented yet");
        todoList.completeTask("Play game");

        Collection<Task> completedTasks = todoList.getCompletedTasks();
        assertEquals("There should be 2 completed tasks", 2, completedTasks.size());
        assertTrue(completedTasks.stream().anyMatch(t -> t.getDescription().equals("Do homework")));
        assertTrue(completedTasks.stream().anyMatch(t -> t.getDescription().equals("Play game")));
    }
}