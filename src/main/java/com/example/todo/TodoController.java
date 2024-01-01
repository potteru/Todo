package com.example.todo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	TodoService todoService = new TodoService();
	
	@GetMapping("/todos")
    public ArrayList<Todo> get_Todo_List(){

        return todoService.getTodoList();
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo){

        return todoService.addTodo(todo);
    }

     @GetMapping("/todos/{todoId}")
    public Todo getTodoById(@PathVariable("todoId") int todoId){

        return todoService.getTodoById(todoId);
    } 
    
    @PutMapping("/todos/{todoId}")
    public Todo updateTodo(@PathVariable("todoId") int todoId, @RequestBody Todo todo) {

        return todoService.updateTodo(todoId, todo);
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteMovie(@PathVariable("movieId") int todoId) {
    
    	todoService.deleteTodo(todoId);
        
    }

}
