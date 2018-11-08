package br.edu.ulbra.election.party.repository;

import br.edu.ulbra.election.party.model.Party;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PartyRepository extends CrudRepository<Party, Long> {
    Optional<Party> findByCode(String code);
    Optional<Party> findByNumber(Integer number);
}
