/*
 * package com.javainuse.test;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertNotNull; import static org.mockito.Mockito.doThrow;
 * import static org.mockito.Mockito.mock; import static
 * org.mockito.Mockito.verify; import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import java.sql.Connection; import java.sql.Statement;
 * 
 * import static org.mockito.Mockito.*; import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 * 
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.jupiter.api.Disabled; import org.mockito.InjectMocks; import
 * org.mockito.Mock; import org.mockito.Mockito; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.test.context.junit.jupiter.DisabledIf; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.ResultActions; import
 * org.springframework.test.web.servlet.setup.MockMvcBuilders; import
 * org.springframework.web.context.WebApplicationContext;
 * 
 * import com.fasterxml.jackson.databind.ObjectMapper; import
 * com.javainuse.controllers.EmployeeService; import
 * com.javainuse.controllers.TestController; import
 * com.javainuse.model.Employee;
 * 
 * public class TestWebApp extends SpringBootHelloWorldTests {
 * 
 * @Autowired private WebApplicationContext webApplicationContext;
 * 
 * private MockMvc mockMvc;
 * 
 * @InjectMocks private TestController controller1;
 * 
 * @InjectMocks private EmployeeService employeeService;
 * 
 * @Autowired private ObjectMapper objectMapper;
 * 
 * //@InjectMocks private DBConnection dbConnection;
 * 
 * @Mock private Connection mockConnection;
 * 
 * @Mock private Statement mockStatement;
 * 
 * @Before public void setup() { mockMvc =
 * MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); }
 * 
 * @DisabledIf
 * 
 * @Test public void testEmployee() throws Exception {
 * mockMvc.perform(get("/employee")).andExpect(status().isOk())
 * .andExpect(content().contentType("application/json;charset=UTF-8"))
 * .andExpect(jsonPath("$.name").value("emp")).andExpect(jsonPath(
 * "$.designation").value("manager"))
 * .andExpect(jsonPath("$.empId").value("1")).andExpect(jsonPath("$.salary").
 * value(3000));
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * @Test public void testSave() throws Exception{
 * 
 * 
 * 
 * Mockito.doThrow(NullPointerException.class).when(controller1).empInfo(Mockito
 * .anyObject());
 * 
 * //Mockito.when(employeeService.saveEmp(any(Employee.class))).thenThrow(
 * NullPointerException.class);
 * 
 * doThrow(new
 * RuntimeException("Simulated exception")).when(controller1).empInfo(any(
 * Employee.class)); ResultActions
 * resultActions=mockMvc.perform(get("/saveEmp")); Employee expectedEmployee =
 * new Employee(); expectedEmployee.setName("Anil");
 * expectedEmployee.setDesignation("javaDevloper");
 * expectedEmployee.setEmpId("2"); expectedEmployee.setSalary(100000);
 * 
 * String expectedJson = objectMapper.writeValueAsString(expectedEmployee);
 * 
 * // assertNotNull(expectedEmployee1);
 * 
 * //
 * Mockito.doThrow(NullPointerException.class).when(controller1).empInfo(Mockito
 * .anyObject());
 * 
 * resultActions.andExpect(status().isOk())
 * .andExpect(content().json(expectedJson));
 * 
 * }
 * 
 * 
 * 
 * 
 * @Test public void testSave1() throws Exception{ ResultActions
 * resultActions=mockMvc.perform(get("/saveEmp")); Employee expectedEmployee =
 * new Employee(); expectedEmployee.setName("Anil");
 * expectedEmployee.setDesignation("javaDevloper");
 * expectedEmployee.setEmpId("2"); expectedEmployee.setSalary(100000); String
 * expectedJson = objectMapper.writeValueAsString(expectedEmployee);
 * resultActions.andExpect(status().isOk())
 * .andExpect(content().json(expectedJson));
 * 
 * }
 * 
 * 
 * 
 * 
 * //@Disabled
 * 
 * @Test public void testSaves() {
 * 
 * Employee expectedEmployee=null; controller1.empInfo(expectedEmployee);
 * //assertEquals(null, Exception.class,expectedEmployee );
 * 
 * 
 * }
 * 
 * 
 * 
 * @Test public void testMockDBConnection() throws Exception {
 * Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
 * Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).
 * thenReturn(1); mockConnection.execute; Assert.assertEquals(value, 1);
 * Mockito.verify(mockConnection.createStatement(), Mockito.times(1)); }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @DisabledIf
 * 
 * @Test public void testFirstPage() throws Exception { // Mock the behavior of
 * your service or repository if needed
 * 
 * // Perform the GET request ResultActions resultActions =
 * mockMvc.perform(get("/employee"));
 * 
 * // Validate the response resultActions.andExpect(status().isOk())
 * .andExpect(content().contentType("application/json"))
 * .andExpect(jsonPath("$.name").value("emp1"))
 * .andExpect(jsonPath("$.designation").value("manager"))
 * .andExpect(jsonPath("$.empId").value("1"))
 * .andExpect(jsonPath("$.salary").value(3000)); }
 * 
 * 
 * @Test public void testEmpInfo() { // Create a mock of EmployeeService
 * EmployeeService employeeServiceMock = mock(EmployeeService.class);
 * 
 * 
 * // Create an instance of Employee Employee employee = new Employee();
 * employee.setName("John"); employee.setDesignation("Developer");
 * employee.setSalary(80000);
 * 
 * // Define the behavior using 'doThrow' to simulate an exception doThrow(new
 * RuntimeException("Simulated exception")).when(employeeServiceMock).saveEmp(
 * employee);
 * 
 * // Call the method under test Employee resultEmployee =
 * controller1.empInfo(employee);
 * 
 * // Verify the interaction using 'verify'
 * verify(employeeServiceMock).saveEmp(employee);
 * 
 * // Verify that the catch block was executed and the original employee object
 * was returned assertNotNull(resultEmployee); assertEquals("John",
 * resultEmployee.getName()); assertEquals("Developer",
 * resultEmployee.getDesignation()); assertEquals(80000,
 * resultEmployee.getSalary()); }
 * 
 * 
 * 
 * 
 * 
 * @Test public void getProductsList() throws Exception { String uri =
 * "/products"; MvcResult mvcResult =
 * mockMvc.perform(MockMvcRequestBuilders.get(uri)
 * .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
 * 
 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
 * String content = mvcResult.getResponse().getContentAsString(); Product[]
 * productlist = super.mapFromJson(content, Product[].class);
 * assertTrue(productlist.length > 0); }
 * 
 * }
 */