package tests;

import org.junit.jupiter.api.*;

public class testExample {

    @BeforeEach
    void start_browser(){
        System.out.println("browser has started");
    }
    @AfterEach
    void stop_browser(){
        System.out.println("browser has stopped");
    }
    @BeforeAll
    static void startup(){
        System.out.println("startup");
    }
    @AfterAll
    static void teardown(){
        System.out.println("teardown");
    }
    @Test
    void first_test() {
        System.out.println("first_test");
    }
    @Test
    void second_test() {
        System.out.println("second_test");
    }
}
