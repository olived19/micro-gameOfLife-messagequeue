package messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class NewWorldGenerated extends Message {
    private List<List<Boolean>> grid;
    private int generation;

    @JsonCreator
    public NewWorldGenerated(@JsonProperty("correlationId")String correlectionId, @JsonProperty("grid")List<List<Boolean>> grid, @JsonProperty("generation")int generation) {
        this.correlationId = correlectionId;
        this.grid = grid;
        this.generation = generation;
    }

    public static NewWorldGenerated fromString(String str) {
        ObjectMapper mapper = new ObjectMapper();
        NewWorldGenerated obj = null;
        try {
            obj = mapper.readValue(str, NewWorldGenerated.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    @JsonProperty("grid")
    public List<List<Boolean>> getGrid() {
        return this.grid;
    }

    @JsonProperty("generation")
    public int getGeneration() {
        return this.generation;
    }
}
