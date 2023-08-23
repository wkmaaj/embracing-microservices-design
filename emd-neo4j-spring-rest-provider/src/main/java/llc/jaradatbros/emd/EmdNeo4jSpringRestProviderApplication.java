/**
 * Copyright 2023 JaradatBros LLC.
 *
 * Licensed under the MIT License ("the License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://spdx.org/licenses/MIT.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package llc.jaradatbros.emd;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import llc.jaradatbros.emd.domain.model.Person;
import llc.jaradatbros.emd.domain.repository.PersonRepository;

@SpringBootApplication
@EnableNeo4jRepositories
public class EmdNeo4jSpringRestProviderApplication {
    private final static Logger log = LoggerFactory.getLogger(EmdNeo4jSpringRestProviderApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EmdNeo4jSpringRestProviderApplication.class, args);
        System.exit(0);
    }

    @Bean
    CommandLineRunner demo(PersonRepository personRepository) {
        return args -> {
            personRepository.deleteAll();

            Person greg = new Person("Greg");
            Person roy = new Person("Roy");
            Person craig = new Person("Craig");
            List<Person> team = Arrays.asList(greg, roy, craig);
            log.info("Before linking up with Neo4j...");
            team.stream().forEach(
                person -> {
                    log.info("\t" + person.toString());
                    personRepository.save(person);
                }
            );
            log.info("Successfully saved PERSON entries.");

            log.info("Retrieving PERSON: " + greg.getName());
            greg = personRepository.findByName(greg.getName());
            greg.worksWith(roy);
            greg.worksWith(craig);
            personRepository.save(greg);

            log.info("Retrieving PERSON: " + roy.getName());
            roy = personRepository.findByName(roy.getName());
            roy.worksWith(craig);
            personRepository.save(roy);

            log.info("Lookup each person by name...");
            team.stream().forEach(
                person -> log.info("\t" + personRepository.findByName(person.getName()).toString())
            );

            List<Person> teammates = personRepository.findByTeammatesName(greg.getName());
            log.info("The following have Greg as a teammate...");
            teammates.stream().forEach(
                person -> log.info("\t" + person.getName())
            );
        };
    }

}
