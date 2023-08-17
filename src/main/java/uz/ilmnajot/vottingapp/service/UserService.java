package uz.ilmnajot.vottingapp.service;

import uz.ilmnajot.vottingapp.dto.UserForm;
import uz.ilmnajot.vottingapp.entity.User;
import uz.ilmnajot.vottingapp.message.ApiResponse;

public interface UserService {
    ApiResponse addVote(UserForm form);

    User getUser(Long id);
}
