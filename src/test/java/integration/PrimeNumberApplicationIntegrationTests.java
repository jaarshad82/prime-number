package integration;

import com.rbs.technicaltest.primenumber.PrimeNumberApplication;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PrimeNumberApplication.class)
@AutoConfigureMockMvc
class PrimeNumberApplicationIntegrationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void primeNumberApplicationTest() throws Exception {
    Set expectedPrimes = new LinkedHashSet();
    Collections.addAll(expectedPrimes, 2, 3, 5, 7, 11);

    mockMvc.perform(get("/primes/11")
        .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.initial").value("11"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.primes", Matchers.contains(2, 3, 5, 7, 11)));
  }
}
