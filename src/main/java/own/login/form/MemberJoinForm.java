package own.login.form;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import own.login.domain.Grade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
public class MemberJoinForm {

    @NotBlank
    private String loginId;

    @NotBlank
    private String loginPasswd;

    @NotNull
    private Grade grade;

}
