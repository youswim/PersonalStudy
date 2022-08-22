package own.login.form;

import lombok.Getter;
import lombok.Setter;
import own.login.domain.Grade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MemberLoginForm {


    @NotBlank
    private String loginId;

    @NotBlank
    private String loginPasswd;

    @Override
    public String toString() {
        return "MemberLoginForm{" +
                "loginId='" + loginId + '\'' +
                ", loginPasswd='" + loginPasswd + '\'' +
                '}';
    }
}
