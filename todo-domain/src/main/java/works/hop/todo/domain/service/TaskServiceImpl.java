package works.hop.todo.domain.service;

import works.hop.todo.domain.model.Result;
import works.hop.todo.domain.model.Task;
import works.hop.todo.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    final TaskRepository repository;

    public TaskServiceImpl(@Autowired TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result<Task> createTask(String task){
        return Result.of(repository.save(new Task(null, task, false)));
    }

    @Override
    public Result<Task> updateTask(Long id){
        Task entity = repository.findById(id).get();
        entity.setCompleted(!entity.getCompleted());
        return Result.of(repository.save(entity));
    }

    @Override
    public Result<List<Task>> getAllTasks(){
        List<Task> tasks = new ArrayList<>();
        repository.findAll().forEach(tasks::add);
        return Result.of(tasks);
    }

    @Override
    public Result<Integer> deleteTask(Long id){
        repository.deleteById(id);
        return Result.of(1);
    }
}
