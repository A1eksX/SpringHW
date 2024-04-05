package com.HW.HW5v1;

import com.HW.HW5v1.model.Task;
import com.HW.HW5v1.repository.TaskRepository;
import com.HW.HW5v1.services.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.After;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.HW.HW5v1.TaskStatus.COMPLETED;
import static com.HW.HW5v1.TaskStatus.IN_PROGRESS;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class HW10IntegrationTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    @MockBean
    private TaskRepository repository;

    @AfterEach
    public void clear(){
        repository.deleteAll();
    }

    @Test
    public void itGetAllNoteTest() throws Exception{

        addTestTaskList();

        given(repository.findAll()).willReturn(addTestTaskList());

        mvc.perform(
                get("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].status", Matchers.is("COMPLETED")));
    }

    public List<Task> addTestTaskList(){
        Task task1 = new Task();
        task1.setStatus(IN_PROGRESS);
        task1.setDescription("qqq");

        Task task2 = new Task();
        task2.setStatus(COMPLETED);
        task2.setDescription("www");

        List<Task> list = new ArrayList<>();
        list.add(task1);
        list.add(task2);

        return list;
    }

    public Task addTestTask(){
        Task task = new Task();
        task.setStatus(IN_PROGRESS);
        task.setDescription("eee");
        return task;
    }
}
