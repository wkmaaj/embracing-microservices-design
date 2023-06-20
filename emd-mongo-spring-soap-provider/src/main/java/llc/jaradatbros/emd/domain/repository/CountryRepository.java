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
package llc.jaradatbros.emd.domain.repository;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import jakarta.annotation.PostConstruct;
import llc.jaradatbros.emd.api.soap.mongo.Country;
import llc.jaradatbros.emd.api.soap.mongo.Currency;

@Deprecated(since = "0.0.2-SNAPSHOT", forRemoval = true)
@Repository("DeprecatedCountryRepository")
public class CountryRepository {
    private static final Map<String, Country> COUNTRIES = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(BigInteger.valueOf(46704314));
        COUNTRIES.put(spain.getName(), spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(BigInteger.valueOf(704314));
        COUNTRIES.put(poland.getName(), poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(BigInteger.valueOf(2704314));
        COUNTRIES.put(uk.getName(), uk);

        Country us = new Country();
        us.setName("United States");
        us.setCapital("Washington D.C.");
        us.setCurrency(Currency.USD);
        us.setPopulation(BigInteger.valueOf(9704314));
        COUNTRIES.put(us.getName(), us);

        Country jo = new Country();
        jo.setName("Jordan");
        jo.setCapital("Amman");
        jo.setCurrency(Currency.JOR);
        jo.setPopulation(BigInteger.valueOf(4314));
        COUNTRIES.put(jo.getName(), jo);
    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null.");
        return COUNTRIES.get(name);
    }
}