package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.Country;
import kg.inai.equeuesystem.models.CountryModel;

import java.util.List;

public interface CountryService {
    Country create(CountryModel countryModel);
    Country update(CountryModel countryModel);
    List<Country> findAll();
    Country getById(Long id);
}
