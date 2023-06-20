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

import java.util.List;

import org.springframework.stereotype.Repository;

import llc.jaradatbros.emd.api.soap.mongo.Currency;
import llc.jaradatbros.emd.domain.model.Country;


@Repository("CountriesRepository")
public interface CountryMongoRepository extends BaseMongoRepository<Country> {
    List<Country> findByCapital(String capital);
    List<Country> findByCurrency(Currency currency);
}
