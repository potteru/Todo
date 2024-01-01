package com.example.todo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TodoService implements TodoRepository{
	
	private static HashMap<Integer, Todo> todoList = new HashMap<>();
	int uniqueTodoId = 12;
	
    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }
    
    @Override
    public ArrayList<Todo> getTodoList() {
        Collection<Todo> todo_list = todoList.values();
        ArrayList<Todo> arrList = new ArrayList<>(todo_list);
        return arrList;
    }

    @Override
    public Todo getTodoById(int todoId){
    	Todo to_do = todoList.get(todoId);
        if(to_do == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return to_do;
    }

    @Override
    public Todo addTodo(Todo todo){
    	todo.setId(uniqueTodoId);
    	todoList.put(uniqueTodoId, todo);
        uniqueTodoId += 1;
        return todo;
        
    }

    @Override
    public Todo updateTodo(int todoId, Todo todo) {
    	Todo existingTodo = todoList.get(todoId);

        if(existingTodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (todo.getId() != 0 ) {
            existingTodo.setId(todoId);
        }
        
        if (todo.getTodo() != null) {
            existingTodo.setTodo(todo.getTodo());
        }
        return existingTodo;
    }
    
    @Override
    public void deleteTodo(int todoId){
    	Todo todo = todoList.get(todoId);

        if(todo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        else{
        	todoList.remove(todoId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        
    }

}
