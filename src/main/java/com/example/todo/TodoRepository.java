package com.example.todo;

import java.util.ArrayList;

public interface TodoRepository {
	
	ArrayList <Todo> getTodoList();
    
	Todo addTodo(Todo todo);

	Todo getTodoById(int todoId);

	Todo updateTodo(int todoId, Todo todo);
    
    void deleteTodo(int todoId);

}
