package StepDefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Todos;
import models.Users;
import org.junit.jupiter.api.function.Executable;
import service.TodosService;
import service.UsersService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinations {

    List<String> users;
    Todos[] todos;
    List<Users> result;
    List<Integer> fancodeCityUsers;

    UsersService usersService = UsersService.init();
    TodosService todosService = TodosService.init();

    @When("User has the todo tasks")
    public void userGetToDoTaskList() {
        try {
            todos = todosService.getTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("User belongs to the city FanCode")
    public void fetchTheUsersBelongToFancodeCity() {
        try {
            fancodeCityUsers = usersService.getFancodeCityUserIDs(usersService.getAllUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("User Completed task percentage should be greater than {int}%")
    public void validateUsersCompletedTasksPercentageIsGreaterThan(int percentage) {

        List<Users> result = usersService.
                getUsersList(todosService.
                        getTasksStatusForEachUsers(todos, fancodeCityUsers));

        Map<Integer, Map<Boolean, Long>> tasksStatus = todosService.getTasksStatusForEachUsers(todos, fancodeCityUsers);

        List<Executable> assertions = result.stream().map(user -> (Executable) () -> {
            Map<Boolean, Long> userTasksStatus = tasksStatus.get(user.getId());
            double completedPercentage = TodosService.calculateCompletedPercentage(userTasksStatus);
            assertTrue(completedPercentage > percentage,
                    "User " + user.getId() + " has less than " + percentage + "% tasks completed");
        }).collect(Collectors.toList());

        assertAll("User task completion percentage validation", assertions);
    }
}
