package net.binarypaper.sqlitedatajdbc.greeting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.StreamSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class GreetingRepositoryTest {

  @Autowired private GreetingRepository greetingRepository;

  @BeforeEach
  void setUp() {
    greetingRepository.save(new Greeting(null, "Greeting 1"));
    greetingRepository.save(new Greeting(null, "Greeting 2"));
    greetingRepository.save(new Greeting(null, "Greeting 3"));
    greetingRepository.save(new Greeting(null, "Greeting 4"));
    greetingRepository.save(new Greeting(null, "Greeting 5"));
    greetingRepository.save(new Greeting(null, "Greeting 6"));
    greetingRepository.save(new Greeting(null, "Greeting 7"));
    greetingRepository.save(new Greeting(null, "Greeting 8"));
    greetingRepository.save(new Greeting(null, "Greeting 9"));
    greetingRepository.save(new Greeting(null, "Greeting 10"));
  }

  @Test
  void addGreetingAndFindById() {
    Greeting greeting = new Greeting(null, "Hello World");
    greeting = greetingRepository.save(greeting);
    assertNotNull(greeting.id());
    assertEquals("Hello World", greeting.message());
    Greeting findGreeting = greetingRepository.findById(greeting.id()).orElse(null);
    assertNotNull(findGreeting);
    assertEquals(greeting.id(), findGreeting.id());
    assertEquals("Hello World", findGreeting.message());
    Iterable<Greeting> greetings = greetingRepository.findAll();
    assertEquals(11, StreamSupport.stream(greetings.spliterator(), false).count());
  }

  @Test
  void findAll() {
    Iterable<Greeting> greetings = greetingRepository.findAll();
    assertEquals(10, StreamSupport.stream(greetings.spliterator(), false).count());
  }
}
