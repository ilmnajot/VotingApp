package uz.ilmnajot.vottingapp.dto;

import lombok.Data;
import uz.ilmnajot.vottingapp.entity.enums.CandidateName;

@Data
public class UserForm {

    private String fullName;

    private String email;

    private String phoneNumber;

    private CandidateName candidate;
}
