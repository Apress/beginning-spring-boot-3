/**
 * 
 */
package com.apress.demo.controllers;

import com.apress.demo.entities.Todo;
import com.apress.demo.repositories.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * @author Siva
 *
 */
@WebMvcTest(controllers= TodoController.class)
public class TodoControllerTests {

	@Autowired
    private MockMvc mvc;

    @MockBean
    private TodoRepository todoRepository;

    @Test
    public void testFindTodoById() throws Exception {
    	Todo todo1 = new Todo(1, "Todo1",false);
    	Todo todo2 = new Todo(2, "Todo2",true);
    	
    	given(this.todoRepository.findAll()).willReturn(Arrays.asList(todo1, todo2));
        this.mvc.perform(get("/todolist")
        		.with(user("admin").password("admin123").roles("USER","ADMIN"))
        		.accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("todos"))
                .andExpect(model().attribute("todos", hasSize(2)))
                ;
 
        verify(todoRepository, times(1)).findAll();
    }
    
}
