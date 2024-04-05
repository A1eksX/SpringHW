package com.HW.HW5v1;

import com.HW.HW5v1.model.Task;
import com.HW.HW5v1.repository.TaskRepository;
import com.HW.HW5v1.services.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.HW.HW5v1.TaskStatus.IN_PROGRESS;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class Hw10ApplicationTests {

	@Mock
	private TaskRepository repository;
	@InjectMocks
	private TaskService service;


	@Test
	public void findTaskByStatusTest(){
		Task task = new Task();
		task.setStatus(IN_PROGRESS);
		task.setDescription("dasdasdasd");

		List<Task> taskList = new ArrayList<>();
		taskList.add(task);

		given(repository.findTaskByStatus(IN_PROGRESS)).willReturn(taskList);

		service.findTaskByStatus(IN_PROGRESS);

		verify(repository).findTaskByStatus(IN_PROGRESS);
	}

	@Test
	public void addTaskTest(){
		Task task = new Task();
		task.setStatus(IN_PROGRESS);
		task.setDescription("dasdasdasd");

		given(repository.save(task)).willReturn(task);

		service.addTask(task);

		verify(repository).save(task);
	}

}
