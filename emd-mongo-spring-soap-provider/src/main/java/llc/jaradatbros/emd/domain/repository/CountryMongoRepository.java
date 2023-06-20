package llc.jaradatbros.emd.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import llc.jaradatbros.emd.api.soap.mongo.Currency;
import llc.jaradatbros.emd.domain.model.Country;


@Repository("CountriesRepository")
interface CountryMongoRepository extends BaseMongoRepository<Country> {
    List<Country> findByCapital(String capital);
    List<Country> findByCurrency(Currency currency);
}
