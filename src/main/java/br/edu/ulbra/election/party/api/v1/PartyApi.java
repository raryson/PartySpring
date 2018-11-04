package br.edu.ulbra.election.party.api.v1;


import br.edu.ulbra.election.party.input.v1.PartyInput;
import br.edu.ulbra.election.party.output.v1.GenericOutput;
import br.edu.ulbra.election.party.output.v1.PartyOutput;
import br.edu.ulbra.election.party.service.PartyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/v1/party")
public class PartyApi {

    private final PartyService _partyService;

    @Autowired
    public PartyApi(PartyService partyService){
        _partyService = partyService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Get parties List")
    public List<PartyOutput> getAll() {
        return _partyService.getAll();
    }

    @GetMapping("/{partyId}")
    @ApiOperation(value = "Get party by Id")
    public PartyOutput getById(@PathVariable Long partyId) {
        return _partyService.getById(partyId);
    }

    @PostMapping("/")
    @ApiOperation(value = "Create new party")
    public PartyOutput create(@RequestBody PartyInput partyInput) {
        return _partyService.create(partyInput);
    }

    @PutMapping("/{partyId}")
    @ApiOperation(value = "Update party")
    public PartyOutput update(@PathVariable Long partyId, @RequestBody PartyInput partyInput){
        return _partyService.update(partyId, partyInput);
    }

    @DeleteMapping("/{partyId}")
    @ApiOperation(value = "Delete party")
    public GenericOutput delete(@PathVariable Long partyId) {
        return _partyService.delete(partyId);
    }
}
