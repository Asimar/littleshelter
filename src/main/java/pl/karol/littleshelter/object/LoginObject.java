package pl.karol.littleshelter.object;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginObject {
	
	@NotNull
    @Size(min=2, max=30)
    private String email;

    @NotNull
    @Size(min=1, max=50)
    private String password;

}
