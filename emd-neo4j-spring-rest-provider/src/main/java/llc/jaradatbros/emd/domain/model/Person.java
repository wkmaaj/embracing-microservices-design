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
package llc.jaradatbros.emd.domain.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@Node
public class Person {
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;

    private String name;

    private Person() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    public Person(String name) {
        this.name = name;
    }

    /**
     * Neo4j doesn't REALLY have bi-directional relationships.
     * It just means when querying to ignore the direction of the relationship.
     *
     * @see https://dzone.com/articles/modelling-data-neo4j
     */
    @Relationship(type = "TEAMMATE")
    public Set<Person> teammates;

    public void worksWith(Person person) {
        if(teammates == null) {
            teammates = new HashSet<>();
        }
        teammates.add(person);
    }

    public String toString() {
        return this.name + "'s teammates => "
            + Optional
                .ofNullable(this.teammates)
                .orElse(Collections.emptySet())
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }
}
