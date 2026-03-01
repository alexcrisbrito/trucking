package mz.co.nextgenit.trucking.service;

import lombok.RequiredArgsConstructor;
import mz.co.nextgenit.trucking.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


}
