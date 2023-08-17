package uz.ilmnajot.vottingapp.service;

import org.springframework.stereotype.Service;
import uz.ilmnajot.vottingapp.dto.UserForm;
import uz.ilmnajot.vottingapp.entity.User;
import uz.ilmnajot.vottingapp.entity.enums.CandidateName;
import uz.ilmnajot.vottingapp.message.ApiResponse;
import uz.ilmnajot.vottingapp.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ApiResponse addVote(UserForm form) {
        Optional<User> optionalUser = userRepository.findUserByEmail(form.getEmail());
        if (optionalUser.isEmpty()) {
            User user  = new User();
            user.setFullName(form.getFullName());
            user.setEmail(form.getEmail());
            user.setCandidateName(form.getCandidate());
            user.setPhoneNumber(form.getPhoneNumber());
            userRepository.save(user);
            return new ApiResponse("you have voted successfully", true);
        } else {
            return new ApiResponse("you have already voted with " + form.getEmail() + " this email ", false);
        }
    }

    @Override
    public User getUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            Optional<User> optionalUser = userRepository.findById(id);
            return optionalUser.orElse(null);
        }
        return null;
    }
}
